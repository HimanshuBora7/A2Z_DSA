//find the longest subarray with given sum (positives only )
//subarray are the contigous element os the array n their sum must be equal to K and the length of that subarray must be maximumm

// -- BRUTE -- FORCE -- APPROACH --
// we find all the subarray n check their sum , whenever the sum matches with our k we take the maximum of current length vch is i-j+1(+1 is to adjust 0 based indexing ) and the previous length
// we return the maximum length in output
public class longest_Subarray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int [] arr2 = {1,2,3};
        int k = 3;
        int k2 = 2;
        // int z = max_len_brute(arr, k);
        int z = max_len_optimal(arr2, k2);
        System.out.println("answer is " + z);

    }

    public static int max_len_brute(int[] arr, int k) {
        int length = 0;

        // generating all possible subset
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                // now the subarrays lies b/w i and j, calculating their sum

                for (int z = i; z <= j; z++) {
                    sum += arr[z];
                }
                    // now checking if it equal to our given sum and if yes what is lenght
                    if (sum == k) {
                        length = Math.max(length, j - i + 1);
                    }
            }
        }
       
        return length;
    }

     // -- optimised way -- 
 // tweaking the existing brute force approach by removing the need of 3rd loop vch was making our tc to n^3;
 // so instead of doing summation again n again what we will do this time is that we will go on adding the new element as the j loop progressees further 


    public static int max_len_optimal(int[] arr, int k) {
        int length = 0;

        // generating all possible subset
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum+=arr[j];

                 if(sum == k){

             length = Math.max(length, j-i+1);
            }
            }
           
        }
       
        return length;
    }






}
