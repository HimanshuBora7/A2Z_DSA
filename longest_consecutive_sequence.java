// in this problem we have to return the length of the longest consecutive sequence

//for eg we have arr {102,4,100 ,1,101,3,2,1}
// so the longest consecutive subsequence that can be formed here is 1,2,3,4 
// whose length is 4 which would be our answer 

public class longest_consecutive_sequence {
    public static void main(String[] args) {
        // int[] arr = { 100, 4, 200, 1, 3, 2 };
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        int solution = hash_sol(arr);
        System.out.print(solution);

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

        int max_len = 0 ;
        int len = 0;

        for(int i = 0 ; i < hashArr.length ; i++){
        if(hashArr[i] > 0 ){
            len++;
            max_len = Math.max(max_len, len);
        }
        else{
            len = 0;
        }
        }
        return max_len;
    }
}
