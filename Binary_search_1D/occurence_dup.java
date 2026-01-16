package Binary_search_1D;
// you are given an sorted array containing N integers and a number X, you have to find the occurence of x in the given array.

// optimal solution uses the approach we used to find the first and last occurence using binary search so total occurence = last -first +1
public class occurence_dup {
    public static void main(String[] args) {
        int[] arr = { 2, 2, 3, 3, 3, 3, 4 };
        int x = 3;
        int[] sol = optimal_sol(arr, arr.length - 1, x);
        int res = (sol[1] - sol[0]) + 1;
        System.out.println("the number " + x + " has occured " + res + " times");
    }

    public static int[] optimal_sol(int[] arr, int high, int x) {
        int first = -1;
        int last = -1;

        int low = 0;

        // Finding the first occurence

        while (low <= high) {
            int mid = (high + low) / 2;

            if (arr[mid] == x) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // finding the last occurence
        low = 0;
        high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        int[] res = new int[2];
        res[0] = first;
        res[1] = last;
        return res;
    }
}
