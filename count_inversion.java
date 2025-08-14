//Given an array of N integer , count the inversion of the array 
// inversion of array means we have to find a pair of two element in the array itself such that i < j && arr[i] > arr[j]
// pairs of element from the array such that the left one should be greater than the right one

import java.util.*;

public class count_inversion {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 2, 4, 1 };

        // int x = brute_force(arr);
        int x = optimal_solution(arr);

        System.out.println("number of pairs in this array :" + x);

    }
    // brute force approach would be to try out all combination using two loops
    // which will result in time complexity of O(n^2);

    public static int brute_force(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
    // optimal solution solves this problem in linear time complexity
    // it uses merge sort technique it has two portion first the problem is divided
    // to single element
    // and while merging it back we can put our counter to check if the left is
    // greater than right
    // if left is greater then all the elements to the right of that element will
    // also form pair as the array is sorted
    // so after increasing the counter the right index will be increased and process
    // will repeat itself

    public static int optimal_solution(int[] arr) {
        int count = mergersort(arr, 0, arr.length - 1);
        return count;
    }

    public static int mergersort(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (high + low) / 2;
        count = count + mergersort(arr, low, mid);
        count = count + mergersort(arr, mid + 1, high);
        count = count + merge(arr, low, mid, high);

        return count;
    }

    public static int merge(int[] arr, int low, int mid, int high) {
        int count = 0;
        ArrayList<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {

            // addition of code to track the pairs will be added here

            if (arr[left] > arr[right]) {
                count = count + (mid - left + 1);
                temp.add(arr[right]);
                right++;
            } else {
                temp.add(arr[left]);
                left++;
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