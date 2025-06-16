package Networking.multipleClientServer;

import Networking.multipleClientServer.models.Request;
import Networking.multipleClientServer.models.Response;
import Networking.util.SocketWrapper;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    // ip address -> local machine -> ip -> localhost:127.0.0.1
    // port = 5000 ;

    public static final int PORT = 5000 ;

    ServerSocket serverSocket;

    Server() throws IOException {

        serverSocket = new ServerSocket(PORT);
    }

    public Response processRequest(Request req){
        double result ;

        switch(req.op){
            case ADD :
                result = req.a + req.b ;
                break;
            case SUB:
                result = req.a - req.b ;
                break;
            case MUL:
                result = req.a * req.b ;
                break;
            case DIV:
                if(req.b == 0) return new Response(0,0);
                result = req.a/req.b ;
                break;
            default:
                return new Response(1,0);
        }

        return new Response(1,result);
    }

    public void handleClient(SocketWrapper clientSocket) throws IOException, ClassNotFoundException {

        // receiving a msg from client
        Request req = (Request)clientSocket.read();
        System.out.println("client sent: "+req.a + " "+req.op+" "+req.b);

        Response res = processRequest(req);
        clientSocket.write(res);
        clientSocket.closeConnection();
    }

    public void run() throws IOException, ClassNotFoundException {

        System.out.println("Server is running at port "+PORT);

        while(true){
            Socket clientSocket = serverSocket.accept(); //blocking system call

            System.out.println("client has arrived "+clientSocket.getInetAddress());

            new Thread(()->{
                try {
                    handleClient(new SocketWrapper(clientSocket));
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }).start();

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Server server = new Server();
        server.run();
    }
}