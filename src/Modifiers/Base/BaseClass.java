package Modifiers.Base;


class NotPublicClass{

}

public class BaseClass {

    // ---- Attributes ----
    public String publicField = "Public Field";
    protected String protectedField = "Protected Field";
    String defaultField = "Default Field";     // package-private
    private String privateField = "Private Field";

    public final String finalString = "Final Value";


    // ---- Methods ----
    public void publicMethod() {
        System.out.println("Public method of BaseClass");
    }

    protected void protectedMethod() {
        System.out.println("Protected method of BaseClass");
    }

    void defaultMethod() {
        System.out.println("Default/package-private method of BaseClass");
    }

    private void privateMethod() {
        System.out.println("Private method of BaseClass");
    }

    // Demonstrating private access internally
    public void testPrivateAccess() {
        privateField = "more private" ;
        privateMethod();
    }

    public final void finalMethod(){
        System.out.println("You cannot override me haha");
    }
}

