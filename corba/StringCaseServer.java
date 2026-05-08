package corba;

import StringCaseModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class StringCaseServer {

    public static void main(String args[]) {
        try {
            // Initialize the ORB
            ORB orb = ORB.init(args, null);

            // Get reference to rootNamingContext
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContext ncRef = NamingContextHelper.narrow(objRef);

            // Create an instance of StringCaseImpl
            StringCaseImpl stringCaseRef = new StringCaseImpl();

            // Register the object with ORB
            org.omg.CORBA.Object ref = orb.servant_to_reference(stringCaseRef);
            StringCase href = StringCaseHelper.narrow(ref);

            // Bind the Reference in Naming
            NameComponent path[] = ncRef.list(100, new BindingListHolder()).binding;
            NameComponent[] name = new NameComponent[1];
            name[0] = new NameComponent("StringCase", "");

            try {
                ncRef.bind(name, href);
            } catch (AlreadyBound ex) {
                ncRef.rebind(name, href);
            }

            System.out.println("StringCase Server is ready...");

            // Wait for invocations from clients
            orb.run();

        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }
}

