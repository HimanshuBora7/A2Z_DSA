
//Find the majority element from the array which apprears more than N/2 times
//
import java.util.*;

public class majority_element {

    public static void main(String[] args) {
        int[] arr = { 3, 2, 3, 3, 1, 2, 2, 3, 3, 3 };
        // int z = brute_force(arr);
        // int z = better_Way(arr);
        // int z = better_Way_hashmap(arr);
        // System.out.println("Maximum number which occurs more than " + arr.length / 2
        // + " times is " + z);
        int y = moores_Algo(arr);
        if (y != -1) {
            System.out.println("Maximum number which occurs more than " + arr.length / 2 + " times is " + y);
        }
        else{
            System.out.println("none found ");
        }
    }

    public static int brute_force(int[] arr) {
        int num = -1;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    counter++;
                }
            }
            // System.out.println("counter count " + i + " : : " + counter);
            // System.out.println("target " + arr.length/2);
            if (counter > arr.length / 2) {
                num = arr[i];
                break;
            } else {
                counter = 0;
            }

        }
        return num;

    }

    // better approach would be using hashing , which will reduce time complexity
    // from n^2 to n but adds space
    // won't work if it consists of newgative number
    public static int better_Way(int[] arr) {
        int max_num = -1;
        int n = arr.length;
        // creating hash table to store occurence of each element
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] newArr = new int[max + 1];
        // storing the occurence

        for (int i = 0; i < n; i++) {
            newArr[arr[i]]++;
        }
        for (int j = 0; j < newArr.length; j++) {
            if (newArr[j] > n / 2) {
                max_num = j;
            }
        }
        return max_num;

    }

    // so instead of this we can use hash map
    // in hash map key will be the element of array and value will be its occurences
    // update the hashmap using getorDefault(key,defaultValue) to handle numbers not
    // yet in the map
    public static int better_Way_hashmap(int[] arr) {

        HashMap<Integer, Integer> countMap = new HashMap<>();
        int n = arr.length;

        for (int x : arr) {
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
            if (countMap.get(x) > n / 2) {
                return x;
            }
        }
        return -1;

    }

    // Moore's voting algorithm provides the optimal solution for this problem
    //The key idea is that since the majority element appears more than n/2 times, 
    //it will "survive" pairwise cancellations with non-majority elements.


    // first we apply moores algo to find the dominating element and
    // then in second step we check if its count is greater than n/2 (with fresh
    // iteration )
    // -- moores algo --
    // we have two variable 1. Element 2.count
    // rule is simple element is initialised with first element of the array and
    // then count is initialised with one
    // if next element is same as previous one we increment the count variable
    // if not we decrement
    // if count reaches 0 after decrement we update the element with element at ith
    // index and initialise counter agian to 1
    // and at last we get our dominating element we was not cancelled by
    // so we check if its original count in array is more than n/2 which we will
    // require fresh iteration with new counter

    public static int moores_Algo(int[] arr) {
        int num = -1;

        int element = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
           if(count == 0){
            count = 1;
            element = arr[i];
           }
           else if( element == arr[i]) count++;
           else count--;
        }
        int counter = 0;
        for (int x : arr) {
            if (x == element) {
                counter++;
            }
        }
        if (counter > arr.length / 2) {
            num = element;
            return num;
        } else {
            return num;
        }
    }

}
