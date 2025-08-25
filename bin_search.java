// binary search 
// array should be sorted 
public class bin_search {
    public static void main(String[] args) {
        int arr[] = { 3, 4, 6, 7, 9, 12, 16, 17 };
        int target = 60;
        bin_search(arr, target);
    }

    public static void bin_search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int count = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (target == arr[mid]) {
                count++;
                System.out.print("found");
                break;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (count == 0) {
            System.out.println("not found");
        }
    }

}
