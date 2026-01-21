package Binary_search_1D;

// Given an integer array arr of size N,sorted in ascending order(with distinct values),the array is rotated at any index which is unknown.Find the minimum element in the array.
public class searchMinRotate {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };

        int res = search_min(nums, nums.length - 1);

        System.out.println("minimum from this array is " + res);
    }

    public static int search_min(int[] arr, int n) {
        int high = n;
        int low = 0;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}
