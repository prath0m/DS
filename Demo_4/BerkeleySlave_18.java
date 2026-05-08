package Demo_4;


import java.io.*;
import java.net.*;

public class BerkeleySlave_18
 {
    public static void main(String[] args) throws Exception {
        // Replace "localhost" with Master's IP when running on 2 machines
        String ip = "localhost"; 
        Socket s = new Socket(ip, 6000);
        
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        // Simulate a clock skew (adds 1000ms difference)
        long myTime = System.currentTimeMillis() + 1000;
        System.out.println("My Time (with skew): " + myTime);

        // Send time to Master
        out.writeLong(myTime);

        // Receive and apply adjustment
        long adjust = in.readLong();
        System.out.println("Adjustment: " + adjust + " ms");
        System.out.println("Synchronized Time: " + (myTime + adjust));

        s.close();
    }
}