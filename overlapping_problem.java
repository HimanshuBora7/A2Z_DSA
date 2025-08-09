// Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.

import java.lang.reflect.Array;
import java.util.*;

public class overlapping_problem {
    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 8, 11 }, { 2, 6 }, { 15, 18 } };
        int[][] arr2 = { { 1, 3 }, { 2, 6 }, { 8, 9 }, { 9, 11 }, { 8, 10 }, { 2, 4 }, { 15, 18 }, { 16, 17 } };
        // System.out.println("array ");

        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[0].length; j++) {
        // System.out.print(arr[i][j]);
        // }
        // System.out.println();
        // }
        // }
        // List<List<Integer>> output = brute_force(arr);
        List<List<Integer>> output = optimal_approach(arr);

        for (List<Integer> li : output) {
            System.out.print("[ ");
            for (int x : li) {
                System.out.print(x + " ");
            }
            System.out.print(" ]");
        }
        optimal_approach(arr2);
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
    // optimal approach to solve this problem would be doing it in single iteration

    public static List<List<Integer>> optimal_approach(int[][] arr) {

        // System.out.println("Original Array ");
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[0].length; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }

        // Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0])); // fails if first
        // element are same

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        // System.out.println("Sorted Array ");
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[0].length; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            if (result.isEmpty() || arr[i][0] > result.get(result.size() - 1).get(1)) {
                result.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {
                result.get(result.size() - 1).set(1, Math.max(result.get(result.size() - 1).get(1), arr[i][1]));
                // set(index , value)
            }

        }
        return result;
    }
}
