package Networking.practice;

import Networking.util.SocketWrapper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static final int PORT = 5000;

    ServerSocket serverSocket;

    Server() throws IOException {
        serverSocket = new ServerSocket(PORT); //ip missing,why? local machine ip = server ip = localhost(127.0.0.0)
    }

    public void handleClient(Socket clientSocket) throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
        String msg = (String)ois.readObject();
        System.out.println("client sent: "+msg);

        Scanner scn = new Scanner(System.in);
        String reply = scn.nextLine();

        ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
        oos.writeObject(reply);
    }

    public void run() throws IOException, ClassNotFoundException {

        System.out.println("Server is running at port "+PORT);


        Socket clientSocket = serverSocket.accept(); //blocking statement

        System.out.println("client has arrived");

        handleClient(clientSocket);

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Server server = new Server();
        server.run();
    }
}
