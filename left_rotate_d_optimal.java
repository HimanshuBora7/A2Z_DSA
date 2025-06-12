//optimise the previous method of solving array rotation problem
//here with new approach of reversal of array we wil get O(1) as space complexity and O(n) as time complexity
//the logic is simmple which is derived by observation 
//suppose we have to rotate an array by d position 
//so we reverse first d element from the start 
//n then we reverse the elements from d+1 to n 
//and in thirs step we reverse thw whole of the array 


public class left_rotate_d_optimal {
public static void main (String [] args){
    int [] arr = {1,2,3,4,5,6,7};
    int d = 3;

    System.out.println("original array ");
        for(int x : arr){
            System.out.print(x + " ");
        }

    Rotate_Array(arr, arr.length, d);

     System.out.println("\nreversed array ");
        for(int x : arr){
            System.out.print(x + " ");
        }
}    
public static void Rotate_Array(int [] arr , int n,int d){
 rev_array(arr, 0, d);
 rev_array(arr, d, n);
 rev_array(arr, 0, n);
}
public static void rev_array(int [] arr , int a , int b ){
    int j = b-1;
    for(int i = a ; i < j ; i++){
     int temp = arr[j];
     arr[j] = arr[i];
     arr[i] = temp;
     j--;
    }

}
}
/*Key Difference
✅ Reversing an entire array → traverse half the array to swap elements.
✅ Rotating using reversal → traverse each segment fully, because partial reversals preserve rotation rather than flipping the order.
*/