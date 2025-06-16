package Methods;

import java.util.Scanner;

public class PasswordValidator {

    final static String[]messages = {"Valid Password","Must have at least ten chars","Should have only letters and digits","Must have at least two digits"};

    final static int VALID_PASS = 0 ;
    final static int MIN_CHARS = 1 ;

    final static int ONLY_LET_AND_DIGITS =  2 ;
    final static int TWO_DIGIT = 3 ;

    //constraint
    final static int MIN_DIGIT = 2 ;
    final static int MIN_LENGTH = 10 ;

    public static int isValidPassword(String pass){

        if(pass.length()<MIN_LENGTH){
            return MIN_CHARS ;
        }

        return validatorHelper(pass);
    }

    public static int validatorHelper(String pass){

        int digitCount = 0 ;

        for(int i=0;i<pass.length();i++){
            char ch = pass.charAt(i);

            if(ch>='0' && ch<='9'){
                digitCount ++ ;
            }else if(ch<'a' || ch>'z'){
                return ONLY_LET_AND_DIGITS;
            }
        }

        // congratulationsss for reaching this far

        if(digitCount<MIN_DIGIT){
            return TWO_DIGIT;
        }

        return VALID_PASS;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String password = scn.nextLine();

        System.out.println(messages[isValidPassword(password)]);

    }
}
