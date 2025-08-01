// 4 sum problem : return the pair of 4 elments whose sum adds up to give the target value those 4 elements shoould be unique 

import java.util.*;

public class four_sum {
    public static void main(String[] args) {
        int[] arr = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        // int[] arr = { 1, 4, 2, 3, 6, 5, 4, 8 };

        // int target = 10;
        // List<List<Integer>> answer = brute_force(arr, target);

        // List<List<Integer>> answer = better_approach(arr, target);

        List<List<Integer>> answer = optimal_approach(arr, target);

        for (List<Integer> it : answer) {
            System.out.print("[ ");
            for (int a : it) {
                System.out.print(a + " ");
            }
            System.out.print(" ]");
        }
    }

    public static List<List<Integer>> brute_force(int[] arr, int target) {

        int n = arr.length;
        // brute force approach would be to try out all the possible combinations using
        // 4 loops
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (arr[i] + arr[j] + arr[k] + arr[l] == target) {
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            st.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(st);
        return result;
    }

    // as brute force is taking O(n^4) we can trim it down to O(n^3) by removing the
    // fourt loop and introducing hashset like we did in three sum problem

    public static List<List<Integer>> better_approach(int[] arr, int target) {

        int n = arr.length;
        Set<List<Integer>> result1 = new HashSet<>();

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                HashSet<Integer> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int sum = target - (arr[i] + arr[j] + arr[k]);
                    if (hashset.contains(sum)) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], sum);
                        result1.add(temp);
                    }
                    hashset.add(arr[k]);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(result1);
        return result;
    }

    // optimal appraoch to solve this problem is similar to optimal approach to
    // solve 3 sum problem where we have used 3 pointer instead of 4 here we will be
    // using 4 variable i,j,k,l
    // First step is to sort the array
    // i n j will be fixed k and L will be moving
    // while incrementing variables we have to make sure that they don't take
    // similar value , they must be incremented to unique value

    public static List<List<Integer>> optimal_approach(int[] arr, int target) {

        int n = arr.length;

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {

            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = arr[i];
                    sum += arr[j];
                    sum += arr[k];
                    sum += arr[l];

                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);

                        result.add(temp);
                        k++;
                        l--;
                        while (k < l && arr[k] == arr[k - 1])
                            k++;
                        while (k < l && arr[l] == arr[l + 1])
                            l--;
                    } else if (sum < target) {
                        k++;
                    }

                    else {
                        l--;
                    }
                }
            }
        }
        return result;
    }
}
