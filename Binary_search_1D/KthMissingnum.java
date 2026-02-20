package Binary_search_1D;

// Problem Statement:You are given a strictly increasing array‘vec’and a positive integer'k'.Find the'kth'positive integer missing from'vec'.

public class KthMissingnum {
    public static void main(String[] args) {
        int[] arr = { 4, 7, 9, 10 };
        int k = 4;

        // int ans = brute(arr, k);
        // int ans = brute1(arr, k);
        int ans = optimal(arr, k);
        System.out.println(k + " th missing number from the array is " + ans);
    }

    public static int brute(int[] arr, int k) {
        // first solution can i can think is of hashing
        int n = arr.length - 1;
        int max = arr[n]; // as the array is in increasing order so the last element has to be greatest

        int[] hashArr = new int[max + 1];

        for (int x : hashArr) {
            hashArr[x]++;
        }
        int counter = 0;
        for (int i = 1; i <= max; i++) {
            if (hashArr[i] == 0) {
                counter++;
                if (counter == k) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int brute1(int[] arr, int k) {
        int ans = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k)
                k++;
            else {
                ans = k - 1;
                break;
            }
        }
        return ans;
    }

    public static int optimal(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return k + high;
    }
}
