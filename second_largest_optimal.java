//optimal solution for finding the second largest element in an array 

public class second_largest_optimal {
    public static void main (String [] args ){
    int [] array = { 3,5,6,1,8};

    int second_largest = Second_Largest(array);
    System.out.print("Second larges element in the array is " + second_largest);
    
    
    int second_smallest = Second_Smallest(array);
    
     System.out.print("Second smallest element in the array is " + second_smallest);

    }


    public static int Second_Largest(int [] arr ){
    int largest = arr[0];
    int second_largest = -1;
    for(int x : arr){
        if(x > largest){
            second_largest = largest;
            largest = x ;
        }
        else if (x < largest && x > second_largest){
            second_largest = x ;
        }
    }
    return second_largest;
    }
    public static int Second_Smallest(int [] arr){
        int smallest = arr[0];
        int second_smallest = 100;
        for(int x : arr){
            if(x < smallest){
                second_smallest = smallest;
                smallest = x;
            }
            else if( x > smallest && x < second_smallest){
                second_smallest = x ;
            }
        }
        return second_smallest;
    }

}
