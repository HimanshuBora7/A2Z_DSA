package Binary_search_1D;
// monkey Koko is given‘n’piles of bananas,whereas the'ith'pile has‘a[i]’bananas.An integer‘h’is also given,which denotes the time(in hours)for all the bananas to be eaten.

// Each hour,the monkey chooses a non-empty pile of bananas and eats‘k’bananas.If the pile contains less than‘k’bananas,then the monkey consumes all the bananas and won’t eat any more bananas in that hour.

// Find the minimum number of bananas‘k’to eat per hour so that the monkey can eat all the bananas within‘h’hours.
public class kokoBanana {
    public static void main(String[] args) {
        int arr[] = { 7, 15, 6, 3 };
        int n = 8;

        // int k = brute(n, arr);
        int k = optimal(arr, n);
        System.out.println("Minimum speed required " + k);
    }

    // brute force is simple we start with 1 banana per hr speed if it exceeds the H
    // we increment the speed
    public static int brute(int h, int[] arr) {
        // we know the lowest eating speed can be 1 and the maxium speed would be the
        // maximum element from the array as after that all other number will give same
        // speed and our time is to find the minimum speed within H

        // finding the maximum element
        int maxElem = max(arr);
        for (int i = 1; i <= maxElem; i++) {
            int reqtime = totalTime(arr, i);
            if (reqtime <= h) {
                return i;
            }
        }
        return -1;
    }

    // function for finding the maximum element
    public static int max(int[] arr) {
        int max = arr[0];
        for (int x : arr) {
            if (x > max) {
                max = x;
            }
        }
        return max;
    }

    // this function will return total time it will take with particular speed

    public static int totalTime(int[] arr, int speed) {
        int totalHour = 0;
        for (int x : arr) {
            totalHour += Math.ceilDiv(x, speed);
        }
        return totalHour;
    }
    // optimising this is simple we have range of numbers from which we have to
    // select our answers we choose a mid speed between low (1) nad high (maximum
    // element)
    // then we try to trim the search space
    // if the required time is less than our H then we discard the right search
    // space and move towards left(high = mid-1;)
    // if required time is more than the H then we need to increase our speed
    // inorder
    // to minimise the requiredTime so we discard the left search space and move
    // towards right(low = mid+1);

    public static int optimal(int[] arr, int h) {
        int low = 1;
        int high = max(arr);
        int ans = -1;
        while (low <= high) {
            int mid = (high + low) / 2;
            int reqTime = totalTime(arr, mid);
            if (reqTime <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
