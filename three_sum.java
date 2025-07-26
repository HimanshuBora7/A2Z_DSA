
//Problem statement is return an unique array of 3 elements which upon their sum will give zero
// those three elements must be uniquw vch means i != j != k
import java.util.*;

public class three_sum {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        // List<Integer> output = brute_force(arr);
        int n = arr.length;

        List<List<Integer>> output = brute_force_2(n, arr);

        for (List<Integer> it : output) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }

    }

    // Brute force approach to solve this problem is using three loop i , j , k to
    // try out all possible combination for every element in an array

    public static List<Integer> brute_force(int[] arr) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; j < arr.length; j++) {
                    if ((arr[i] + arr[j] + arr[k]) == 0) {

                        result.add(arr[i]);
                        result.add(arr[j]);
                        result.add(arr[k]);
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> brute_force_2(int n, int[] arr) {

        Set<List<Integer>> st = new HashSet<>();

        // checking for all possible combination
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);

                        temp.sort(null);
                        st.add(temp); // Passing null to the sort method indicates that the natural ordering of the
                                      // elements should be used.

                    }
                }
            }
        }
        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}
