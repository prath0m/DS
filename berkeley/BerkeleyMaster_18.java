// package Demo_4;
// import java.io.*;
// import java.net.*;

// public class BerkeleyMaster_18 {
//     public static void main(String[] args) throws Exception {
//         ServerSocket ss = new ServerSocket(6000);
//         System.out.println("Master waiting for one slave...");

//         // Connect to one slave for simplicity
//         Socket s = ss.accept();
//         DataInputStream in = new DataInputStream(s.getInputStream());
//         DataOutputStream out = new DataOutputStream(s.getOutputStream());

//         long masterTime = System.currentTimeMillis();
//         System.out.println("Master Time: " + masterTime);

//         // 1. Get Slave Time
//         long slaveTime = in.readLong();
//         System.out.println("Slave Time received: " + slaveTime);

//         // 2. Calculate Average
//         long average = (masterTime + slaveTime) / 2;
//         System.out.println("Calculated Average: " + average);

//         // 3. Send Adjustment to Slave
//         long slaveAdjust = average - slaveTime;
//         out.writeLong(slaveAdjust);

//         // 4. Adjust Self
//         long masterAdjust = average - masterTime;
//         System.out.println("Master adjusts by: " + masterAdjust + " ms");
        
//         ss.close();
//     }
// }

package berkeley;
import java.io.*;
import java.net.*;

public class BerkeleyMaster_18 {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6000);
        System.out.println("Master Waiting for the Slave....");

        Socket s = ss.accept();
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        long masterTime = System.currentTimeMillis();
        System.out.println("Master Time :"+masterTime);

        //Get Slave Time
        long slaveTime = in.readLong();
        System.out.println("Slave Time received :"+slaveTime);

        //calculate Aevrage
        long avg = (masterTime + slaveTime) /2;
        System.out.println("Calculated Average :"+avg);

        //send adjustment to Slave
        long SlaveAdjust = avg - slaveTime;
        out.writeLong(SlaveAdjust);

        //adjust silf
        
    }
}