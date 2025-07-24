import java.util.*;
// Pascal Triangle: 

/*Pascal's Triangle is a triangular array of numbers where each number is the sum of the two numbers directly above it. It starts with a single 1 at the top, and each subsequent row is constructed by adding the numbers above to get the new values. Here's an example of the first six rows:

       1
      1 1
     1 2 1
    1 3 3 1
   1 4 6 4 1
 1 5 10 10 5 1
 
 */
// three variation of questions

// variation 1: given row and column , tell the element at that position 

public class pascal_triangle {
    public static void main(String[] args) {
        int row = 5;
        int column = 3;
        // int output = num_at_pos(row, column);

        // System.out.println("output: " + output);

        // int n = 20;
        // int n1 = 20;
        // variation_2_brute(n);
        // System.out.println("\n-------");
        // varitation_2_optimal(n1);

        int n = 5;
        List<List<Integer>> ans = whole_pascal_triangle(n);

        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

    }

    // variation 1: given row and column , tell the element at that position
    // brute force approach is to generate whole pascal triangle and then find the
    // element at rth row and cth column
    // optimal aproach ~
    // we have direct formula to find the element of pascal triable at rth row and
    // cth column
    // r-1 C c-1 ( r-1 combination c-1)
    // n C r ~ n! / r ! (n-r)!

    // instead of solving this factorial we have shortcut
    // for 10 C 2 we need 10 9 and 2 and 1 (10 / 2) * (9 /1)

    public static int num_at_pos(int row, int column) {
        int final_result = func_nCr(row - 1, column - 1);

        return final_result;
    }

    public static int func_nCr(int n, int r) {

        int result = 1;

        for (int i = 0; i < r; i++) {
            result = result * (n - i);
            result = result / (i + 1);
        }
        return result;
    }

    // Variation 2 : given n which is row n we have to generate all the elements for
    // that row occuring in a pascal triangle

    // brute force approach for solving this problem is simple we know that
    // for nth row we will be having n elements
    // we know first and last element will remain 1
    // a rth row n cth column we will have r-1 C c-1 element
    // so we run a loop from c = 2 to n - 2;
    // and r will remain same i.e n
    // but this approach takes O( n x r ) time n ~ loop , r ~ finding factorial
    // so we have to optimise it based on our observation

    public static void variation_2_brute(int n) {

        System.out.print(1 + " ");

        for (int i = 2; i < n; i++) {
            System.out.print(func_nCr(n - 1, i - 1) + " ");
        }
        if (n != 1) {
            System.out.print(1 + " ");
        }
    }

    // by observation we observe that first and last element will always be one
    // and the elemenets in betweeen follows a simple rule
    // ans = 1 ; (initially )
    // for ( i = 1 -> n){
    // ans = ans * (n - i ); vch is row - column
    // ans = ans / (i) ;
    // }

    public static void varitation_2_optimal(int n) {

        int ans = 1;
        System.out.print(ans + " ");

        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / (i);
            System.out.print(ans + " ");
        }

    }
    // In variation 3 we have to print whole pascal triangle till the given n
    // Brute force approach is to use the formula rows -1 C column -1
    // for individual element
    // in this problem the ans must be returned in the type of list containg
    // variaous list vch in turn containig the integers
    // brute force approach will take = 0(n*n*r) ~ O(n^3);
    // to solve this problem optimally we use the methof we used in variation 2 to
    // solve optimally
    // which gonna take O(n^2);
    //

    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();

        ansRow.add(1);

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / (col);
            ansRow.add((int) ans);
        }
        return ansRow;
    }

    public static List<List<Integer>> whole_pascal_triangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 1; row <= n; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }
}