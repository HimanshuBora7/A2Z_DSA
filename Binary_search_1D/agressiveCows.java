package Binary_search_1D;

import java.util.*;
// Problem Statement: You are given an array 'arr' of size 'n' which denotes the position of stalls. You are also given an integer 'k' which denotes the number of aggressive cows.

// You are given the task of assigning stalls to'k'cows such that the minimum distance between any two of them is the maximum possible.Find the maximum possible minimum distance.
public class agressiveCows {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 1, 3, 6 };

        int k = 2;

        int ans = brute(arr, k);
        System.out.println("maximum minimum possible distance is " + ans);
    }
    // brute force approach is simple first we sort the array as it will then
    // contains the position of stalls in increasing order
    // first cow always goes on 1st stall then we gradually place the cow with
    // starting of minimum distance of 1
    // we increase the count of minimum distance and check if it is possible to
    // place the cows now or not
    // maximum possible distance is our answer

    public static int brute(int[] arr, int k) {

        // sorting the array
        Arrays.sort(arr);
        // maximum possible distance would be [max-min] from the array

        int min = arr[0];
        int max = arr[arr.length - 1];

        // 1 is added extra as what if it we have only 2 cows so in that condition the
        // last index will also get passsed as true so we add 1 so we can get on else
        // part by generating a false value
        for (int i = 1; i <= (max - min) + 1; i++) {
            if (cowsPlaced(arr, k, i) == true) {
                continue;
            } else {
                // last possible index was our answer as for this particular index/distance we
                // are not able to place the cows
                return i - 1;
            }
        }
        return -1;
    }

    public static boolean cowsPlaced(int[] arr, int k, int i) {
        int countCows = 1;
        int lastCoordinate = arr[0];

        for (int j = 1; j < arr.length; j++) {
            if ((arr[j] - lastCoordinate) >= i) {
                countCows++;
                lastCoordinate = arr[j];
            }
            if (countCows >= k) {
                return true;
            }
        }
        return false;
    }
}
