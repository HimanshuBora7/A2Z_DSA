// maximum sum subarray(subarray means contigous part of the array ) sum 

public class KadaneAlgo {
    public static void main (String [] args ){
        int [] arr = { -2 ,-3,4,-1,-2,1,5,-3};
        int ans = brute_force(arr);

        System.out.println("answer is "+ ans);
    }
 
    //brute force approach by trying out all the subsequence using three loops 

    public static int brute_force(int [] arr ){
        int max = Integer.MIN_VALUE;
        // System.out.println("minimum value " + max);
        
        for(int i = 0 ; i< arr.length ; i++){
            for(int j = i;j < arr.length; j++){
                  // calculate the sum of subsequence formed b/w i and j 
                  int current_sum = 0;
                  for(int k = i ; k < j ; k++){
                    current_sum+=arr[k];
                  }
                  if(current_sum > max){
                    max = current_sum;
                  }
            }
        }
        return max;
    }
}
 