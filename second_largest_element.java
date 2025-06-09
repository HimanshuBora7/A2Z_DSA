//find the second largest array without sorting the array 


public class second_largest_element {
    public static void main (String [] args ){
        int [] arr2 = {5,3,2,6,7};
        int largest1 = arr2[0];
        int largest2 = -1;
        for(int x : arr2){
            if(x > largest1){
                largest1 = x ;
            }
        }
        for(int x : arr2){
            if(x > largest2){
                if(x != largest1){
                    largest2 = x;
                }
            }
        }
        System.out.println("Seconf largest element of the array is " + largest2);

    }
}
                                                      