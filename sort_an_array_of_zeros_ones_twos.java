
import java.util.ArrayList;


// sort an array consisting of only zeros , ones and twos 


public class sort_an_array_of_zeros_ones_twos {
public static void main (String  [] args ){
    
    int [] arr = { 0 ,1,2,0,1,2,1,2,0,0,0,1};
    
    System.out.println("Unsorted array ");

    for(int x : arr ){
        System.out.print( x + " ");
    }

    // sort_arr_optimal(arr);
    // merger_sort(0, arr.length-1, arr);
   dutch_national_flag_algo(arr);
    System.out.println("\nsorted array ");

    for(int x :arr){
        System.out.print(x + " ");
    }
}   
// better approach is to count the number of zeros , ones and twos in 3 seprate variables 
// and feeding value afterwards manually 
public static void sort_arr_optimal(int [] arr ){
    int zero_count = 0;
    int one_count = 0 ;
    int two_count = 0;
    for(int i = 0 ; i< arr.length ; i++){
        
        if(arr[i] == 0){
            zero_count++;
        }
        else if(arr[i] == 1){
            one_count++;
        }
        else{
            two_count++;
        }
    }
    System.out.println("zero count " + zero_count);
    System.out.println("one count " + one_count);
    System.out.println("two count " + two_count);
    int index = 0;
    for(int i = 0 ; i < zero_count ; i++){
        arr[index++] = 0;
    }
    for(int i=0 ; i < one_count ; i++ ){
        arr[index++] = 1;
    }
    for(int i=0 ; i < two_count;i++){
       arr[index++] = 2;
    }
} 


// brute force solution for this problem would be using any of the sorting technique with time complexity nlogn

//using merger_sort 

public static void merger_sort(int low , int high , int [] arr ){
    if(low >= high){
        return;
    }
    int mid = (low+high)/2;
    merger_sort(low, mid, arr);
    merger_sort(mid+1,high, arr);

    merge( low , mid , high , arr);
}
public static void merge(int low , int mid , int high , int [] arr){
    
    ArrayList<Integer> temp = new ArrayList<>();
    int left = low;
    int right = mid+1;

    while(left <= mid && right<= high){
        if(arr[left] <= arr[right]){
            temp.add(arr[left]);
            left++;
        }
        else{
            temp.add(arr[right]);
            right++;
        }
    }
    while(left <= mid){
        temp.add(arr[left]);
        left++;
    }
    while(right <= high){
        temp.add(arr[right]);
        right++;
    }

    for(int i = 0 ; i< temp.size() ; i++){
        arr[i+low] = temp.get(i);
    }
}

// Dutch national flag algorithm gives the optimal solution for this problem 
// refer to note book for theory
// crux is it revolves around 3 variables low mid and high 
// 0 to low - 1 -> 0
// low to mid -1 -> 1
// mid to high -> UNsorted
//high to n-1 -> 2

// value of arr[mid] will decide which pointer to move 
// if arr[mid] == 0 ; swap arr[low] and arr[mid] , low++, mid++
// if arr[mid] == 1; mid++;
// if arr[mid] == 2 , swap arr[mid] , high , high--;

public static void dutch_national_flag_algo(int [] arr){
    int low = 0;
    int high = arr.length-1;

    int mid = 0;

    while(mid <= high){
    if(arr[mid] == 0){
        // swap arr[low] with arr[mid]
        //then low+1 n mid+1
        int temp = arr[mid];
        arr[mid] = arr[low];
        arr[low] = temp;

        mid++;
        low++;
    }
    else if( arr[mid] == 1 ){
        mid++;
    }
    else{
        // swap arr[mid] , arr[high]
        int temp = arr[high];
        arr[high] = arr[mid];
        arr[mid] = temp;
        high--;
    }
    }
}








}



