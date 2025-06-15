//moving zeros to the end problem using optimal approach 


public class zero_optimal {
    public static void main(String [] args){
        int [] arr = {1,2,0,3,0,5,0,0,6};

        System.out.println("Original Array ");
        
        for(int x : arr ){
            System.out.print(x + " ");
        }

       removeZero(arr, arr.length);

      System.out.println("New Array ");
        
        for(int x : arr ){
            System.out.print(x + " ");
        }

    }
    public static void removeZero(int [] arr, int n ){
    int nonzeroPos = 0 ;
    for(int i = 0 ; i <n ;i++){
       if( arr[i] != 0 ){
        arr[nonzeroPos] = arr[i];
        nonzeroPos++;
       }
    }
    for(int j= nonzeroPos ; j < n ;j++){
        arr[j ] = 0;
     }
      
    }
}
