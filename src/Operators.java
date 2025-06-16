public class Operators {

    public static void main(String[] args) {

        // addition + , subtraction - , multiplication * , division / , modulus %

        double score = 1 + 2*3 ;
        // precedence

        /*
        *  multiplication, division, modulus
        * addition , subtraction
        * unary operators
        *     unary minus - 10
        *     increment ++
        *     decrement --
        * */

        System.out.println("score is "+score);

        int copy = (int) score / 2;

        System.out.println("copy is "+copy);

        // unary demonstration

        int myVariables = 10 ;

        int variableCopy = myVariables++; //11
        System.out.println("my variable is "+myVariables); //11
        System.out.println("variable copy is "+variableCopy); //10

        // associativity

        double a = 10 * 5 / 2 % 3 ;

        System.out.println("a is "+a);

        int x = 10 ;
        int y = 7 ;
        int z = x-- - --y ;

        System.out.println("z is "+z);








    }
}
