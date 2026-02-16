package Binary_search_1D;

// Problem Statement:You are the owner of a Shipment company.You use conveyor belts to ship packages from one port to another.The packages must be shipped within'd'days.The weights of the packages are given in an array'of weights'.The packages are loaded on the conveyor belts every day in the same order as they appear in the array.The loaded weights must not exceed the maximum weight capacity of the ship.Find out the least-weight capacity so that you can ship all the packages within'd'days.
public class shipPackage {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 5, 2, 3, 4, 5, 6 };
        int days = 5;

        int ans = brute(arr, days);
        int ans1 = optimal(arr, days);
        System.out.println("answer by brute force " + ans);
        System.out.println("answer by optimal approach " + ans1);
    }

    public static int brute(int[] arr, int days) {
        // as we know the range of answers is from maximum weight from the array till
        // the summation of everything included in the array

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int x : arr) {
            if (x > max) {

                max = x;
            }
            sum += x;
        }
        // now a for loop searching through every possible answer

        int minCap = Integer.MAX_VALUE;

        for (int i = max; i <= sum; i++) {
            int dayRequired = daysReq(arr, i);
            if (dayRequired <= days) {
                if (i < minCap) {
                    minCap = i;
                }
            }
        }
        return minCap;
    }

    // function to find how many days it will require for given weights in the array
    // and capacity of ship
    public static int daysReq(int[] arr, int capacity) {
        int d = 1;
        int sum = 0;

        for (int x : arr) {
            if (sum + x > capacity) {
                d++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return d;
    }
    // optimising this is simple we have range of answers we have to find the least
    // capacity

    public static int optimal(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int x : weights) {
            if (x > max) {

                max = x;
            }
            sum += x;
        }

        int low = max;
        int high = sum;
        int minCap = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            // if the days required for a given capacity is exceeding more then we have to
            // increase the capacity thus we discard the left search space
            // if the days required are within our constraint then we have to eliminate the
            // right search space in order to find the least capacity
            int daysRequired = daysReq(weights, mid);
            if (daysRequired > days) {
                low = mid + 1;
            }

            else {
                if (mid < minCap) {
                    minCap = mid;
                }
                high = mid - 1;
            }
        }
        return minCap;
    }
}
