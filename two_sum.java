import java.util.*;



// second variation is we are given target value n told that two elements do exists in the array whose sum will lead to the taget value our job is to find the index of those two values 

public class two_sum {
    public static void main(String[] args) {
        int arr[] = { 2, 6, 5, 8, 11 };
        int target = 15;
        boolean ques = do_Sum_exist_brute(arr, target);

        int ques2 = do_sum_exist_optimal(arr, target);

        boolean ques3 = do_sum_exist_optimal_pointer(arr, target);
       
        if(ques3){
            System.out.println("Do exists " );
        }
        else{
            System.out.println("don't exists");
        }
    }
    public static boolean do_Sum_exist_brute(int [] arr , int target ){
        int flag = 0;
        for(int i =0 ;i < arr.length ; i++){

            int b = target - arr[i];
            
            for(int j = i+1 ; j < arr.length ; j++){
            
                if( arr[j] == b){
                flag++;
                break;
              }
            }
        }
        
        if(flag == 0 ){
            return false;
        }
        else{
            return true;
        }
    }

    //optimal approach to solve this problem is using hash map , where we can store the number will their index only if we are not able to find the corresdoing number which will add to the sum  

    public static int  do_sum_exist_optimal(int [] arr , int target ){
        int index = -1;

        HashMap<Integer,Integer> hashmp = new HashMap<>();

        for(int i = 0 ;i < arr.length ; i++){
            int sum = target - arr[i];
            if(hashmp.containsKey(sum)){
             index = hashmp.get(sum);
             break;
            }
            else{
                hashmp.put(arr[i], i+1);
            }
        }
        return index;

       
    }

  // slightly better approach without using hash map
  // array needs to be sorted  
  // 2 pointer approach , here we keep one pointer at left most index and one at right most index , we sum them and check the difference without our target value if the target value is greater than our sum it means the value of operand needs to be increased so we move left pointer towards right by one and check again 
  //now if our sum is more than our target value then it means we have to decrease our sum so we move right pointer towards the left by decreasing it 
  //not optimal for variety 2 in which we have to return the index , so this two pointer approach works only for 1st variety of questionn where we have to state whether the sum is possible or not 

 public static boolean  do_sum_exist_optimal_pointer(int [] arr , int target ){
    // sorting array 
   Arrays.sort(arr);
   int left = 0;
   int right = arr.length-1;
   
   int flag = 0;

   while(left < right){
    int sum = arr[left] + arr[right];

    if(sum == target){
        flag =1 ;
        break;
    }
    else{
        if(sum > target){
            right--;
        }
        else{
            left++;
        }
    }
   }

   if(flag == 0 ){
    return false;
   }
   
   else{
    return true;
   }
 }


}
