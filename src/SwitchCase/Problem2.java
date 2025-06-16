package SwitchCase;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {

        // take a character from user and decide whether it is
        // vowel or consonant

        Scanner scn = new Scanner(System.in);

        char ch = scn.next().charAt(0);

        if( (ch >= 'A' && ch<='Z') || (ch >= 'a' && ch<='z')){


            switch(ch){


                case 'A' :
                case 'E' :
                case 'I' :
                case 'O' :
                case 'U' :
                case 'a' :
                case 'e' :
                case 'i' :
                case 'o' :
                case 'u' :
                    System.out.println("This is a vowel");
                    break;

                default:

                    System.out.println("This is a consonant");
            }
        }else{
            System.out.println("invalid input");
        }
    }
}
