// print a matrix in spiral way 
// to solve this problem there is only one way vch is also the optimal one 

public class spiral_matrix {
    public static void main(String[] args) {
        // int[][] arr = {
        // { 1, 2, 3, 4, 5, 6 },
        // { 20, 21, 22, 23, 24, 7 },
        // { 19, 32, 33, 34, 25, 8 },
        // { 18, 31, 36, 35, 26, 9 },
        // { 17, 30, 29, 28, 27, 10 },
        // { 16, 15, 14, 13, 12, 11 },

        // };
        int[][] arr = {
                { 1, 2, 3, 4, },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };

        spiral_print(arr);

    }

    public static void spiral_print(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        int top = 0;
        int left = 0;

        int right = columns - 1;
        int bottom = rows - 1;

        // basically to print the array in spiral form we have to traverse in a sequence
        // vch is
        // right --> bottom --> left --> top

        while (top <= bottom && left <= right) {
            // tracing towards right
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            // tracing towards bottom
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            if (top <= bottom)// handle edge case like single row or column is given
            {
                // tracing towards left
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }
            // tracing towards top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;

            }
        }
    }

}
