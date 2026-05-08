
// import mpi.*;

// public class Problem_12 {
//     public static void main(String[] args) throws Exception {
//         MPI.Init(args);
//         int rank = MPI.COMM_WORLD.Rank();
//         int size = MPI.COMM_WORLD.Size();

//         int[] full = new int[size];
//         int[] local = new int[1];

//         if (rank == 0) {
//             for (int i = 0; i < size; i++) {
//                 full[i] = i + 1;
//             }
//             System.out.print("Array");
//             for (int x : full) {
//                 System.out.print(x + " ");
//             }
//             System.out.println();
//         }
//         MPI.COMM_WORLD.Scatter(full, 0, 1, MPI.INT, local, 0, 1, MPI.INT, 0);
//         System.out.println("Process :" + rank + "has value :" + local[0]);
//         int[] sum = new int[size];
//         MPI.COMM_WORLD.Gather(new int[] { local[0] }, 0, 1, MPI.INT, sum, 0, 1, MPI.INT, 0);
//         if (rank == 0) {
//             int total = 0;
//             for (int s : sum) {
//                 total += s;

//             }
//             System.out.println("Total sum is :" + total);
//         }
//         MPI.Finalize();

//     }

// }

import mpi.*;

public class Problem_12 {
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
        System.out.println("Process : " + rank + "has value : " + local[0]);
        int[] sum = new int[size];

        MPI.COMM_WORLD.Gather(local, 0, 1, MPI.INT, sum, 0, 1, MPI.INT, 0);
        if (rank == 0) {
            int total = 0;
            for (int i : sum) {
                total += i;
            }
            System.out.println("Total sum is : " + total);
        }
        MPI.Finalize();

    }
}
