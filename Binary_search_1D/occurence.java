package Binary_search_1D;

// count the first and last occurence of a given number x in an sorted array 

public class occurence {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 8, 8, 11, 13 };

        int[] sol = brute_force(arr, 8);
        for (int x : sol) {
            System.out.println(x);
        }
        System.out.println("optimal solution ");
        int[] optiSol = optimal_sol(arr, arr.length - 1, 8);
        for (int x : optiSol) {
            System.out.println(x);
        }

    }

    public static int[] brute_force(int[] arr, int x) {
        // brute force approach is to do a linear traversal
        int first = -1;
        int last = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                if (first == -1) {
                    first = i;
                    last = i;
                } else {
                    last = i;
                }
            }
        }
        int[] res = new int[2];
        res[0] = first;
        res[1] = last;
        return res;
    }
    // plain binary search as solution for this problem
    // to find first and last occurence we need two seprate binary searches

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
