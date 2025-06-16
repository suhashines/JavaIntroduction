package IfElse;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {

        //1) Write a java program to input a cost of a pen and calculate 70 pens cost with some discount.
          //      If total pen cost greater than 1000 then we calculate 20 % discount, otherwise 10 %


        // user input

        Scanner scn = new Scanner(System.in);

        System.out.println("Enter pen's price : ");

        double price = scn.nextDouble();

        int total = 70 ;

        double netTotalWithoutDiscount = price * total ;

        double netTotalWithDiscount ;

        if(netTotalWithoutDiscount > 1000){
            netTotalWithDiscount = netTotalWithoutDiscount - netTotalWithoutDiscount*0.2 ;
        }else{
            netTotalWithDiscount = netTotalWithoutDiscount - netTotalWithoutDiscount*0.1 ;
        }

        System.out.println("total with discount "+netTotalWithDiscount);


    }
}
