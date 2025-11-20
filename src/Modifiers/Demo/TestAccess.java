package Modifiers.Demo;

import Modifiers.Base.*;

public class TestAccess {

    public static void main(String[] args) {

        BaseClass base = new BaseClass();

        //Not Accessible
        //NotPublicClass notPublicClass = new NotPublicClass();

        // Accessible
        System.out.println(base.publicField);
        base.publicMethod();

        // Not Accessible
        // System.out.println(base.protectedField); // ❌ not allowed (not subclass)
        // System.out.println(base.defaultField);   // ❌ different package
        // System.out.println(base.privateField);   // ❌ always inaccessible

        // Methods:
        // base.protectedMethod();  // ❌ not allowed (not subclass)
        // base.defaultMethod();    // ❌ not allowed
        // base.privateMethod();    // ❌ not allowed

        // Testing abstract class
        AbstractShape circle = new AbstractShape() {
            @Override
            public double area() {
                return 3.14 * 5 * 5;
            }
        };
        circle.showType();
        System.out.println("Area: " + circle.area());
    }
}

