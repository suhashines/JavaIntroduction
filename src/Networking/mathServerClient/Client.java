package Networking.mathServerClient;

import Networking.mathServerClient.models.Operation;
import Networking.mathServerClient.models.Request;
import Networking.mathServerClient.models.Response;
import Networking.util.SocketWrapper;

import java.io.IOException;
import java.util.Scanner;

public class Client {

    public static final String ip = "localhost";
    public static final int PORT = 5000 ;


    public static void main(String[] args) throws IOException {

        try{
            SocketWrapper serverSocket = new SocketWrapper(ip,PORT);

            System.out.println("connected to server");

            System.out.println("Enter operation: ADD,MUL,SUB,DIV");

            Scanner scn = new Scanner(System.in);

            String opStr = scn.next().toUpperCase();
            Operation op = Operation.valueOf(opStr);

            System.out.println("Enter two numbers:");

            double a = scn.nextDouble();
            double b = scn.nextDouble();

            serverSocket.write(new Request(op,a,b));
//
            Response resp = (Response) serverSocket.read();

            if(resp.statusCode==1){
                System.out.println("server said: "+ resp.result);
            }else{
                System.out.println("server said invalid operation");
            }
            serverSocket.closeConnection();

        }catch(Exception e){
            System.out.println("error occurred");
        }


    }
}
