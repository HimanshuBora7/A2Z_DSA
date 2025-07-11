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
        // int[] arr = { 2, 1, 5, 4, 3, 0, 0 };
        // int[] arr = { 1,2,3 };
        // int[] arr = { 3,2,1 };
        int[] arr = { 2,3,1 };
        System.out.println("original array ");
        for (int x : arr) {
            System.out.print(x + " ");
        }

        // int[] arr2 = optimal_approach_mine(arr);
        optimal_approach_right(arr);

        System.out.println("next permutation array ");
        for (int x : arr) {
            System.out.print(x + " ");
        }

    }

    public static int[] optimal_approach_mine(int[] arr) {

        int a = -1;
        int b = -1;

        for (int i = 0; i < arr.length - 1; i++) {

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
        // System.out.print(" " + x );
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

    // in this approach we try to solve the problem from behind as we know they wld
    // be in increasing order from las
    // so we fist find the breakpoint or dip which possible last can have at n-2th
    // to index to 0th index
    // we store the index at index variable which would be initialised as -1
    // initially if after tbe 1st step if it is still -1
    // then we can say that we have reached the end of the order so we have to
    // return the 1st permutaion order which can be
    // made easily by reversing the given array , in this way we have handeled the
    // edge case
    // second step if the index is not -1 , we find the just big number to swap with
    // the element at the breakpoint
    // so we start looking from n-1 to the index and swap with the first element we
    // get greater than that
    // 3 rd and final step after swapping would be arranging the remaining element
    // in increasing order from index +1 to arr.length
    public static void optimal_approach_right(int[] arr) {

        int index = -1;
        int n = arr.length;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }
        System.out.println("\ngot breakpoint at "+ index + " element :");
        // arr[index]);
        if (index == -1) { // it means we have reached the last order of the permuatation at this point to
                           // get the 1st order we just to have to reverse the array
            

            for (int i = 0; i < n/2 ; i++) {
                int temp = arr[n-i-1];
                arr[n-i-1] = arr[i];
                 arr[i] = temp;
            }
            
        }

        else {
            // else means we have got the index of breakpoint now frm behind we to select
            // the just larger number
            for (int i = n - 1; i > index; i--) {
                if (arr[i] > arr[index]) {
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                    break; // we want the first element vch whld be just grea8er frm last so use break
                }
            }

            // after swappin we have to sort the remaining element
            for (int j = index + 1; j < n - 1; j++) {
                for (int f = j + 1; f < n; f++) {
                    if (arr[j] > arr[f]) {
                        int temp = arr[f];
                        arr[f] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }
}
