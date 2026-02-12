package Binary_search_1D;
// Problem Statement:You are given'N’roses and you are also given an array'arr'where'arr[i]'denotes that the'ith'rose will bloom on the'arr[i]th'day.You can only pick already bloomed roses that are adjacent to make a bouquet.You are also told that you require exactly'k'adjacent bloomed roses to make a single bouquet.Find the minimum number of days required to make at least‘m' bouquets each containing'k'roses.Return-1 if it is not possible.Examples

public class MBoquets {
    public static void main(String[] args) {
        int[] arr = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;

        // int ans = brute(arr, m, k);
        int ans = optimal(arr, m, k);
        if (ans == -1)
            System.out.println("not possible");
        else
            System.out.println("minimum number of days required :" + ans);
    }

    public static boolean possible(int[] arr, int days, int m, int k) {

        int counter = 0;
        int noOfB = 0;

        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] <= days) {
                counter++;
            } else {
                noOfB += (counter / k);
                counter = 0;
            }
        }
        noOfB += (counter / k);
        if (noOfB >= m) {
            return true;
        } else {
            return false;
        }
    }

    public static int brute(int[] arr, int m, int k) {
        if (arr.length - 1 < (m * k)) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x < min) {
                min = x;
            } else if (x > max) {
                max = x;
            }
        }
        // checking for all the days
        // range is between the minimum of the number and maxium of the number in the
        // array
        for (int i = min; i <= max; i++) {
            if (possible(arr, i, m, k) == true) {
                return i;
            }
        }
        return -1;
    }
    // the logic for optimal solution of this using binary search is simple
    // we have range of possible answers and we can set minimum from the array as
    // low
    // and the maximum from the array as high
    // we find the mid and check if it is possible to form a boquet or not
    // if it is not possible that means we require more days so we trime down the
    // left search space by setting low as mid+1;
    // if it comes out that it is possible to form a boquet at mid then we try to
    // tirm down the right search space as we have to find the minimum days

    public static int optimal(int[] arr, int m, int k) {
        if (arr.length - 1 < (m * k)) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x < min) {
                min = x;
            } else if (x > max) {
                max = x;
            }
        }

        int low = min;
        int high = max;
        int minDays = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (high + low) / 2;

            if (possible(arr, mid, m, k) == true) {
                // we try to trim down the right search space in order to find minimum
                if (mid <= minDays) {
                    minDays = mid;
                    high = mid - 1;
                }

            } else {
                low = mid + 1;
            }
        }
        return minDays;
    }
}
