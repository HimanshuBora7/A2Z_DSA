//bubble sort 
//adjacent elements are compared and swapped accordingly
public class bubble {
    public static void main(String[] args) {
        int[] array = { 3, 2, 6, 9, 1 };
        System.out.println("unsorted array ");
        for (int x : array) {
            System.out.print(x + " ");
        }

        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j <= i-1; j++) {

                if (array[j] > array[j + 1]) {
                    int temp;
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("\n.S.O.R.T.E.D.\n");
        for (int x : array) {
            System.out.print(x + " ");
        }
    }
}
