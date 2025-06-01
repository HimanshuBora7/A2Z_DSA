//insertion sort
//we consider 0th element as sorted 
//and frm rest of the unsorted array we choose
// the left most element and place it in the correct order 
//in the sorted subarray 
public class insertion {
    public static void main(String[] args) {
        int[] array = { 3, 2, 6, 9, 1 };
        System.out.println("unsorted array ");
        for (int x : array) {
            System.out.print(x + " ");
        }
    
        for (int i = 1; i < array.length; i++) {
            int m = array[i];
            int j = i - 1;
            while ( j >= 0 && array[j] > m ) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = m;

        }
        System.out.println("\n.S.O.R.T.E.D.\n");
        for (int x : array) {
            System.out.print(x + " ");
        }
    }
}
