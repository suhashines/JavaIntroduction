package Modifiers.Base;

public class TestAccess {

    public static void main(String[] args) {

        BaseClass base = new BaseClass();

        NotPublicClass notPublicClass = new NotPublicClass();

        // cannot instantiate object of abstract class

        //AbstractShape abstractShape = new AbstractShape() ;

        // Accessible
        System.out.println(base.publicField);
        base.publicMethod();


        System.out.println(base.protectedField); // allowed ( withing same package)
        System.out.println(base.defaultField);

        // Not Accessible
         //System.out.println(base.privateField);   // ❌ always inaccessible

        // Methods:

         base.protectedMethod();
         base.defaultMethod();

        // base.privateMethod();    // ❌ not allowed
    }
}
