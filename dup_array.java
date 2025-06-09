
//remove duplicate element from the sorted array
import java.util.ArrayList;

public class dup_array {
    public static void main(String[] args) {
        int[] array = { 1, 2, 2, 3, 3, 4, 5 };
        ArrayList<Integer> result = array1(array, array.length);
        System.out.println("ArrayList with duplicates removed " + result);
    }

    public static ArrayList<Integer> array1(int[] arr, int n) {

        ArrayList<Integer> lis1 = new ArrayList<>();
        lis1.add(arr[0]);

        for (int i = 1; i < n; i++) {

            if (arr[i] != lis1.get(lis1.size() - 1)) {
                lis1.add(arr[i]);
            }
        }
        return lis1;
    }
}
