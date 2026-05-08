package Demo_5;
import java.io.*;
import java.net.*;

public class Process0_21
 {
    public static void main(String[] args) throws Exception {
        // Replace with Machine 2's IP address
        String nextIP = "localhost";
        ServerSocket server = new ServerSocket(6000);
        
        // 1. Process 0 starts with the token (The Key)
        System.out.println("Process 0: I have the token. Entering Critical Section...");
        Thread.sleep(2000); // Simulating work in Critical Section
        
        // 2. Pass Token to Process 1
        System.out.println("Process 0: Work done. Passing token to Process 1...");
        Socket s = new Socket(nextIP, 6001);
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeUTF("TOKEN");
        s.close();

        // 3. Wait for token to come back to complete the ring
        Socket back = server.accept();
        System.out.println("Process 0: Token received back! Ring is complete.");
        server.close();
    }
}