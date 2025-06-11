//rotate an array left by one place 
//eg suppose we have an array {1,2,3,4,5}
//then its left rotation will be 
//{2,3,4,5,1}
//brute force solution for this will be using another array for storing purpose
//but here we gonna solve the question while using single array only 

public class left_rotate1 {
    public static void main (String [] args){
        int [] arr = {1,2,3,4,5,6,7};
        System.out.println("array without rotation");
        for(int x : arr){
            System.out.print(x + " ");
        }
        rotate(arr);
        
        System.out.println("array with rotation");
        for(int x : arr){
            System.out.print(x + " ");
        }
    
    }
    public static void rotate(int [] arr){
        int z = 0;
        while(z <= 3){
        int temp = arr[0];
        int i = 1 ;
        while(i < arr.length){
            arr[i-1] = arr[i];
            i++;
        }
        arr[i-1] = temp;
        z++;
    }
    }










}
