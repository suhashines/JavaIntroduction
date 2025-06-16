import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

//        // int
//
//        System.out.print("Enter an integer : ");
//        int a = scn.nextInt();
//        System.out.println("You have given "+a);
//
//        //double
//        System.out.print("Enter an double : ");
//        double b = scn.nextDouble();
//        System.out.println("You have given "+b);


        // name, age


        System.out.print("Enter your name ");
        String name = scn.nextLine();
        //System.out.println("Your name is "+name);
        System.out.print("Enter your age ");
        int age = scn.nextInt();
        System.out.println("Your name : "+name + " your age : "+age);

    }
}
