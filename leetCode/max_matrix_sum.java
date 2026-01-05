package leetCode;

/*
 * You are given an n x n integer matrix. You can do the following operation any
 * number of times:
 * 
 * Choose any two adjacent elements of matrix and multiply each of them by -1.
 * 
 * Two elements are considered adjacent if and only if they share a border.
 * 
 * Your goal is to maximize the summation of the matrix's elements. Return the
 * maximum sum of the matrix's elements using the operation mentioned above.
 */
public class max_matrix_sum {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 },
                { 1 - 1, -2, -3 }, { 1, 2, 3 } };
        int count = sol(arr);
        System.out.println(count);
    }

    public static int sol(int[][] arr) {
        // first we count if the count of negative elements in an array is positive or
        // negative

        int count = 0;
        /*
         * you can move the "negativity" to any number. You want to pick the number that
         * has the smallest impact on the sum, which is the number closest to zero (the
         * minimum absolute value).
         */

        int least_num = Integer.MAX_VALUE;

        for (int[] x : arr) {
            for (int j : x) {
                if (Math.abs(j) < least_num) {
                    least_num = Math.abs(j);
                }
                if (j < 0) {
                    count++;
                }
            }
        }
        // if count is even then we can transform every num to positive by swapping the
        // sign or multiplying the adjacent elements by 1 so we
        // for maximum sum we can simply take the absolute value of every element
        // present in the matrix and sum it

        int sum = 0;

        for (int[] x : arr) {
            for (int j : x) {
                sum += Math.abs(j);
            }
        }
        if (count % 2 == 0) {
            return sum;
        }
        // if the count is odd then we are forced to use one negative number so to
        // maximize our sum of matrix we will make the least of the number to negative
        // if it is positive , to optimise this we can find the least number during the
        // count traversal
        //
        else {
            // if the count is odd then our least num will remain negative so it has to be
            // subtracted twice from the absolute sum
            // as first its absolute value got added during the sum
            // second time as we are making it negative
            return sum -= (2 * least_num);
        }

    }
}