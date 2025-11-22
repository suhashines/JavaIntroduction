package Networking.realtimeChatApp.client;

import Networking.realtimeChatApp.util.SocketWrapper;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * ChatClient:
 *  - Connects to server
 *  - Starts reader thread (prints messages from server)
 *  - Starts writer thread (reads console, sends to server)
 *
 * Usage: run ChatClient [host] [port]
 * Defaults: host=localhost, port=12345
 */
public class ChatClient {
    private final String host;
    private final int port;

    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        try (Socket socket = new Socket(host, port)) {
            SocketWrapper sw = new SocketWrapper(socket);
            System.out.println("Connected to server.");

            // Reader thread: prints what's received
            Thread reader = new Thread(() -> {
                while (true) {
                    String msg = sw.receive();
                    if (msg == null) {
                        System.out.println("Connection closed by server.");
                        break;
                    }
                    System.out.println(msg);
                }
            }, "Reader-Thread");
            reader.start();

            // Writer thread: reads from console and sends to server
            Scanner sc = new Scanner(System.in);
            while (true) {
                String line = sc.nextLine();
                sw.send(line);
                if ("exit".equals(line.trim())) {
                    // allow some time for message to be sent, then close
                    break;
                }
            }

            // cleanup
            sw.close();
            System.out.println("Disconnected from server.");
        } catch (IOException e) {
            System.out.println("Unable to connect to server: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;
        if (args.length >= 1) host = args[0];
        if (args.length >= 2) port = Integer.parseInt(args[1]);
        new ChatClient(host, port).start();
    }
}
