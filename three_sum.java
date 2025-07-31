
//Problem statement is return an unique array of 3 elements which upon their sum will give zero
// those three elements must be uniquw vch means i != j != k
import java.util.*;

public class three_sum {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        // List<Integer> output = brute_force(arr);
        int n = arr.length;

        // List<List<Integer>> output = brute_force_2(n, arr);
        // List<List<Integer>> output = better_solution(n, arr);

        List<List<Integer>> output = optimal_approach(n, arr);

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

    public static List<List<Integer>> better_solution(int n, int[] arr) {

        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> hashset = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(arr[i] + arr[j]);

                if (hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    st.add(temp);
                }
                hashset.add(arr[j]);
            }
        }

        // store the set elements in the answer
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;

    }

    // optimal approach is to use two pointer approach kind of thing
    // but to apply two pointer approach we need a sorted array first
    // then we declare threen variables i j and k
    // i at initial position j at i+1 and k at the very end
    // we take sum of i , j and k
    // compare it with zero
    // if it exceeds we try to dec the sum by reducing k
    // if it is deficiet of zero we add some weight by moving j
    // we stop if j and k crosses each other
    // and update i to new index vch wld be holding new uqiue element

    public static List<List<Integer>> optimal_approach(int n, int[] arr) {

        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            if (i != 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int k = n - 1;
            int j = i + 1;
            while (j < k) {

                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    result.add(temp);
                    j++;
                    k--;

                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                    while (j < k && arr[k] == arr[k + 1])
                        k--;
                }
            }
        }
        return result;
    }

}
