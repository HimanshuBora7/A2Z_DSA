
import java.util.ArrayList;
import java.util.Arrays;

//intersection of two arrays 
//inclusion of common elements from both the array 
//unlike union here reprtition is allowed 
//  eg a = { 1,2,2,3,3,4,5,6}
//  b = { 2,3,3,5,6,6,7}
// Intersection [] = {2,3,3,5,6}

//-----  BRUTE -- FORCE -- APPROACH -----

public class intersection {
    public static void main (String [] args ){
        int [] arr1 = {1,2,2,3,3,4,5,6};
        int [] arr2 = {2,3,3,5,6,6,7};
        System.out.println("ARRRAY 1 : ");
        for(int x : arr1){
            System.out.print(x + " ");
        }
        System.out.println("\nArray 2 : ");
        for(int y : arr2 ){
            System.out.print(y + " ");
        }
        ArrayList<Integer> newArray = intersect(arr1, arr2);
        System.out.println("\nFinal Intersected array");
        for(int z : newArray){
            System.out.print(z + " ");
        }

    }
    public static ArrayList<Integer> intersect(int arr1 [] ,int arr2 []){
    int n1 = arr1.length;
    int n2 = arr2.length;
    
    //Array list to store the result 

    ArrayList<Integer> ans = new ArrayList<>();

    int [] visted = new int[n2]; // to keep check if the element from 2nd array is already visited or not 
    Arrays.fill(visted,0);
    for(int i = 0 ; i <n1 ;i++){
        for(int j = 0 ; j < n2 ; j++){
            if(arr1[i] == arr2[j] && visted[j] ==0){
             ans.add(arr1[i]);
             visted[j] = 1;
             break;
            }
            if(arr2[j] > arr1[i]){
                break;
            }

        }
    }
    return ans;
    }
    
}
