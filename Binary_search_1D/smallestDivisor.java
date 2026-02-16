package Binary_search_1D;

// Problem Statement:You are given an array of integers'arr'and an integer i.e.a threshold value'limit'.Your task is to find the smallest positive integer divisor,such that upon dividing all the elements of the given array by it,the sum of the division'sresult is less than or equal to the given threshold value.
public class smallestDivisor {
    public static void main(String[] args) {
        int[] arr = { 8, 4, 2, 3 };
        int k = 10;
        int result = brute(arr, k);

        if (result == -1)
            System.out.println("result not found ");
        else
            System.out.println("Answer is " + result);
    }

    // brute force is simple we know the answer can lie between only 1 and the
    // maximum number from the element
    // and the maximum sum that can reach is size of the array as upon dividing
    // every element gets 1
    public static int brute(int[] arr, int k) {

        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > max) {
                max = x;
            }
        }

        for (int i = 1; i <= max; i++) {
            int sum = 0;
            for (int x : arr) {
                sum += Math.ceilDiv(x, i);
            }
            if (sum <= k) {
                return i;
            }
        }
        return -1;
    }

    // public static int optimal (int n ,int [] arr , int k ){

    // // for optimal approach we have range of answers and we have to find the sm
    // }
}
