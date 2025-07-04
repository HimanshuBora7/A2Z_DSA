// Rearrange the array element by sign 
// we would be given an array of size n which would be consisting 
// n/2 positive numbers and n/2 negative numbers 
// so we have to arrange positive and negative numbers in alternate order
// while  preserving their relative order 
// eg we are given an array arr[] = { 3,1,-2,-5,2,-4}
// so the output for this should be arr[] = { 3,-2,1,-5,2,-4}

public class rearrange_array {
  public static void main (String [] args ){
    int [] arr = { 3,1,-2,-5,2,-4};
    
    System.out.println("Original array : ");
    for(int x : arr){
        System.out.print(x + " ");
    }

    // int [] arr2 = brute_force(arr);

    int [] arr2 = optimal_approach(arr);

    System.out.println("rearranged array : ");
    for(int x : arr2){
        System.out.print(x + " ");
    }
  } 
  public static int [] brute_force(int [] arr){
    int n = arr.length;
    System.out.print("\n\t\t n " + n + "\n");
    int [] pos_arr = new int[n/2];
    int [] neg_arr = new int[n/2];
    
    int i = 0;
    int j = 0;

    for(int x : arr){
        if(x >= 0 ){
            pos_arr[i] = x;
            i++; 
        }
        else{
         neg_arr[j] = x;
         j++;
        }
    }
    int a = 0 ;
    int b = 0;
    for(int k = 0 ; k < arr.length ; k++){
           if( k % 2 == 0){
              arr[k] = pos_arr[a];
              a++;
           }
           else{
            arr[k] = neg_arr[b];
            b++;
           }
    }
    return arr;
  }
   
 // optimal approach to solve this problem 
 // as we know positive elements will go to even positions 
 // so we iterate the original array and in new array we go on placing 
 // the positive ones at even position and -ve ones at odd position 

 public static int [] optimal_approach(int [] arr ){
    int [] newarr = new int[arr.length];
    
    int i = 0 ;
    int j = 1;
    for(int x : arr ){
        if(x > 0 ){
        newarr[i] = x;
        i +=2;
        }
        else{
            newarr[j] = x;
            j +=2;
        }
    }
    return newarr;
 }
}
