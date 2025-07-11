import java.util.*;

// in this problem we have to return the length of the longest consecutive sequence
//for eg we have arr {102,4,100 ,1,101,3,2,1}
// so the longest consecutive subsequence that can be formed here is 1,2,3,4 
// whose length is 4 which would be our answer 
public class longest_consecutive_sequence {

    public static void main(String[] args) {
        // int[] arr = { 100, 4, 200, 1, 3, 2 };
        int[] arr = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        // int solution = hash_sol(arr);
        // int solution = better_Approach(arr);
        int solution = optimal_approach(arr);


        System.out.print("answer " + solution);

    }
    // hash solution can't be used for negative numbers

    public static int hash_sol(int[] arr) {
        // so first idea I got here to solve the problem is that I create a hashmap
        // store the the occurence of each element then iterate over the hashmap to
        // check the consecutivity
        // only drawback I see at first glance is wastage of space but the algorithm
        // will run in O(n)time

        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > max) {
                max = x;
            }
        }
        int[] hashArr = new int[max + 1];

        for (int x : arr) {
            hashArr[x]++;
        }

        int max_len = 0;
        int len = 0;

        for (int i = 0; i < hashArr.length; i++) {
            if (hashArr[i] > 0) {
                len++;
                max_len = Math.max(max_len, len);
            } else {
                len = 0;
            }
        }
        return max_len;
    }

    // brute force apprach is to check arr[i+1] everytime by traversing the whole
    // array for each element
    // time complexity for brute force approach will be O(n^2);
    // so better solution for solving this problem is to
    // first sort the array
    // take 3 variables least_num vch will store the previous occuring value to the
    // current value
    // current couter ~ which will be increased if least_num == arr[i] -1 ;
    // longest ~ this variable will be holding the maximum of longest and current
    // counter
    public static void mergerSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (high + low) / 2;
        mergerSort(arr, low, mid);
        mergerSort(arr, mid + 1, high);
        merge(arr, low, mid, high);

    }

    public static void merge(int[] arr, int low, int mid, int high) {

        int left = low;
        int right = mid + 1;

        ArrayList<Integer> temp = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static int better_Approach(int[] arr) {
        // first step is to sort the array
        mergerSort(arr, 0, arr.length - 1);

        // now array is sorted we can inititalise three variable and traverse it

        int longest = 1;
        int curr_count = 0;
        int prev_value = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - 1 == prev_value) {
                curr_count++;
                prev_value = arr[i];
            } else if (arr[i] != prev_value) {
                curr_count = 1;
                prev_value = arr[i];
            }
            longest = Math.max(longest, curr_count);
        }

        return longest;

    }

    public static int optimal_approach(int [] arr ){
 
    Set<Integer> set = new HashSet<>();
    
    int longest = 0 ; 

    for(int i = 0 ; i < arr.length ; i++){
     set.add(arr[i]);
    }
    for( int it : set ){
      if(!set.contains( it - 1)){
         int cnt = 1 ;
         int x = it ;
         while(set.contains(x + 1)){
            x = x +1;
            cnt =cnt +1;
         }
       longest = Math.max(longest, cnt);
      }
    }
  return longest;
    }
}
