//find the longest subarray with given sum (positives only )
//subarray are the contigous element os the array n their sum must be equal to K and the length of that subarray must be maximumm

// -- BRUTE -- FORCE -- APPROACH --
// we find all the subarray n check their sum , whenever the sum matches with our k we take the maximum of current length vch is i-j+1(+1 is to adjust 0 based indexing ) and the previous length
// we return the maximum length in output
import java.util.*;

public class longest_Subarray {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
        int[] arr2 = { 1, 2, 3 };
        int k = 3;
        int k2 = 2;
        int k3 = 10;
        int[] arr3 = { 2, 3, 5, 1, 9 };

        // int z = max_len_brute(arr, k);
        // int z = max_len_optimal(arr2, k2);

        // int z = max_len_hash(arr3, k3);
        int z = max_len_pos_optimal(arr, k);
      System.out.println("answer frm optimal positive only way  " + z);
     
        int v = max_len_hash(arr, k);
        System.out.println("answer frm hash positive n negative nos way  " + v);
   
    }

    public static int max_len_brute(int[] arr, int k) {
        int length = 0;

        // generating all possible subset
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                // now the subarrays lies b/w i and j, calculating their sum

                for (int z = i; z <= j; z++) {
                    sum += arr[z];
                }
                // now checking if it equal to our given sum and if yes what is lenght
                if (sum == k) {
                    length = Math.max(length, j - i + 1);
                }
            }
        }

        return length;
    }

    // -- optimising the brute force --
    // tweaking the existing brute force approach by removing the need of 3rd loop
    // vch was making our tc to n^3;
    // so instead of doing summation again n again what we will do this time is that
    // we will go on adding the new element as the j loop progressees further

    public static int max_len_optimal(int[] arr, int k) {
        int length = 0;

        // generating all possible subset
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == k) {

                    length = Math.max(length, j - i + 1);
                }
            }

        }

        return length;
    }

    // optimal approach to solve the longes subarray problem is through hashing

    // Why Use hashing
    // Why Use Hashing?
    // Without hashing, you’d have to check every possible subarray (start at each
    // index, try all possible lengths), which takes a long time for large arrays.
    // Hashing makes it faster by keeping track of sums as we go through the array,
    // so we can quickly find if a subarray with the target sum exists.

    // Think of hashing like a notebook where we jot down sums we’ve seen and where
    // we saw them. This helps us spot the right subarray without rechecking
    // everything.

    // check the notion page(DSA) to view thory for this in detail

    // ** this hashing approach is also the optimal solution when array contains
    // both +ve and -ve nos.

    public static int max_len_hash(int[] arr, int k) {
        int n = arr.length;

        // declaring hash map

        Map<Long, Integer> preSumMap = new HashMap<>(); // key will be remaining sum and value will be index

        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            // calculate the prefix sum till index i
            sum += arr[i];

            // if sum = k,update the maxLen:

            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            // calculate the sum of the remaining part i.e. x-k:
            long rem = sum - k;
            // calculate the length and update maxlen
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            // finally update the map checking the condition
            // the below piece of code solves the problem of having zero in between vch can
            // alter the indexes and give us wrong outpur so we want the leftmost sum thats
            // Y if the sum exist we do not update as we want the left most sum to be
            // considered if we want the longest sum

            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;

    }

    // optimal approach using two pointers when the array is consisting only the
    // positive numbers

    // the basic approach is to move towards left till our sum gets greater than K
    // then we start trimming our elements from the right looking for it to match K

    public static int max_len_pos_optimal(int[] arr, int k) {

        long sum = arr[0];
        int left_pointer = 0;
        int max_len = -1;
        int right_pointer = 0;
        int n = arr.length;

        while (right_pointer < n) {
            while(left_pointer <= right_pointer && sum > k){
                // System.out.println("previous sum " + sum);
                // System.out.println("sum to be deducted  " + arr[left_pointer]);
                
                sum -= arr[left_pointer];
                // System.out.println("sum after decreasing " + sum );
                left_pointer++;

            }
             if ( sum == k ){
                max_len = Math.max(max_len, right_pointer - left_pointer + 1 );
                // System.out.println("max sum " + max_len);
             }
            right_pointer++;

            if (right_pointer < n) {
                sum += arr[right_pointer];
            }
        }
    return max_len;
    }

}
