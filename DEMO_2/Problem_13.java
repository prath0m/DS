
// import mpi.*;

// public class Problem_13 {
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
//         System.out.println("Process: " + rank + " has value: " + local[0]);

//         int[] result = new int[1];
//         MPI.COMM_WORLD.Reduce(local, 0, result, 0, 1, MPI.INT, MPI.PROD, 0);

//         if (rank == 0) {
//             System.out.println("Total Product is: " + result[0]);
//         }

//         MPI.Finalize();
//     }
// }

import mpi.*;

public class Problem_13{
    public static void main(String[] args) throws Exception {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int[] full = new int[size];
        int[] local = new int[1];

        if(rank == 0)
        {
            for(int i = 0 ; i < size ;i++)
            {
                full[i] = i+1;
            }
            System.out.println("ARRAY :");
            for(int i : full)
            {
                System.out.println(i + " ");
            }
            System.out.println();
        }
        MPI.COMM_WORLD.Scatter(full , 0 , 1, MPI.INT ,local ,0,1,MPI.INT , 0);
        System.out.println("Process : " + rank + " hash value : " + local[0]);

        int result[] = new int[1];
        MPI.COMM_WORLD.Reduce(local , 0 ,result , 0 ,1,MPI.INT , MPI.PROD , 0);
        if(rank == 0)
        {
            System.out.println("Total Product is : " + result[0]);
        }
        
        MPI.Finalize();
    }
}