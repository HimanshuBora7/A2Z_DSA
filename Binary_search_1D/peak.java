package Binary_search_1D;

// find the peak element in an array 
// what ie peak element ~ element which is gr8er than its neighbours
// arr[mid -1 ] < arr[mid] > arr[mid+1];
// for elements at first and last index we assume that there is -infinity to their left(for 0th index) and _infinity at right (for last element )
public class peak {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 5, 1 };

        // int result = brute(arr);
        int result = optimi(arr);

        System.out.println("peak element in the array is " + result);
    }

    public static int brute(int[] arr) {
        // brute force approach is simple we only have to perform linear search
        int n = arr.length - 1;
        // if there is single element in the array
        if (n == 0) {
            return arr[n];
        }
        // hardcoding to handle edge cases

        else if (arr[0] > arr[1]) {
            return arr[0];
        }

        else if (arr[n] > arr[n - 1]) {
            return arr[n];
        }
        for (int i = 1; i <= n - 1; i++) {
            if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
                return arr[i];
            }
        }
        return -1;
    }
    // this takes O(n) t.c.
    // optimised approach is to use binary search

    public static int optimi(int[] arr) {
        // we try to move mid towards peak by eliminating either the right half or left
        // half
        // handling edge cases if there is single element

        int n = arr.length - 1;
        if (n == 0) {
            return arr[n];
        }

        // handling first and last element

        if (arr[0] > arr[1]) {
            return arr[0];
        } else if (arr[n] > arr[n - 1]) {
            return arr[n];
        }
        // applying binary search approach on rest of the elements
        int low = 1;
        int high = n - 1;
        while (low <= high) {
            int mid = (high + low) / 2;

            // check if the mid is the peak or not

            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return arr[mid];
            }
            // moving the mid towards peak
            else if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
