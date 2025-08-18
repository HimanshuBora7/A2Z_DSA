// problem statement is to count the number of reverse pairs 
// Given an array of numbers, we need to return the count of reverse pairs.Reverse pairs are those pairs where i < j  && arr[i] > 2*arr[j]

import java.util.*;

public class reverse_pairs {
    public static void main(String[] args) {
        // int[] arr = { 1, 3, 2, 3, 1 };
        int[] arr = { 3, 2, 1, 4 };

        // int result = brute_force(arr);
        int result = optimal_approach(arr);

        System.out.println("number of reverse pair int the array : " + result);

    }

    public static int brute_force(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > 2 * arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // brute force takes O(n^2) time
    // instead of this we try to optimise it on the line of count inversion problem
    // solved using merge sort
    // but here the logic would be different to the two pointer approach we used
    // there
    // here the task on sorted array will be completed in two phase
    // first step is to count the pairs which satisfy our condition of i < j &&
    // arr[i] > 2*arr[j]
    // and in second step we merge them back
    // refer to notebook for theory

    public static int optimal_approach(int[] arr) {
        int count = 0;
        count = mergersort(arr, 0, arr.length - 1);
        return count;

    }

    public static int mergersort(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (high + low) / 2;

        count += mergersort(arr, low, mid);
        count += mergersort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    public static int merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;

        int count = 0;
        int j = right;
        for (int i = left; i <= mid; i++) {

            while (j <= right && arr[i] > 2 * arr[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        // step 2
        List<Integer> temp = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return count;
    }
}
