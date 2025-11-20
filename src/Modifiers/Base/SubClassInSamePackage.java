package Modifiers.Base;

public class SubClassInSamePackage extends BaseClass {

    @Override
    public void protectedMethod(){
        String local = finalString;
    }

//    public void finalMethod(){
//
//    }

    public void testAccess() {
        System.out.println(publicField);
        System.out.println(protectedField);
        System.out.println(defaultField);   // accessible (same package)
        // System.out.println(privateField); // ❌ not accessible

        publicMethod();
        protectedMethod();
        defaultMethod();   // accessible (same package)
        // privateMethod(); // ❌ not accessible
    }
}

