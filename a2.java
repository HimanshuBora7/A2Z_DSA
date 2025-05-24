//implementing swapping of array using recursion 

public class a2 {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 2 };
        System.out.println("original array ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        swap_arr(0, arr1.length-1, arr1);
        System.out.println("\nswapped array ");
        for (int a = 0; a < arr1.length; a++) {
            System.out.print(arr1[a] + " ");
        }
    }

    public static void swap_arr(int i, int j, int[] arr) {
         if (i >= j) {
            return;
        }
        
        int x = arr[i];
        arr[i] = arr[j];
        arr[j] = x;
        swap_arr(i + 1, j - 1, arr);
       
    }
}
