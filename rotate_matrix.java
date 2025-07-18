// rotate a matrix by 90* towards right 

public class rotate_matrix {
    public static void main (String [] args ){

        int[][] arr = {
        { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12},
        { 13, 14, 15, 16},
        };

        System.out.println("Array created ");
        print_Array(arr, arr.length, arr[0].length);

        // int [] [] new_arr2 = brute_force_approach(arr);

        optimal_approach(arr);

        System.out.println("Modified array");
        // print_Array(new_arr2, new_arr2.length,new_arr2[0].length);
        print_Array(arr, arr.length,arr[0].length);

    }

    public static void print_Array(int arr[][], int i, int j) {
        for (int a = 0; a < i; a++) {
            for (int b = 0; b < j; b++) {
                System.out.print(arr[a][b] + " ");
            }
            System.out.println();
        }
    }
    //by observation we observe that i' = j and j' = 3-i;

    public static int [][] brute_force_approach(int [][] arr ){
        
        int [] [] new_arr = new int[arr.length][arr[0].length];
        
        for(int i = 0 ; i < arr.length ; i++){
            for(int j=0;j<arr[0].length ;j++){
                new_arr[j][arr.length - i-1 ] = arr[i][j];
            }
        }
        return new_arr;
    }

    // we have to perform this in place vch is here without using extra array in the same array
    // by observation we observe in place rotation can be completed in two steps 

    // first swap an element with i n j indexes with 3-i n j index \
    // basically we are swapping the rows but it should be done for half the rows only becoz we apply this on every row then we get to the starting point 

    public static void optimal_approach(int [] [] arr ){
      
        int rows = arr.length;
        int column = arr[0].length;
        
        int temp = 0 ;
        
        for(int i= 0 ; i< rows/2 ; i++){
            for(int j = 0 ; j < column ; j++){
             temp = arr[i][j];
             arr[i][j] = arr[rows -i-1][j];
             arr[rows -i-1][j] = temp;
            }
        }
        // now withouth disturbing diagonal elements we swap elements at index i,j with elements ar j , i position 
        // similar to row swap this step should be done only for upper half of diagonal or lower half if we do it for both the half then again we come back to orihinal array 
        for(int i= 0 ; i < rows ;i++){
            for(int j = 0 ; j <column ; j++){
                if( i!= j && i < j){
                     temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }

    }


}
