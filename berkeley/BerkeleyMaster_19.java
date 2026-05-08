package berkeley;

import java.io.*;
import java.net.*;

public class BerkeleyMaster_19
 {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6000);
        System.out.println("Time Daemon (Master) waiting for Slave...");

        Socket s = ss.accept();
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        // 1. Get Master's current time
        long masterTime = System.currentTimeMillis();
        System.out.println("Master Time: " + masterTime);

        // 2. Receive Slave's time
        long slaveTime = in.readLong();
        System.out.println("Received Slave Time: " + slaveTime);

        // 3. Calculate Average and Offset
        long averageTime = (masterTime + slaveTime) / 2;
        long slaveOffset = averageTime - slaveTime;
        long masterOffset = averageTime - masterTime;

        // 4. Send adjustment to Slave
        out.writeLong(slaveOffset);
        
        System.out.println("Average Time: " + averageTime);
        System.out.println("Master adjusts by: " + masterOffset + " ms");
        System.out.println("Slave adjustment sent: " + slaveOffset + " ms");

        ss.close();
    }
}