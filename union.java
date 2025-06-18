// Union of two **SORTED ARRAY**     
// -- brute force approach 
// using 

import java.util.*;

public class union {
    public static void main (String [] args ){
         int arr1[] = {1,2,3,4,5};
         int [] arr2 = { 4,5,6,7};

         System.out.println("ARRAY 1 : ");
         for(int x : arr1){
            System.out.print(x + " ");
         }
         System.out.println("\nARRAY 2 : ");
         for(int x : arr2){
            System.out.print(x + " ");
         }
         int [] arrUnion = UnionArray(arr1, arr2);
         System.out.println("\nUnion Array : ");
         for(int x : arrUnion){
            System.out.print(x + " ");
         }
          
    }
    public static int [] UnionArray(int [] arr1 , int [] arr2){
        Set<Integer> set = new TreeSet<>();
        for (int num :arr1){
            set.add(num);
        }
        for(int num : arr2){
            set.add(num);
        }
        int [] result = new int [set.size()];
        int index = 0;
        for(int num : set){
            result[index++] = num;
        }
        return  result;
    }
}
