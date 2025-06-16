package Networking.practice;

import Networking.util.SocketWrapper;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static final int PORT = 5000;
    public static final String ip = "localhost";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try(Socket serverSocket = new Socket("localhost",PORT)){

            System.out.println("connected to server");

            Scanner scn = new Scanner(System.in);
            String msg = scn.nextLine();

            ObjectOutputStream oos = new ObjectOutputStream(serverSocket.getOutputStream());
            oos.writeObject(msg);

            ObjectInputStream ois = new ObjectInputStream(serverSocket.getInputStream());
            String reply = (String)ois.readObject();

            System.out.println("server sent: "+reply);

            oos.close();
            ois.close();

        }catch(Exception e){
            System.out.println("error occurred");
        }


    }
}
