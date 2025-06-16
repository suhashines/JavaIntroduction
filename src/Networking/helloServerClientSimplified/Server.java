package Networking.helloServerClientSimplified;

import Networking.util.SocketWrapper;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Listening on port " + port + "...");

//            while (true) {
                Socket clientSocket = serverSocket.accept(); // Accept client connection
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                    SocketWrapper socketWrapper = new SocketWrapper(clientSocket);
                    // Read message from client
                    String message = (String) socketWrapper.read();
                    System.out.println("Received from client: " + message);

                    // Send response to client
                    socketWrapper.write("Hello Client");
                    System.out.println("Replied to client.");

//                }
            }catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
        }