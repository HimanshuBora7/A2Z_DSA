// Find the elements in an array which are occuring more than N/3 times
// we will use the intiution we used in finding the maximum element occuring more than N/2 times previously using moore's algo

// by observation we can deduce that at max there can be only 2 element which would have their count more than N/3 times

import java.util.*;

public class max_element_nby3 {
    public static void main(String[] args) {

        int[] arr = { 1, 1, 1, 3, 3, 2, 2, 2 };
        // List<Integer> output = brute_force(arr);
        // List<Integer> output = better_approach(arr);
        List<Integer> output = optimal_Approach(arr);

        System.out.print("Result ");
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
    // optimal approach to solve this probelm would be modifying the moores algo we
    // studied for finding the element occuring > N/2
    // for N/3 here we know that at max only two elements can exceed N/3 count so we
    // store them in el1 and el2 vch both should be unique
    // and check what not gets cancelled
    // so at the end we get two dominating elements from the array now in last step
    // we have to check if their occurrence exceeds N/3 count or not

    public static List<Integer> optimal_Approach(int[] arr) {
        int counter1 = 0; // to track the occurence of element 1
        int counter2 = 0; // to track the occurence of element 2

        int el1 = -1; // holding element 1
        int el2 = -1; // holding element 2

        for (int i = 0; i < arr.length; i++) {
            if (counter1 == 0 && arr[i] != el2) {
                counter1 = 1;
                el1 = arr[i];
            } else if (counter2 == 0 && arr[i] != el1) {
                counter2 = 1;
                el2 = arr[i];
            } else if (el1 == arr[i]) {
                counter1++;
            } else if (el2 == arr[i]) {
                counter2++;
            } else {
                counter1--;
                counter2--;
            }
        }
        // at the end of this we have two dominating elements el1 and el2
        // now we have to make sure that their occurence is more than n/3

        List<Integer> result = new ArrayList<>();

        int counter5 = 0;
        for (int x : arr) {
            if (x == el1) {
                counter5++;
            }
            if (counter5 > arr.length / 3) {
                result.add(x);
                break;
            }
        }
        int counter3 = 0;
        for (int y : arr) {
            if (y == el2) {
                counter3++;
                int x = Integer.MIN_VALUE;
            }
            if (counter3 > arr.length / 3) {
                result.add(y);
                break;
            }
        }
        return result;

    }
}
