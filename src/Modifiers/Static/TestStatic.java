package Modifiers.Static;

public class TestStatic {
//compiler , TestStatic.main()
    public static void main(String[] args) {

        System.out.println("=== Testing Static vs Instance Members ===");

        StaticExample obj1 = new StaticExample();
        StaticExample obj2 = new StaticExample();

        StaticExample.staticValue = 10;
        obj1.instanceValue = 5;

        StaticExample.staticValue = 20;
        obj2.instanceValue = 7;

        System.out.println("obj1.staticValue = " + obj1.staticValue);   // 20
        System.out.println("obj2.staticValue = " + obj2.staticValue);   // 20

        System.out.println("obj1.instanceValue = " + obj1.instanceValue); // 5
        System.out.println("obj2.instanceValue = " + obj2.instanceValue); // 7

        StaticExample.staticMethod();
        obj1.instanceMethod();


        System.out.println("\n=== Testing Static Counter Behavior ===");

        StaticCounter c1 = new StaticCounter();
        c1.show();
        StaticCounter c2 = new StaticCounter();
        c1.show();
        StaticCounter c3 = new StaticCounter();

        c1.show();
        c2.show();
        c3.show();
    }
}

