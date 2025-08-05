// Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.

import java.util.*;

public class overlapping_problem {
    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 8, 11 }, { 2, 6 }, { 15, 18 } };
        // System.out.println("array ");

        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[0].length; j++) {
        // System.out.print(arr[i][j]);
        // }
        // System.out.println();
        // }
        // }
        List<List<Integer>> output = brute_force(arr);

        for (List<Integer> li : output) {
            System.out.print("[ ");
            for (int x : li) {
                System.out.print(x + " ");
            }
            System.out.print(" ]");
        }
    }

    public static List<List<Integer>> brute_force(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            // skip all the merged intervals:
            if (!result.isEmpty() && end <= result.get(result.size() - 1).get(1)) {
                continue;
            }
            // check rest of the interval

            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }
            result.add(Arrays.asList(start, end));
        }
        return result;
    }

}
