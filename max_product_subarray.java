// Given an array that contains both -ve and +ve integers.Find the maximum poduct subarray 

public class max_product_subarray {
    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4, 5, 0 };
        int arr[] = { 1, 2, -3, 0, -4, -5 };
        int output = better_approach(arr);
        System.out.println("output: " + output);

    }
    // brute force is simple trying out all pairs using 3 loops vch will lead to T.C
    // of O(n^3)
    // better approach wld be removing the 3rd loop and multiplying the previous
    // product successively as element gets added this will lead to tc of O(n^2);

    // public static int brute_force(int [] arr ){

    // }

    public static int better_approach(int[] arr) {
        int max_product = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            for (int j = i; j < arr.length; j++) {
                product *= arr[j];
                max_product = Math.max(product, max_product);
            }
        }
        return max_product;
    }
}
