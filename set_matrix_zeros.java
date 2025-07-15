// here we willl be given a binary matrix of nxn vch means it will be having only 0 / 1 as elements with n rows and n columns 

// so our task to find the cells which contains 0 and convert that rows rows and cloumns as Zeros 

import java.util.Scanner;

public class set_matrix_zeros {
    public static void main(String[] args) {

        // int[][] arr = new int[4][4];

        // Scanner sc = new Scanner(System.in);

        // for (int i = 0; i < 4; i++) {
        //     for (int j = 0; j < 4; j++) {

        //         System.out.printf("enter data for arr [%d][%d]", i, j);
        //         arr[i][j] = sc.nextInt();
        //     }
        // }
        // sc.close();

        int [] [] arr = {
                          {1,1,1,1},
                          {1,0,0,1},
                          {1,1,0,1},
                          {1,1,1,1},
                        };


        System.out.println("Array created ");
        print_Array(arr, 4, 4);

        brute_force_approach(arr, 4, 4);

        System.out.println("Modified array");
        print_Array(arr, 4, 4);

    }

    public static void print_Array(int arr[][], int i, int j) {
        for (int a = 0; a < i; a++) {
            for (int b = 0; b < j; b++) {
                System.out.print(arr[a][b] + " ");
            }
            System.out.println();
        }
    }

    public static void brute_force_approach(int[][] arr, int rows, int columns) {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                // if (arr[i][j] == 0) {
                // int tempR = 0;
                // int tempC = 0;

                // while (tempC < columns) {
                // arr[i][tempC] = 0;
                // tempC++;
                // }

                // while (tempR < rows) {
                // arr[tempR][j] = 0;
                // tempR++;
                // }
                // }

                // the problem with this approach is that when we find a zero n marks that row n
                // columns as zero then if we iterate further we don't encounter the zero which
                // was originally there instead we a find a zero which was made by us but we
                // want only the original ones rows and columns to be marked as zero so istead
                // of marking them as zero as we mark them as -1 and in second iteration we make
                // those -1 as zero

                if (arr[i][j] == 0) {
                    int tempR = 0;
                    int tempC = 0;

                    while (tempC < columns) {
                        arr[i][tempC] = -1;
                        tempC++;
                    }

                    while (tempR < rows) {
                        arr[tempR][j] = -1;
                        tempR++;
                    }
                }
            }

        }
        //   System.out.println("modified - 1 array ");
        //     print_Array(arr, 4,4);
            // now we have to iterate the matrix again to mark it as zero

            for (int u = 0; u < rows; u++) {
                for (int v = 0; v < columns; v++) {
                    if (arr[u][v] == -1) {
                        arr[u][v] = 0;
                    }
                }

            }
    }



}
