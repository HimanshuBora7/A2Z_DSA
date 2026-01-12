package Binary_search_1D;
// The lower bound of a target value x in a sorted array is the index of the first element that is greater than or equal to x.

// Logic:If the target exists,the lower bound is the index of its first occurrence.If it doesn'texist,the lower bound is the index of the first element larger than it.

// The Search Space:We use two pointers,low and high.

// The Decision:*If arr[mid]>=target,this index could be the lower bound,but there might be a smaller index to the left that also satisfies the condition.We record this index as a potential answer and move high to mid-1.

// If arr[mid]<target,the lower bound must be to the right,so we move low to mid+1.

// 2. The Question

// Problem Statement:Given a sorted array of integers arr and a target value k,write an efficient function to find the index of the lower bound of k.If all elements in the array are smaller than k,return the length of the array.

// Constraints:

// Time Complexity:O(logn)

// Space Complexity:O(1)
public class lower {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 4, 4, 6, 7 };
        int[] arr1 = { 10, 20, 30, 40, 50 };
        int result = lowerbound(arr1, arr.length, 25);
        int result1 = upperbound(arr, arr.length, 4);
        System.out.println("resultant index of lower bound  " + result);
        System.out.println("resultant index of upper bound  " + result1);
    }

    public static int lowerbound(int[] arr, int high, int x) {
        int ans = arr.length;
        int low = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;

    }

    public static int upperbound(int[] arr, int high, int x) {
        // the only difference in findding upper bound and lower bound is the > and of
        // >= (used in lower bound )
        int ans = arr.length;

        int low = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
