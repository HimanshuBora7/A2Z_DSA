//linear search : search an element and return its index 

public class linearSearch {
    public static void main (String [] args ){
    int [] arr = {1,2,3,4,5,6,7,8};
    int a = 9;
    int b = Linear(arr, a) +1; 
    
    if(b != 0 ){
        System.out.println("Element found at " + b + "th position" );
    }
    else{
        System.out.println("Element not found" );
    }
    
    }
    public static int Linear(int [] arr, int a ){
        int x = -1 ;
        for(int i = 0 ;i < arr.length ;i ++){
         if(arr[i] == a){
            x = i;
            break;
         }
         
        }
        return x;
    }
}
