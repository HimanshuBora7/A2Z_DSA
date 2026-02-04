package Binary_search_1D;

// Given two numbers N and M,find the Nth root of M.The nth root of a number M is defined as a number X when raised to the power N equals M.If the'nth root is not an integer,return-1.
public class nthRoot {
    public static void main(String[] args) {
        int n = 3;
        int m = 27;
        // int ans = brute(n, m);
        int ans = optimised(n, m);
        if (ans == -1) {
            System.out.println("not found");
        } else {

            System.out.println(n + " raised to " + ans + " is " + m);
        }
    }

    // brute force approach
    public static int brute(int n, int m) {

        for (int i = 1; i <= m; i++) {
            int val = power(i, n);
            if (val == m) {
                return i;
            } else if (val > m) {
                break;
            }

        }
        return -1;
    }

    private static int power(int base, int exp) {
        int res = 1;
        for (int i = 0; i < exp; i++) {
            res *= base;
        }
        return res;
    }

    public static int optimised(int n, int m) {
        // we will be using binary search as we know where we have to move on the basis
        // of product we get and we have range of numbers where our answers might lie
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = (high + low) / 2;
            int product = power(mid, n);
            if (product == m) {
                return mid;
            } else if (product > high) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }
}
