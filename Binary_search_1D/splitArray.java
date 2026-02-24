package Binary_search_1D;

// Problem Statement:Given an integer array‘A’of size‘N’and an integer‘K'.Split the array‘A’into‘K’non-empty subarrays such that the largest sum of any subarray is minimized.Your task is to return the minimized largest sum of the split.A subarray is a contiguous part of the array.
public class splitArray {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 1 };
        int k = 3;

        int ans = brute(arr, k);
        System.out.println("answer is " + ans);
    }

    public static int brute(int[] arr, int k) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int x : arr) {
            if (x > max) {
                max = x;
            }
            sum += x;
        }

        int low = max;
        int high = sum;

        for (int i = low; i <= high; i++) {

            if (partionCount(arr, i) == k) {
                return i;
            }
        }
        return -1;
    }

    public static int partionCount(int[] arr, int size) {
        int count = 1;
        int currentValue = 0;

        for (int i = 0; i < arr.length; i++) {
            if (currentValue + arr[i] < size) {
                currentValue += arr[i];
            } else {
                count++;
                currentValue = arr[i];
            }
        }
        return count;
    }
}
