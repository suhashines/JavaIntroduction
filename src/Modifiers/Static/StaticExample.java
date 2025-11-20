package Modifiers.Static;

public class StaticExample {

    // ---- Static Attribute ----
    public static int staticValue = 0;

    // ---- Non-static Attribute ----
    public int instanceValue = 0;

    // ---- Static Method ----
    public static void staticMethod() {
        System.out.println("Inside staticMethod()");
        // System.out.println(instanceValue); // ❌ Not allowed
        // instanceMethod();                 // ❌ Not allowed
        System.out.println("staticValue = " + staticValue);
    }

    // ---- Instance Method ----
    public void instanceMethod() {
        System.out.println("Inside instanceMethod()");
        System.out.println("instanceValue = " + instanceValue);
        System.out.println("staticValue = " + staticValue); // Allowed
    }
}

