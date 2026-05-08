package Demo_6;
import java.util.Arrays;
public class BullyAlgorithmSimple {
    static int n = 5; // Total processes (ID: 0, 1, 2, 3, 4)
    static boolean[] alive = new boolean[n];

    public static void main(String[] args) {
        // Initially all are alive
        Arrays.fill(alive, true);
        
        System.out.println("Coordinator is Process 4.");
        
        // 1. Simulate Coordinator failure
        System.out.println("\n--- Process 4 (Coordinator) crashes! ---");
        alive[4] = false;

        // 2. Process 1 (initiator) notices the crash and starts election
        int initiator = 1;
        System.out.println("Process " + initiator + " starts the election.");
        election(initiator);
    }

    static void election(int id) {
        boolean higherAlive = false;

        // Send ELECTION message to all higher ID processes
        for (int i = id + 1; i < n; i++) {
            System.out.println("Election message: Process " + id + " -> Process " + i);
            if (alive[i]) {
                System.out.println("OK message: Process " + i + " -> Process " + id);
                higherAlive = true;
                // Higher process takes over the election
                election(i);
                return;
            }
        }

        // If no higher process responded, this process becomes leader
        if (!higherAlive) {
            System.out.println("\n*** Process " + id + " is the new Coordinator! ***");
            // Inform everyone else
            for (int i = 0; i < n; i++) {
                if (i != id && alive[i]) {
                    System.out.println("Coordinator message: " + id + " -> Process " + i + ": I am the leader.");
                }
            }
        }
    }
}