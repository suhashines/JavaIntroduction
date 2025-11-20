package Modifiers.Base;

public abstract class AbstractShape {

    public abstract double area();    // must be overridden

    public void showType() {          // non-abstract method
        System.out.println("I am a shape.");
    }
}

