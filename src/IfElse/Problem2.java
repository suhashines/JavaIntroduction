package IfElse;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {

        //2) A company decided to give bonus of 5% to employee if his/her year of service is
        //more than 5 years. Ask user for their salary and year of service and print the net
        //bonus amount

        //user input

        Scanner scn = new Scanner(System.in);

        System.out.println("Enter salary : ");

        double salary = scn.nextDouble();

        System.out.println("Enter year of service : ");
        int year = scn.nextInt();

        double netSalary ;

        if(year>5){
            netSalary = salary + salary*0.5 ;
        }else{
            netSalary = salary;
        }

        System.out.println("Your salary after one year : "+netSalary);
    }
}
