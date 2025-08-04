
// find the number of subarray whose xor is equal to K
// xor ~ same bits kay liye zero 
// a^a = 0; 
import java.util.*;

public class subarray_xor {
    public static void main(String[] args) {
        int arr[] = { 4, 2, 2, 6, 4 };

        // int result = brute_force(arr, 6);

        // int result = better_approach(arr, 6);

        int result = optimal_approach(arr, 6);

        System.out.println(" result : " + result);

    }

    public static int brute_force(int[] arr, int k) {
        int counter = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int xor = 0;

                for (int l = i; l <= j; l++) {
                    xor = xor ^ arr[l];
                }
                if (xor == k) {
                    counter++;
                }
            }
        }

        return counter;
    }

    // as we have to remove the third loop and out TC will reduce to O(n^2)
    // we know that as j increments it add an element to xor
    public static int better_approach(int[] arr, int k) {

        int n = arr.length;
        int counter = 0;

        for (int i = 0; i < n; i++) {
            int xor = 0;

            for (int j = i; j < n; j++) {
                xor = xor ^ arr[j];
                if (xor == k) {
                    counter++;
                }
            }
        }
        return counter;
    }

    // optimal approach as we have deduced (refer to notebook)
    // in hash map we will be storing the xors from front with their count
    // hash map will be initised with 0,1 which means nothing
    // n with every i incremented we will look if some x is found previously
    // so x ^ xr will be K
    public static int optimal_approach(int[] arr, int k) {

        HashMap<Integer, Integer> front_xor = new HashMap<>();

        int counter = 0;

        front_xor.put(0, 1);

        int xor = 0;
        for (int i = 0; i < arr.length; i++) {

            xor = xor ^ arr[i];
            int x = xor ^ k;

            if (front_xor.containsKey(x)) {
                counter += front_xor.get(x);
            }
            if (front_xor.containsKey(x)) {
                front_xor.put(x, front_xor.get(x) + 1);
            } else {
                front_xor.put(x, 1);
            }
        }
        return counter;
    }
}
