
import java.util.ArrayList;

//rotate the array left by d places

//-------BRUTE----FORCE----APPROACH-------


//we observe that after N (array length ) number  of rotation we get the orginal array back so we can reduce d resulting in only the effective passes
// d = d % arr.length

//for shifhting an d times step 1 includes storeing the first d number of elements in an temporary array 
//step 2 is shifting by observation we can state that shifting will start from dth index
//like dth index element will go to 0th place 
//d+1 will go to 1st place 

//and in step3 we will place the elements store in temporary array at last 



public class left_rotate_d {
    public static void main (String [] args ){
    int [] arr = {1,2,3,4,5,6,7};
    System.out.println("without shifting ");
    for(int x : arr){
        System.out.print(x + " ");
    }
    int d = 4;
    d= d%arr.length;  
    shift(arr, d);
    System.out.println("with shifting ");
    for(int x : arr){
        System.out.print(x + " ");
    }
    }
    public static void shift(int [] arr ,int d){
        //step 1;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0 ;i < d ; i++){
           temp.add(arr[i]);
        }
        for(int i = d ; i < arr.length ; i++ ){
            arr[i-d] = arr[i];
        }
        int k = 0;
        for(int i = arr.length - d ;i < arr.length ; i++){
            arr[i] = temp.get(k);
            k++;
        }
    }

}
