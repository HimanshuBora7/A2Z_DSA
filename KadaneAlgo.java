// maximum sum subarray(subarray means contigous part of the array ) sum 

public class KadaneAlgo {
    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        // int ans = brute_force(arr);

        // int ans = better_way(arr);
        int [] ans = kadane(arr);

        System.out.println("maximum sum is " + ans[0]);

        System.out.println("the subarray which is producing the maximum sum is " + " start : " + ans[1] + " end : "+ ans[2]);

        for(int i= ans[1] ; i <= ans[2] ; i++ ){
          System.out.print(arr[i] + " ");
        }
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


    // what if we are asked to print the sub array also 

    // we observe that whenever the subarray starts , it starts with 0 so we make two new variable ans_start ( which will track the starting index ) n this will be initialised when the sum becomes zero
    
    //and second variable would be ans_wnd which track the the end of the subarray which would be when the max and cumulative sum are swapped 


    public static int[] kadane(int[] arr) {
        int max = Integer.MIN_VALUE;
        
        int ans_start = -1;
        int ans_end = -1;
        int start = -1;
        
        int cummul_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            
            if(cummul_sum == 0){
                start = i;
            }
            cummul_sum += arr[i];
            
            //this piece of code is to track the indexed of maximum sum producing sub array 

            if(cummul_sum == 0){
                start = i;
            }
        
            if (cummul_sum > max) {
                max = cummul_sum;
                ans_end = i;
                ans_start = start;
            }
            if (cummul_sum < 0) {
                cummul_sum = 0;
            }
        }
        int [] result = {max,ans_start,ans_end};

        return result;
    }

}
