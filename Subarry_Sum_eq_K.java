
// Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.
import java.util.*;

public class Subarry_Sum_eq_K {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1 };
        int k = 2;
        // int output = find_result(arr, k);
        int output = optimal_sol(arr, k);
        System.out.println("Output " + output);

    }

    // this approach fails for certain inputs as it skips some subarrays n this
    // below code is actually the tweaked approach to find the longest subarray
    // so natuarlly this skips some surbarray

    //
    // public static int find_result(int[] arr, int k) {
    // int num = 0;

    // int len = arr.length;

    // long sum = 0;

    // int count = 0;
    // Map<Long, Integer> presumMap = new HashMap<>();

    // for (int i = 0; i < len; i++) {
    // sum += arr[i];
    // if (sum == k) {
    // count++;
    // }
    // // calculate the remaining sum
    // long rem = sum - k;
    // if (presumMap.containsKey(rem)) {
    // count++;
    // }
    // // finally update the map after checking condition
    // if (!presumMap.containsKey(sum)) {
    // presumMap.put(sum, i);
    // }

    // }
    // return count;
    // }

    // prefix sum approach ~ using prefix sum as key and the number of time it
    // occurs as value
    // don't forgot to enter the first entry as 0,1 vch signifies no exclusion is
    // required the subarray is perfect

    public static int optimal_sol(int[] arr, int k) {

        HashMap<Long, Integer> prefixSum = new HashMap<>();

        int count = 0;
        long sum = 0;

        prefixSum.put(0L, 1);

        for (int x : arr) {
            sum += x;

            if (prefixSum.containsKey(sum - k)) {
                count += prefixSum.get(sum - k);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return count;

    }
}
