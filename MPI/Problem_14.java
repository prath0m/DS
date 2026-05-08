// import mpi.*;
// import java.util.Random;

// public class Problem_14 {
//     public static void main(String[] args) throws Exception {
//         MPI.Init(args);
//         int rank = MPI.COMM_WORLD.Rank();
//         int size = MPI.COMM_WORLD.Size();

//         int each = 2; // each process gets 2 numbers
//         int[] full = new int[size * each];
//         int[] local = new int[each];

//         if (rank == 0) {
//             Random r = new Random();
//             System.out.print("Array: ");
//             for (int i = 0; i < full.length; i++) {
//                 full[i] = r.nextInt(100) + 1;
//                 System.out.print(full[i] + " ");
//             }
//             System.out.println();
//         }

//         MPI.COMM_WORLD.Scatter(full, 0, each, MPI.INT, local, 0, each, MPI.INT, 0);

//         double avg = 0;
//         for (int x : local)
//             avg += x;
//         avg /= each;
//         System.out.println("Process " + rank + " avg: " + avg);

//         double[] localAvg = { avg };
//         double[] allAvgs = new double[size];
//         MPI.COMM_WORLD.Gather(localAvg, 0, 1, MPI.DOUBLE, allAvgs, 0, 1, MPI.DOUBLE, 0);

//         if (rank == 0) {
//             double total = 0;
//             for (double a : allAvgs)
//                 total += a;
//             System.out.println("Final Average: " + total / size);
//         }

//         MPI.Finalize();
//     }
// }



import java.util.Random;

import mpi.*;

public class Problem_14{
    public static void main(String[] args) throws Exception{
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int each =2;
        int[] full = new int[size*each];
        int[] local = new int[each];

        if(rank ==0)
        {
            Random r = new Random();
            System.out.println("ARRAY :");

            for(int i = 0 ; i < full.length ;i++)
            {
                full[i] = r.nextInt(100)+1;
                System.out.println(full[i] + " ");
            }
        }
        MPI.COMM_WORLD.Scatter(full , 0 , each , MPI.INT , local , 0 , each , MPI.INT , 0);

        double avg = 0;
        for(int i : local)
        {
            avg +=i;
        }
        avg/=each;
        System.out.println("Process "+rank + " avg :" + avg);
        double[] localAvg ={avg};
        double[] allAvgs = new double[size];
        MPI.COMM_WORLD.Gather(localAvg , 0 ,1 ,MPI.DOUBLE , allAvgs , 0 , 1 , MPI.DOUBLE , 0);
        if(rank == 0)
        {
            double total = 0 ;
            for(double a :allAvgs)
            {
                total+=a;
            }
            System.out.println("Final Average : " + total/size);
        }

        MPI.Finalize();
    }
}