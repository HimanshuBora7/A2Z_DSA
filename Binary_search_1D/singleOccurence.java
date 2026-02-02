package Binary_search_1D;

//   Given an array of N integers. Every number in the array except one appears twice. Find the single number in the array.
public class singleOccurence {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 };
        int result = brute_force(arr);
        int result1 = optimal_approach(arr);
        System.out.println("the number which has occured only once: " + result1);
    }

    public static int brute_force(int[] arr) {

        // brute force approach is simple if we are at index i then the similar element
        // should be either at (i-1)th index or either at (i+1)th index exception to
        // this are the elements at the first position and at the last positon

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] != arr[i + 1]) {
                    return arr[i];
                }
            } else if (i == arr.length - 1) {
                if (arr[i] != arr[i - 1]) {
                    return arr[i];
                }
            } else {
                if (arr[i] != arr[i + 1] && arr[i] != arr[i - 1]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    // optimal approach ~ using binary search

    public static int optimal_approach(int[] arr) {
        // to avoid edge cases
        int low = 1;
        int n = arr.length - 1;
        int high = n - 1;
        if (arr[0] != arr[1])
            return arr[0];
        if (arr[n] != arr[n - 1])
            return arr[n];

        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            } else if (arr[mid] == arr[mid - 1]) {
                if ((mid - 1) % 2 == 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if ((mid + 1) % 2 == 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
