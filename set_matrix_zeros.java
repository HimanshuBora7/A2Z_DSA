// here we willl be given a binary matrix of nxn vch means it will be having only 0 / 1 as elements with n rows and n columns 

// so our task to find the cells which contains 0 and convert that rows rows and cloumns as Zeros 

import java.util.Scanner;

public class set_matrix_zeros {
    public static void main(String[] args) {

        // int[][] arr = new int[4][4];

        // Scanner sc = new Scanner(System.in);

        // for (int i = 0; i < 4; i++) {
        // for (int j = 0; j < 4; j++) {

        // System.out.printf("enter data for arr [%d][%d]", i, j);
        // arr[i][j] = sc.nextInt();
        // }
        // }
        // sc.close();

        int[][] arr = {
        { 1, 1, 1, 1 },
        { 1, 0, 0, 1 },
        { 1, 1, 0, 1 },
        { 1, 1, 1, 1 },
        };

        // int[][] arr = {
        //         { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 }
        // };

        System.out.println("Array created ");
        print_Array(arr, arr.length, arr[0].length);

        // brute_force_approach(arr, 4, 4);

        // better_approach(arr);

         optimal_approach(arr);

        System.out.println("Modified array");
         print_Array(arr, arr.length, arr[0].length);

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
        // System.out.println("modified - 1 array ");
        // print_Array(arr, 4,4);
        // now we have to iterate the matrix again to mark it as zero

        for (int u = 0; u < rows; u++) {
            for (int v = 0; v < columns; v++) {
                if (arr[u][v] == -1) {
                    arr[u][v] = 0;
                }
            }

        }
    }
    /*
     * Use of -1 as a Marker: If the matrix contains -1 as a valid value, marking
     * elements as -1 could lead to incorrect results.
     * Edge Cases: The code doesn't check for null or empty matrices, which could
     * cause an ArrayIndexOutOfBoundsException when accessing matrix[0].length or
     * other elements.
     * Inefficiency: The code modifies the matrix twice (first to -1, then to 0),
     * which can be optimized by using the matrix's first row and column as markers.
     * Potential Overwrite Issue: When setting rows and columns to -1, it might
     * overwrite other 0s, affecting subsequent checks.
     * 
     */
    // better approach ~ reducing time complexity from O(n^3) to O(n^2)(vch is
    // minimum we can achive in a 2d matrix )
    // if an element is zero then that entire row and column needs to be converted
    // into 0 so we make two new arrays
    // column array and row array of size m and n respectively to track vch rows and
    // columns needs to be converted to

    public static void better_approach(int[][] arr) {

        int m = arr.length; // number of rows
        int n = arr[0].length; // number of columns

        int[] row_array = new int[m];
        int[] column_array = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    row_array[i] = 1;
                    column_array[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row_array[i] == 1 || column_array[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }

    }

    //optimising the space complexity by placing those extra rows and columns we created to track inside the array itself
    
    public static void optimal_approach(int [][]  arr ){
        // int [] row_arry => arr[][0]
        // int [] column_array = arr[0][]

        int col = 1; // for tracking j == 0  column 
        
        //step1 : traverse the matrix and mark 1st row and column accordingly

        for(int i=0;i<arr.length;i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                if(arr[i][j] == 0){
                    arr[i][0] = 0;

                    if( j!= 0){
                        arr[0][j] = 0;
                    }
                    else{
                        col = 0;
                    }
                }
            }
        }
        // step 2 mark with 0 from 1,1, to n-1 and m -1

        for(int i = 1 ; i < arr.length ; i++){
            for(int j = 1 ; j < arr[0].length ; j++){
                if(arr[i] [j] != 0 ){
                    if(arr[0][j] == 0 || arr[i][0] == 0){
                        arr[i][j] = 0;
                    }
                }
            }
        }

        // step 3: finally mark the 1st column and then 1st row 

        if(arr[0][0] == 0){
            for(int j=0 ; j < arr[0].length ; j++){
                arr[0][j] =0;
            }
        }
        if(col == 0){
            for(int i = 0 ; i < arr.length ; i++){
                arr[i][0] =0;
            }
        }

    }


}
