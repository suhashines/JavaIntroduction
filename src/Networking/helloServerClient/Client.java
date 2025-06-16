package Networking.helloServerClient;

import Networking.util.SocketWrapper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static final String ip = "localhost";
    public static final int PORT = 5000 ;


    public static void main(String[] args) throws IOException {

        try{
            SocketWrapper serverSocket = new SocketWrapper(ip,PORT);

            System.out.println("connected to server");

            Scanner scn = new Scanner(System.in);

            String msg = scn.nextLine();

//            ObjectOutputStream oos = new ObjectOutputStream(serverSocket.getOutputStream());

            serverSocket.write(msg);

//            ObjectInputStream ois = new ObjectInputStream(serverSocket.getInputStream());

            String reply = (String)serverSocket.read();

            System.out.println("server sent: "+reply);

//            oos.close();
//            ois.close();
            serverSocket.closeConnection();

        }catch(Exception e){
            System.out.println("error occurred");
        }



    }
}
