package Demo_4;


import java.io.*;
import java.net.*;

public class BerkeleySlave_19
 {
    public static void main(String[] args) throws Exception {
        // IMPORTANT: Replace "localhost" with the IP Address of Machine 1
        String masterIP = "localhost"; 
        Socket s = new Socket(masterIP, 6000);
        
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        // 1. Simulate a clock difference (e.g., this machine is 2 seconds ahead)
        long myTime = System.currentTimeMillis() + 2000; 
        System.out.println("My Time (with skew): " + myTime);

        // 2. Send time to Master
        out.writeLong(myTime);

        // 3. Receive the adjustment (offset) from Master
        long offset = in.readLong();
        long synchronizedTime = myTime + offset;

        System.out.println("Adjustment received: " + offset + " ms");
        System.out.println("New Synchronized Time: " + synchronizedTime);

        s.close();
    }
}