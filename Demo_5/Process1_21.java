package Demo_5;

import java.io.*;
import java.net.*;

public class Process1_21
 {
    public static void main(String[] args) throws Exception {
        // Replace with Machine 1's IP address
        String nextIP = "localhost";
        ServerSocket server = new ServerSocket(6001);
        
        System.out.println("Process 1: Waiting for token from Process 0...");
        
        // 1. Receive Token
        Socket s = server.accept();
        DataInputStream in = new DataInputStream(s.getInputStream());
        String msg = in.readUTF();
        
        if(msg.equals("TOKEN")) {
            System.out.println("Process 1: Got the token! Entering Critical Section...");
            Thread.sleep(2000); // Simulating work in Critical Section
        }

        // 2. Pass Token back to Process 0
        System.out.println("Process 1: Work done. Passing token back to Process 0...");
        Socket sendBack = new Socket(nextIP, 6000);
        new DataOutputStream(sendBack.getOutputStream()).writeUTF("TOKEN");
        sendBack.close();
        
        server.close();
    }
}
