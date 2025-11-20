package Modifiers.Demo;

import Modifiers.Base.BaseClass;

public class ExternalSubClass extends BaseClass {

    public void testAccess() {
        System.out.println(publicField);
        System.out.println(protectedField); // OK (subclass)

        // System.out.println(defaultField);   // ❌ not accessible (different package)
        // System.out.println(privateField);   // ❌ never accessible

        publicMethod();
        protectedMethod();   // OK (subclass)

        // defaultMethod();  // ❌ not accessible
        // privateMethod();  // ❌ not accessible
    }
}

