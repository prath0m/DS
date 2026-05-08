package corba;

import StringCaseModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class StringCaseClient {

    public static void main(String args[]) {
        try {
            // Initialize the ORB
            ORB orb = ORB.init(args, null);

            // Get reference to rootNamingContext
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContext ncRef = NamingContextHelper.narrow(objRef);

            // Resolve the object reference in Naming
            NameComponent[] name = new NameComponent[1];
            name[0] = new NameComponent("StringCase", "");

            StringCase stringCaseRef = StringCaseHelper.narrow(ncRef.resolve(name));

            System.out.println("Got the StringCase object reference");

            // Test strings
            String testStrings[] = {"hello world", "corba example", "distributed systems"};

            for (String test : testStrings) {
                String result = stringCaseRef.toUpperCase(test);
                System.out.println("Client: Input: " + test);
                System.out.println("Client: Output: " + result);
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}

