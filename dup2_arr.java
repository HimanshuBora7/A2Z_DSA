//remove duplicates from the sorted array using optimal approach
//vch is two pointer approach where we get O(n) as time complexity and O(1) as space complexity 


public class dup2_arr {
    public static void main (String [] args){
    int [] arr = { 1,2,2,3,3,3,3,4};
    int x = dup2arr(arr, arr.length);
    System.out.println("Array without duplicates ");
    for(int i = 0 ; i < x ; i++){
        System.out.print(arr[i] + " ");
    }
    }
    public static int dup2arr(int [] arr,int n){
        int i = 0 ;
        for(int j = 1 ; j < n ; j++){
            if(arr[j] != arr[i]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return (i+1);
    }
}
