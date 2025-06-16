package While;

import java.util.Scanner;

public class While {

    public static void main(String[] args) {

        // given a number construct it's reverse and print it

        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int reverse = 0 ;

        // without constructing

        // num = 1234 ;

        int temp = num ;

        while(temp>0){

            int remainder = temp%10 ;

            reverse = reverse*10 + remainder ;

            temp = temp/10 ;

        }

        System.out.println("reverse of "+num+ " is "+reverse);

    }
}
