package Binary_search_1D;

//search an element x in a rotated sorted array [for unique elements ]
// optimal approach is simple we have to use binary search on sorted portion so first we have to find which portion of array is sorted
public class searchRotate {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int ans = optimalSol(arr, arr.length, 0);
        System.out.println(ans);
    }

    public static int optimalSol(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
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
        return -1;
    }
}
