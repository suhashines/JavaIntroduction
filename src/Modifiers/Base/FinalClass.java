package Modifiers.Base;

public final class FinalClass {

    public final int MAX_VALUE = 100;  // cannot be reassigned

    public final void showMessage() {  // cannot be overridden
        System.out.println("Message from FinalClass");
    }
}

