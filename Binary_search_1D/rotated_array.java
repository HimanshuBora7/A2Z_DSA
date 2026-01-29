package Binary_search_1D;

//find out how many times an array has been rotated 
// the logic is simple - the index at which the minimum array is in the rotated array that index is our answer 

public class rotated_array {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int result = timesRotated(arr);
        System.out.println("number of times the array has been rotated " + result);
    }

    public static int timesRotated(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (high + low) / 2;

            if (arr[low] <= arr[high]) {
                if (arr[low] < min) {
                    index = low;
                    min = arr[low];
                    break;
                }
            }

            if (arr[low] <= arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                    index = low;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
                if (arr[mid] < min) {
                    index = mid;
                    min = arr[mid];
                }
            }
        }
        return index;

    }
}
