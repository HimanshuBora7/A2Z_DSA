// find the next permutaion of a given array , if next doesn't exist return the 1st one 
// the permutations should be in increasing order as they would have been placed in the dictionary 
// brute force approach would take take huge order of time so we avoid coding that part
// but the approach for brute would be 
// step1 : make all permutations using recursion as for N number of element N! permutation would be avaialale
// step2 : sort those possible prmutations 
// step3 : find the given array in that list through linear search 
// step4 ; our desired output would be the array at next index 

// OPTIMAL approach ~ 3 steps 
// Step 1 :  find the longest prefix match ~ gind the breakpoint which would be a[i] < a[i+1];
// step 2 ; find some1 just  greater than a[i] ,but the smallest one so we stay close to the given array 
// step 3 : try to place remaining elements in sorted order 

public class next_permutation {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 4, 3, 0, 0 };
        System.out.println("original array ");
        for (int x : arr) {
            System.out.print(x + " ");
        }

        int[] arr2 = optimal_approach(arr);

        System.out.println("next permutation array ");
        for (int x : arr2) {
            System.out.print(x + " ");
        }

    }

    public static int[] optimal_approach(int[] arr) {

        int a = -1;
        int b = -1;

        for (int i = 0; i < arr.length-1; i++) {

            if (arr[i] < arr[i + 1]) {
                a = i;
                b = i + 1;
            }
        }
        // System.out.println("a and b are : " + arr[a] + " , " + arr[b]);

        int diff = Integer.MAX_VALUE;
       

        for (int j = b; j < arr.length; j++) {
            if (arr[a] < arr[j]) {
                diff = Math.min(diff, arr[j] - arr[a]);
            }
        }

        System.out.println("difference " + diff);

        for (int j = b; j < arr.length; j++) {
            if (arr[j] - arr[a] == diff) {
                int temp = arr[a];
                arr[a] = arr[j];
                arr[j] = temp;
                // System.out.println("swapped successfully ");
            }
        }

        // System.out.println("intermediate array ");
        // for(int x : arr){
        //    System.out.print(" " + x );
        // }


        for (int i = b; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }
}
