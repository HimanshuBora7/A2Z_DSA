package Binary_search_1D;

// recursive approach 
public class binary_search {
    public static void main(String[] args) {
        int arr[] = { 3, 4, 6, 7, 9, 12, 16, 17 };
        int n = 9;
        int output = recur_approach(arr, 0, arr.length, n);
        if (output == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Found at " + (output + 1));
        }

    }

    public static int recur_approach(int[] arr, int low, int high, int target) {
        if (low >= high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return recur_approach(arr, low, mid - 1, target);
        } else {
            return recur_approach(arr, mid + 1, high, target);
        }

    }
}
