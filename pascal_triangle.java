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
        int output = num_at_pos(row, column);

        System.out.println("output: " + output);

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
}