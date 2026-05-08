// import mpi.*;

// public class Problem_15
//  {
//     public static void main(String[] args) throws Exception {
//         MPI.Init(args);
//         int rank = MPI.COMM_WORLD.Rank();
//         int size = MPI.COMM_WORLD.Size();

//         int[] full = new int[size];
//         int[] local = new int[1];

//         if (rank == 0) {
//             for (int i = 0; i < size; i++) full[i] = i + 1;
//             System.out.print("Array: ");
//             for (int x : full) System.out.print(x + " ");
//             System.out.println();
//         }

//         MPI.COMM_WORLD.Scatter(full, 0, 1, MPI.INT, local, 0, 1, MPI.INT, 0);

//         double reciprocal = 1.0 / local[0];
//         System.out.println("Process " + rank + " value: " + local[0] + " reciprocal: " + reciprocal);

//         double[] localRec = {reciprocal};
//         double[] allRec = new double[size];
//         MPI.COMM_WORLD.Gather(localRec, 0, 1, MPI.DOUBLE, allRec, 0, 1, MPI.DOUBLE, 0);
//         if (rank == 0) {
//             System.out.print("Reciprocal Array: ");
//             for (double r : allRec) System.out.printf("%.4f ", r);
//             System.out.println();
//         }
//         MPI.Finalize();
//     }
// }

import mpi.*;

public class Problem_15 {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int[] full = new int[size];
        int[] local = new int[1];

        if (rank == 0) {
            for (int i = 0; i < size; i++) {
                full[i] = i + 1;
            }
            System.out.println("ARRAY :");
            for (int i : full) {
                System.out.println(i + " ");
            }
            System.out.println();
        }
        MPI.COMM_WORLD.Scatter(full, 0, 1, MPI.INT, local, 0, 1, MPI.INT, 0);
        double reciprocal = 1.0 / local[0];
        System.out.println("Process " + rank + " value : " + local[0] + " reciprocal : " + reciprocal);
        double[] localRec = { reciprocal };
        double[] allRec = new double[size];
        MPI.COMM_WORLD.Gather(localRec, 0, 1, MPI.DOUBLE, allRec, 0, 1, MPI.DOUBLE, 0);
        if (rank == 0) {
            System.out.println("Reciprocal Array :");
            for (double r : allRec) {
                System.out.printf("%.4f ", r);
            }
            System.out.println();
        }

        MPI.Finalize();
    }
}