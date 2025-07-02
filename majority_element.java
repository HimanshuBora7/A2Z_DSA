//Find the majority element from the array which apprears more than N/2 times
//

public class majority_element {
    public static void main (String [] args ){
        int [] arr = {3,2,3,3,1,2,2,3,3,3};
        int z = brute_force(arr);
        System.out.println("Maximum number which occurs more than " + arr.length/2 + " times is " + z );
    }
    public static int brute_force(int [] arr){
        int num = -1;
        int counter = 0 ;
        for(int i = 0 ; i< arr.length ; i++){
            
            for(int j = 0 ; j < arr.length ; j++){
             if(arr[i] == arr[j]){
                counter++;
             }
            }
            // System.out.println("counter count " + i + " : : " + counter);
            // System.out.println("target " + arr.length/2);
             if(counter > arr.length/2){
                num = arr[i];
                break;
             }
             else{
                counter = 0;
             }
            
        }
     return num;

    }
}
