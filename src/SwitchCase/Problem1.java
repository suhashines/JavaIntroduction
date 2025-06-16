package SwitchCase;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {

        // create a simple calculator using switch case

        int a, b ;

        Scanner scn = new Scanner(System.in);

        System.out.println("Enter first number : ");

        a = scn.nextInt();

        System.out.println("Enter second number : ");
         b = scn.nextInt();

        System.out.println("1. Addition ");
        System.out.println("2. Subtraction ");
        System.out.println("3. Multiplication ");
        System.out.println("4. Division ");

        System.out.println("Enter your choice ");
        int choice = scn.nextInt( );

        switch(choice){

            case 1 :
                System.out.println("Addition is "+(a+b));
                break;


            case 2:

                System.out.println("Addition is "+(a-b));
                break;

            case 3:

                System.out.println("Multiplication is "+(a*b));
                break;

            case 4:

                int isZero = b == 0 ? 1 : 0 ;

                switch(isZero){

                    case 1 :
                        System.out.println("Invalid input for division");
                        break;

                    case 0 :

                        System.out.println("Division is "+(a/b));
                }

                break;

            default:

                System.out.println("Invalid choice ");

        }



    }
}
