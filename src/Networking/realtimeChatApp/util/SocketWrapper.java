package Networking.realtimeChatApp.util;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

/**
 * Simple Socket wrapper that sends/receives line-based messages.
 * Methods are blocking; receive() returns null if the connection is closed.
 */
public class SocketWrapper {
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    public SocketWrapper(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
    }

    /**
     * Send a line (appends newline automatically).
     */
    public synchronized void send(String message) {
        out.println(message);
    }

    /**
     * Blocking receive. Returns null if stream closed or on IOException.
     */
    public String receive() {
        try {
            String line = in.readLine();
            return line;
        } catch (SocketException se) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public void close() {
        try { in.close(); } catch (Exception ignored) {}
        try { out.close(); } catch (Exception ignored) {}
        try { socket.close(); } catch (Exception ignored) {}
    }

    public String getRemoteAddress() {
        return socket.getInetAddress().getHostAddress();
    }
}
