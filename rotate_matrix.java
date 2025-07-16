// rotate a matrix by 90* towards right 

public class rotate_matrix {
    public static void main (String [] args ){

        int[][] arr = {
        { 1, 3, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12},
        { 13, 14, 15, 16},
        };

        System.out.println("Array created ");
        print_Array(arr, arr.length, arr[0].length);

        int [] [] new_arr2 = brute_force_approach(arr);


        System.out.println("Modified array");
        print_Array(new_arr2, new_arr2.length,new_arr2[0].length);

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
}
