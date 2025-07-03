// maximum sum subarray(subarray means contigous part of the array ) sum 

public class KadaneAlgo {
    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        // int ans = brute_force(arr);

        // int ans = better_way(arr);
        int ans = kadane(arr);

        System.out.println("answer is " + ans);
    }

    // brute force approach by trying out all the subsequence using three loops

    public static int brute_force(int[] arr) {
        int max = Integer.MIN_VALUE;
        // System.out.println("minimum value " + max);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                // calculate the sum of subsequence formed b/w i and j
                int current_sum = 0;
                for (int k = i; k < j; k++) {
                    current_sum += arr[k];
                }
                if (current_sum > max) {
                    max = current_sum;
                }
            }
        }
        return max;
    }
    // better approach would be removing the 3rd loop and adding the new element j
    // brings to the cumulative sum

    public static int better_way(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int cummul_sum = 0;
            for (int j = i; j < arr.length; j++) {
                cummul_sum += arr[j];
                if (cummul_sum > max) {
                    max = cummul_sum;
                }
            }
        }
        return max;
    }

    // optimal approach to solve this problem is using kadane algorithm
    // it states that we store sum as cummulative sum of element as we move forward
    // but if at any point the sum becomes negative we re initialize it to zero
    // so we carry forward only +ve sum as carrying forward negative sum will only
    // result in decrement
    // with all this we keep on checking the cumulative sum with our max variable

    public static int kadane(int[] arr) {
        int max = Integer.MIN_VALUE;
        int cummul_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            cummul_sum += arr[i];

            if (cummul_sum > max) {
                max = cummul_sum;
            }
            if (cummul_sum < 0) {
                cummul_sum = 0;
            }
        }
        return max;
    }

}
