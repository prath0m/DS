package corba;

import StringCaseModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class StringCaseImpl extends StringCasePOA {

    public String toUpperCase(String str) {
        System.out.println("Server: Received string: " + str);
        String result = str.toUpperCase();
        System.out.println("Server: Converted to uppercase: " + result);
        return result;
    }
}

