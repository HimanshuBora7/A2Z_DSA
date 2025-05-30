/*
The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.

Example 1:

Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.

*/

public class lc1 {
    public static void main (String [] args ){
        int [] arr = {3,4,2,1};
        for(int x : arr){
            System.out.print(x + " ");
        }
        for(int i = 0; i < arr.length-1;i++){
            for(int j = i+1 ; j<arr.length ;j++){
                if(arr[i] > arr[j]){
                    int x =arr[j];
                    arr[j] =arr[i];
                    arr[i] = x;
                }
            }
        }
        System.out.println(".......");
         for(int x : arr){
            System.out.print(x + " ");
        }
    }
}
