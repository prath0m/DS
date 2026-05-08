package Demo_6;
import java.util.Arrays;

public class BullyComplexity_26 {
    static int n = 5; 
    static boolean[] alive = new boolean[n];
    static int messageCount = 0; // To track time complexity

    public static void main(String[] args) {
        Arrays.fill(alive, true);
        alive[4] = false; // Coordinator crashes

        int initiator = 0; // Worst case: lowest ID starts election
        System.out.println("Process " + initiator + " starts election (Worst Case Scenario)");
        
        elect(initiator);

        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("Total Processes (n): " + n);
        System.out.println("Total Messages Exchanged: " + messageCount);
        System.out.println("Theoretical Worst Case O(n^2): " + (n * n));
    }

    static void elect(int id) {
        boolean higherFound = false;

        for (int i = id + 1; i < n; i++) {
            messageCount++; // Increment for ELECTION message
            System.out.println("Election: " + id + " -> " + i);
            
            if (alive[i]) {
                messageCount++; // Increment for OK message
                higherFound = true;
                elect(i);
                return;
            }
        }

        if (!higherFound) {
            System.out.println("\n*** Process " + id + " is Leader ***");
            for (int i = 0; i < n; i++) {
                if (i != id && alive[i]) {
                    messageCount++; // Increment for COORDINATOR message
                }
            }
        }
    }
}