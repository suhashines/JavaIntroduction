public class TypeCasting {
    public static void main(String[] args) {

        // char to int
        // char -> unicode -> 16 bit
        // int -> 32 bit
        // widening casting

        char charValue = 'A' ;
        int intValue = (int)charValue ;

        System.out.println("char to int-> "+intValue);


        // int to char - > narrowing casting
        int intValue2 = 66 ;
        char charValue2 = (char)intValue2 ;

        System.out.println("int to char-> "+charValue2);


        // double to int

        double myDouble = 10.19 ;
        int myInt = (int)myDouble ;

        System.out.println("double to int-> "+myInt);


        long longValue = 210L ;
        int forcedInt = (int)longValue ;


        System.out.println("long to int -> "+forcedInt);
    }
}
