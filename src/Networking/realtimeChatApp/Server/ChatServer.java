package Networking.realtimeChatApp.Server;

import Networking.realtimeChatApp.util.SocketWrapper;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ChatServer (fixed): unified client handler so that when the second client arrives
 * an existing handler will forward messages as expected.
 */
public class ChatServer {
    private final int port;
    private SocketWrapper client1 = null;
    private SocketWrapper client2 = null;
    private volatile boolean running = true;

    public ChatServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("[Server] Listening on port " + port);

            // Console thread for server operator replies (single-client mode)
            new Thread(this::consoleLoop, "Server-Console-Thread").start();

            while (running) {
                Socket socket = serverSocket.accept();
                SocketWrapper wrapper = new SocketWrapper(socket);

                synchronized (this) {
                    if (client1 == null) {
                        client1 = wrapper;
                        System.out.println("Client-1 connected: " + wrapper.getRemoteAddress());
                        startClientHandler(1, wrapper);
                    } else if (client2 == null) {
                        client2 = wrapper;
                        System.out.println("Client-2 connected: " + wrapper.getRemoteAddress());
                        System.out.println("[Server] Connecting Client-1 ↔ Client-2");
                        startClientHandler(2, wrapper);

                        // notify both clients that chat started
                        if (client1 != null) client1.send("[Server] Another user joined. You are now connected to a stranger.");
                        if (client2 != null) client2.send("[Server] You are connected to a stranger.");
                    } else {
                        // limit: only 2 clients supported here
                        wrapper.send("Server busy. Only 2 clients supported in this demo. Try later.");
                        wrapper.close();
                    }
                }
            }
        } finally {
            shutdownAll();
        }
    }

    private void startClientHandler(int id, SocketWrapper wrapper) {
        Thread t = new Thread(() -> handleClient(id, wrapper), "ClientHandler-" + id);
        t.start();
    }

    /**
     * Unified handler:
     * - Always reads messages from its client socket.
     * - If other client exists -> forward the message to the other client.
     * - If other client does not exist -> print to server console (single-client mode).
     */
    private void handleClient(int id, SocketWrapper wrapper) {
        try {
            String who = (id == 1) ? "C1" : "C2";
            while (true) {
                String msg = wrapper.receive();
                if (msg == null) {
                    // client disconnected unexpectedly
                    break;
                }

                synchronized (this) {
                    SocketWrapper other = (wrapper == client1) ? client2 : client1;

                    if (other != null) {
                        // Phase 2 (both clients connected) -> forward to the other client
                        System.out.println("[Relaying] " + who + ": " + msg);
                        try {
                            other.send(msg);
                        } catch (Exception e) {
                            System.out.println("[Server] Failed to send to other client: " + e.getMessage());
                        }

                        // If exit, notify other and clean up
                        if ("exit".equals(msg.trim())) {
                            other.send("[Server] The other user has left the chat.");
                            // close both sides
                            try { other.close(); } catch (Exception ignored) {}
                            try { wrapper.close(); } catch (Exception ignored) {}
                            if (other == client1) client1 = null;
                            if (other == client2) client2 = null;
                            if (wrapper == client1) client1 = null;
                            if (wrapper == client2) client2 = null;
                            break;
                        }
                    } else {
                        // Phase 1 (single client): print on server console so operator can reply
                        System.out.println("Client: " + msg);

                        if ("exit".equals(msg.trim())) {
                            // inform client and cleanup
                            wrapper.send("Server: Goodbye!");
                            try { wrapper.close(); } catch (Exception ignored) {}
                            if (wrapper == client1) client1 = null;
                            if (wrapper == client2) client2 = null;
                            break;
                        }
                        // else wait for server operator to reply from consoleLoop()
                    }
                } // synchronized
            } // while
        } catch (Exception e) {
            System.out.println("Client handler exception: " + e.getMessage());
        } finally {
            try { wrapper.close(); } catch (Exception ignored) {}
            synchronized (this) {
                if (wrapper == client1) client1 = null;
                if (wrapper == client2) client2 = null;
            }
            System.out.println("Client disconnected.");
        }
    }

    /**
     * Console loop for server operator. When there is exactly 1 client connected,
     * server operator can directly send messages to that client.
     */
    private void consoleLoop() {
        Scanner sc = new Scanner(System.in);
        while (running) {
            String line = sc.nextLine();
            if ("shutdown".equalsIgnoreCase(line.trim())) {
                System.out.println("[Server] Shutting down by operator request.");
                running = false;
                shutdownAll();
                break;
            }
            synchronized (this) {
                // If only one client connected, our console acts as the server reply
                if (client1 != null && client2 == null) {
                    client1.send("Server: " + line);
                    if ("exit".equals(line.trim())) {
                        client1.send("Server: Goodbye!");
                        client1.close();
                        client1 = null;
                    }
                } else if (client2 != null && client1 == null) {
                    client2.send("Server: " + line);
                    if ("exit".equals(line.trim())) {
                        client2.send("Server: Goodbye!");
                        client2.close();
                        client2 = null;
                    }
                } else {
                    // no single-client interactive mode
                    System.out.println("[Server] No single client to send to (0 or 2 clients connected). Type 'shutdown' to stop server.");
                }
            }
        }
        sc.close();
    }

    private void shutdownAll() {
        synchronized (this) {
            try { if (client1 != null) { client1.send("[Server] Server shutting down."); client1.close(); } } catch (Exception ignored) {}
            try { if (client2 != null) { client2.send("[Server] Server shutting down."); client2.close(); } } catch (Exception ignored) {}
            client1 = null;
            client2 = null;
        }
    }

    public static void main(String[] args) throws IOException {
        int port = 12345;
        ChatServer server = new ChatServer(port);
        server.start();
    }
}
