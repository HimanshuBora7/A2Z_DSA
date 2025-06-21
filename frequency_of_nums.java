//find the number that appears once in an array where
// frequency of every number is 2 except one number which we have to find 

// arr[] = { 1,1,2,3,3,4,4}
//like for the above array input the answer should be 2 

public class frequency_of_nums {
    public static void main(String[] args) {
        int[] arr = { 2,2,1 };
        // int x = find_num(arr);
        int x = find_num_optimal(arr);
        System.out.println(x);
    }

    // -- brute force approach -- //

    public static int find_num(int[] arr) {
        int count = 0;
        int x = -1;
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            // System.out.println(count);
            if (count == 1) {
                x = arr[i];
                break;
            } else {
                count = 0;
            }

        }
        return x;
        // time complexity : O(n^2) , sc: O(1)
    }

    // better approach using hashing

    // public static int find_num_better(int [] arr){
    // int maximum = 0 ;
    // int count = -1;
    // for(int x : arr){
    // if( x > maximum ){
    // maximum = x ;
    // }
    // }
    // int [] arr1 = new int[maximum+1];

    // for(int y : arr){
    // arr1[y]++;
    // }

    // for(int i = 0 ; i < arr1.length ;i++){
    // if(arr1[i] == 1){
    // count = i;
    // break;
    // }
    // }

    // return count;
    // }

    // the above written approach has a issue that it doesn't handle negative
    // numbers
    // like for input array -1 , this code will generate array out of bound errror
    // coz index -1 doesn't exist

    // so to accomodote this case we will follow the following approach
    // we will find the minimum and maximum then we will make array of size max -
    // min to accomodate -ver numbers also
    // the least number will become means positive so every number b4 that will
    // become positive
    // we will plot the number of new array
    // while returning the number will make sure to add aur min value back which we
    // subtracted

    public static int find_num_better(int[] arr) {
        int maximum = arr[0];
        int minimum = arr[0];
        int count = -1;
        for (int x : arr) {
            if (x > maximum) {
                maximum = x;
            }
            if (x < minimum) {
                minimum = x;
            }
        }
        int[] arr1 = new int[maximum - minimum + 1];

        for (int y : arr) {
            arr1[y - minimum]++;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 1) {
                count = i + minimum;
                break;
            }
        }

        return count;
    }
    
    // optimal appraoch is far more simpler where we can just do XORing of number and the result would be the single element
    //a^a = 0
public static int find_num_optimal(int [] arr){
    int xor = 0;
    for(int x : arr){
        xor = xor^x;
    }
    return xor;
}

}
