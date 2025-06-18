//find the union of two **sorted** array 
//in optimal approach we will be using the fact that arrays are sorted 
//so we will use two pointer approach where i n j will be set to first index of both the array 
//now we will store the answers of union in a list
// we will compare i nd j whichever will be small we will chosse that
//then we will check if the preceding element in list is equivalent to that or not
//if it is not present then we insert it and increments the index 
//if it is present then without insertion we will increase the index of one of them 
// at last we will check if one of the array is exahausted then the array with remaining element will be inserted in set as it is 
import java.util.*;
public class union_optimal {
    public static void main (String [] args ){
        int arr1[] = {1,1,2,3,4,5};
         int [] arr2 = { 4,5,6,7,8,8,9,10};

         System.out.println("ARRAY 1 : ");
         for(int x : arr1){
            System.out.print(x + " ");
         }
         System.out.println("\nARRAY 2 : ");
         for(int x : arr2){
            System.out.print(x + " ");
         }
         List<Integer> unionArrayResult = UnionArray(arr1, arr2);
         System.out.println("Final Union :");
         for(int x : unionArrayResult){
            System.out.print(x + " ");
         }
    }
    public static List<Integer> UnionArray(int [] arr1 ,int [] arr2 ){
      int i = 1 ;
      int j = 1 ;
      int k = 0;
      List<Integer> union = new ArrayList<>();

      if(arr1[0] < arr2[0]){
        union.add(arr1[0]);
        
      }
      else{
        union.add(arr2[0]);
       
      }
      


      while( i < arr1.length && j < arr2.length){
         if(arr1[i] < arr2[j]){
           if(union.get(k) != arr1[i]){
            union.add(arr1[i]);
            i++;
            k++;
           }
           else{
            i++;
           }
         }
         else if(arr2[j] < arr1[i]){
              if(union.get(k) != arr2[j]){
            union.add(arr2[j]);
            j++;
            k++;
           }
           else{
            j++;
           }

         }
         while(i < arr1.length){
            if(union.get(k) != arr1[i]){
            union.add(arr1[i]);
            i++;
            k++;
            }
            else{
                
                i++;
            }
            

         }
         while(j < arr2.length){
          if(union.get(k) != arr2[j]){
            union.add(arr2[j]);
            j++;
            k++;
          }
          else{
            j++;
           
          }
         }
      }
      return union;
    }
}
