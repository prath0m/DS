import ReverseModule.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import java.util.Scanner;

class ReverseClient {
    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            Reverse obj = ReverseHelper.narrow(ncRef.resolve_str("Reverse"));

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter string: ");
            String input = sc.nextLine();

            String result = obj.reverse_string(input);

            System.out.println("Reversed string: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

/*
How to Run:


1) Open Command Prompt and go to the CORBA folder:
    cd /d c:\Users\tejas\Downloads\DS\DS\3.1 CORBA

2) Generate stubs/skeletons:
    idlj -fall Reverse.idl

3) Compile:
    javac *.java ReverseModule\*.java

4) Start ORB in one cmd window:
    orbd -ORBInitialPort 1050

5) In a second cmd window, start server:
    java ReverseServer -ORBInitialPort 1050 -ORBInitialHost localhost

6) In a third cmd window, start client:
    java ReverseClient -ORBInitialPort 1050 -ORBInitialHost localhost
*/