//check if the array is sorted or not 

public class sorted_array{
    public static void main (String [ ] args){
        int [] arr = {1,2,4,3,5};
        boolean check = check_Array(arr);
        if(check){
            System.out.println("sorted");
        }
        else{
            System.out.print("Not sorted");
        }
    }
    public static boolean check_Array(int [] array){
        int flag = 0;
        for(int i = 0 ; i < array.length-1 ; i++){
            if(array[i] > array[i+1]){
             flag++;
            }
        }
        if(flag!= 0){
            return false;
        }
        else{
            return true;
        }
    }
}