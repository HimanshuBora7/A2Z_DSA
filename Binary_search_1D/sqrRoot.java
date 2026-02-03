package Binary_search_1D;

// find the sqr root of a number in O(log n) t.c.
// if perfect squre root is not there then return the floor value 
public class sqrRoot {
    public static void main(String[] args) {
        // int ans = linear(36);
        int ans = brute(36);
        System.out.println("answer is " + ans);
    }

    // linear approach is to check for every number till n
    public static int linear(int n) {
        int ans = 1;

        for (int i = 1; i < n; i++) {
            if (i * i <= n) {
                ans = i;
            } else
                break;
        }
        return ans;
    }
    // we can apply binary search approach on this as there are range of answers and
    // we have to eliminate one half so

    public static int brute(int n) {
        int ans = 1;
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = (high + low) / 2;

            if ((mid * mid) <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
