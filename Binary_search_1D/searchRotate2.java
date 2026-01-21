package Binary_search_1D;
// 81. Search in Rotated Sorted Array II 

// There is an integer array nums sorted in non-decreasing order(not necessarily with distinct values).
public class searchRotate2

// this problem is simliar to the previous only difference is we have to handle
// a particular edge case where arr[low] == arr[mid] && arr[mid] == arr[high],
// upon hitting this condition we simply trip down our search space by low + 1
// and high -1

// here we can't return index so we have to return either true or false
{
    public static void main(String[] args) {

        int[] arr = { 2, 5, 6, 0, 0, 1, 2 };
        boolean ans = optimalSol(arr, arr.length, 0);
        System.out.println(ans);
    }

    public static boolean optimalSol(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return true;
            }
            // new addition to handle the edge case which have arised due to inclusion of
            // duplicate elements
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {

                // trimming down the search space
                low = low + 1;
                high = high - 1;
                continue; // to check if the edge case is still not persisting
            }

            // find which half is sorted, either the left or right half will be sorted
            else if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
