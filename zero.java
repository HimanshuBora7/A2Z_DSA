
import java.util.ArrayList;

//moving zeros to the end
//for eg we are given an array arr[] ={1,2,0,0,3,2}
//so zeros from this array shld be moved to the end
//resultant array should like this arr[] = {1,2,3,2,0,0}

//---------BRUTE--FORCE---APPROACH----------

public class zero {
    public static void main (String [] args ){
    int [] arr = { 1,2,0,0,3,2};     
    ArrayList <Integer> temp = new ArrayList<>();

    System.out.println("original array ");
        for(int x : arr){
            System.out.print(x + " ");
        }

    
    for(int x : arr){
        if(x!= 0){
        temp.add(x);
        }
    }
    for(int i = 0 ; i < temp.size() ; i++){
        arr[i] = temp.get(i);
    }    
    for(int i = temp.size() ; i < arr.length ; i++){
        arr[i] = 0;
    }
    System.out.println("\nnew array ");
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}

