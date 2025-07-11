
// leader in array 
// in this problem we have to find the elements on whose right all the number are smalled to them 
// for eg we have an array = { 10,22,12,3,0,6}
// so leaders in this array are 22 12 and 6 as to their right nothing is grater than them 
import java.util.*;

public class leader_in_array {
    public static void main(String[] args) {
        int[] arr = { 10, 22, 12, 3, 0, 6 };

        // ArrayList<Integer> newArr = brute_force(arr);
        ArrayList<Integer> newArr = optimal_solution(arr);
        
        System.out.println("Leaders of the array ");
        for (int x : newArr) {
            System.out.print(" " + x);
        }
    }

    public static ArrayList<Integer> brute_force(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int flag = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    flag++;
                    break;
                }
            }
            if (flag == 0) {
                result.add(arr[i]);
            }
            flag = 0;
        }
        result.add(arr[arr.length-1]);
        return result;
    }

    public static ArrayList<Integer> optimal_solution(int [] arr ){
        
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = arr.length-1 ; i >= 0 ; i-- ){
         if(arr[i] > max){
            result.add(arr[i]);
            max = arr[i];
         }
        }
        return result;
    }








}
