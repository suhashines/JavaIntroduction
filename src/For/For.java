package For;

import java.util.Scanner;

public class For {

    public static void main(String[] args) {

        // take a number from user and check whether it's prime or not

        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();

        boolean flag = true ;

        for(int i=2;i<num;i++){

            if(num%i == 0){
                flag = false ;
                break ;
            }
        }

        if(flag && num>1){
            System.out.println("prime");
        }else{
            System.out.println("not prime");
        }

    }
}
