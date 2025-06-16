package Networking.helloServerClient;

import Networking.util.SocketWrapper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    // ip address -> local machine -> ip -> localhost:127.0.0.1
    // port = 5000 ;

    public static final int PORT = 5000 ;

    ServerSocket serverSocket;

    Server() throws IOException {

        serverSocket = new ServerSocket(PORT);
    }

    public void handleClient(SocketWrapper clientSocket) throws IOException, ClassNotFoundException {

        // receiving a msg from client
//        ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
        String msg = (String)clientSocket.read();
        System.out.println("client sent: "+msg);

        Scanner scn = new Scanner(System.in);
        String reply = scn.nextLine();

//        ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
        clientSocket.write(reply);

        clientSocket.closeConnection();
    }

    public void run() throws IOException, ClassNotFoundException {

        System.out.println("Server is running at port "+PORT);

        Socket clientSocket = serverSocket.accept(); //blocking system call

        System.out.println("client has arrived");

        handleClient(new SocketWrapper(clientSocket));
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Server server = new Server();
        server.run();
    }
}