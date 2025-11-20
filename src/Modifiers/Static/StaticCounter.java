package Modifiers.Static;

public class StaticCounter {

    public static int counter = 0;  // shared across all objects
    public int id;

    public StaticCounter() {
        counter++;
        id = counter;  // Each instance gets a unique ID due to shared counter
    }

    public void show() {
        System.out.println("Object ID = " + id + " | Counter = " + counter);
    }
}

