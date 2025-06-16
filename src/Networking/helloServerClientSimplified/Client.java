package Networking.helloServerClientSimplified;

import Networking.util.SocketWrapper;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host = "localhost";
        int port = 5000;

           SocketWrapper socketWrapper = new SocketWrapper(host, port);
            System.out.println("Connected to server at " + host + ":" + port);

            // Send "Hello Server" message
            socketWrapper.write("Hello Server");
            System.out.println("Sent to server: Hello Server");

            // Read response from server
            String response = (String) socketWrapper.read();
            System.out.println("Received from server: " + response);

    }
}