package Binary_search_1D;
// monkey Koko is given‘n’piles of bananas,whereas the'ith'pile has‘a[i]’bananas.An integer‘h’is also given,which denotes the time(in hours)for all the bananas to be eaten.

// Each hour,the monkey chooses a non-empty pile of bananas and eats‘k’bananas.If the pile contains less than‘k’bananas,then the monkey consumes all the bananas and won’t eat any more bananas in that hour.

// Find the minimum number of bananas‘k’to eat per hour so that the monkey can eat all the bananas within‘h’hours.
public class kokoBanana {
    public static void main(String[] args) {
        int arr[] = { 7, 15, 6, 3 };
        int n = 8;

        int k = brute(n, arr);
        System.out.println("Minimum speed required " + k);
    }

    // brute force is simple we start with 1 banana per hr speed if it exceeds the H
    // we increment the speed
    public static int brute(int h, int[] arr) {
        // we know the lowest eating speed can be 1 and the maxium speed would be the
        // maximum element from the array as after that all other number will give same
        // speed and our time is to find the minimum speed within H

        // finding the maximum element
        int max = arr[0];
        for (int x : arr) {
            if (x > max) {
                max = x;
            }

        }
        for (int i = 1; i <= max; i++) {
            int reqtime = totalTime(arr, i);
            if (reqtime <= h) {
                return i;
            }
        }
        return -1;
    }
    // this function will return total time it will take with particular speed

    public static int totalTime(int[] arr, int speed) {
        int totalHour = 0;
        for (int x : arr) {
            totalHour += Math.ceilDiv(x, speed);
        }
        return totalHour;
    }
}
