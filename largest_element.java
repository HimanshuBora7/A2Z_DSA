
//find the largest element in an array
//the approach we should take is first brute force approach 
//then optimise it for the better or optimal one 

//brute force approach for this problem is to first sort the array and then print the last index of the sorted array 
//time complexity will be O (nlogn) for brute force approach 

//here is the optimal approach with time complexity O(n) 
public class largest_element {
 public static void main (String [] args ){
    int [] array1 = {6,3,9,2};
    int largest = array1[0];
    for(int x : array1){
        if(x > largest){
            largest = x ;
        }
    }
    System.out.println("Largest element in the array is " + largest);

 }   
}
