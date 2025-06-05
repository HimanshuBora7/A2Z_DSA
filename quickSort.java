public class quickSort {
    public static void main (String [] args){
        int [] arr = {7,3,6,1,8,5};
         System.out.println("Unsorted array ");
         for(int x:arr){
            System.out.print(x + " ");
         }
          quickS(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array ");
        for(int x : arr)
         System.out.print(x + " ");

    }
    public static void quickS(int [] arr ,int low , int high){
     if(low < high){
        int partion_index = pivot_func(arr,low,high);
        quickS(arr , low , partion_index-1);
        quickS(arr,partion_index+1,high);
     }
    }
    public static int pivot_func(int [] arr,int low ,int high){
    int pivot = arr[low];
    int left = low+1;
    int right = high;
    int temp;
    while(left <= right){
        while(arr[left] < pivot && left<=high){
          left++;

        }
        while(arr[right] > pivot && right >= low){
            right--;
        } 
        if( left < right){
         temp = arr[left];
         arr[left] = arr[right];
         arr[right] = temp;
        }
    
    }
    temp = arr[low];
    arr[low ] = arr[right];
    arr[right] = temp;
    return right;
    }
}
