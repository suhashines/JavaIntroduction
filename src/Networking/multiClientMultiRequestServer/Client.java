package Networking.multiClientMultiRequestServer ;
import Networking.multiClientMultiRequestServer.models.Request;
import Networking.multiClientMultiRequestServer.models.Response;
import Networking.multiClientMultiRequestServer.models.Operation;
import Networking.util.SocketWrapper;

import java.util.Scanner;

public class Client {

    public static final String ip = "localhost";
    public static final int PORT = 5000;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of operations to perform: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter operation " + (i + 1) + "-> ADD,SUB,MUL,DIV :\n");
            String opStr = sc.next().toUpperCase();
            System.out.println("Enter two numbers: ");

            double a = sc.nextDouble();
            double b = sc.nextDouble();

            try {
                Operation op = Operation.valueOf(opStr);
                Request req = new Request(op, a, b);

                int requestId = i;
                new Thread(() -> {
                    try {
                        SocketWrapper server = new SocketWrapper(ip, PORT);
                        System.out.println("Request-" + requestId + " sending: " + req.op + " " + req.a + " " + req.b);

                        server.write(req);
                        //client is stuck here
                        Response res = (Response) server.read();

                        if (res.statusCode == 1)
                            System.out.println("Request-" + requestId + " result: " + res.result);
                        else
                            System.out.println("Request-" + requestId + " error (e.g., divide by zero)");

                        server.closeConnection();
                    } catch (Exception e) {
                        System.out.println("Request-" + requestId + " failed: " + e.getMessage());
                    }
                }, "requestThread-" + requestId).start();

            } catch (Exception e) {
                System.out.println("Invalid input! Try again.");
                i--; // retry current iteration
            }
        }
    }
}
