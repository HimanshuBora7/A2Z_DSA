// Find the elements in an array which are occuring more than N/3 times
// we will use the intiution we used in finding the maximum element occuring more than N/2 times previously using moore's algo

// by observation we can deduce that at max there can be only 2 element which would have their count more than N/3 times

import java.util.*;

public class max_element_nby3 {
    public static void main(String[] args) {

        int[] arr = { 1, 1, 1, 3, 3, 2, 2, 2 };
        // List<Integer> output = brute_force(arr);
        List<Integer> output = better_approach(arr);

        System.out.println("Result ");
        for (int x : output) {
            System.out.print(x + " ");
        }

    }
    // brute force approach to solve this problem is simple we iterate over the
    // whole array and find individual elements count and store it in list and as
    // the list gets two element we return it as we know there can be only two
    // element

    public static List<Integer> brute_force(int arr[]) {

        List<Integer> result = new ArrayList<>();
        int occcurence = arr.length / 3;

        int count = 0;
        int track = 0;

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == temp) {
                    count++;
                }
            }
            if (count > occcurence) {

                if (!(result.contains(arr[i]))) {
                    result.add(arr[i]);
                }
            }
            if (track == 2) {
                return result;
            }
            count = 0;
        }
        return result;
    }

    // better approach would be using a hashMap to reduce the time complexity from
    // O(n^2) to O(n);

    public static List<Integer> better_approach(int arr[]) {

        List<Integer> output = new ArrayList<>();

        Map<Integer, Integer> result = new HashMap<>();
        int occcurence = arr.length / 3;

        int counter = 0;

        for (int x : arr) {
            result.put(x, result.getOrDefault(x, 0) + 1);
            if (result.get(x) > occcurence) {
                if (!(output.contains(x))) {
                    output.add(x);
                    counter++;
                }
                if (counter > 2) {
                    break;
                }
            }
        }
        return output;
    }

}
