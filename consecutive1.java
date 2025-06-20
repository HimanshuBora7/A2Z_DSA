
// arr[1,1,0,1,1,1,0,1,1]
// output: 3 
public class consecutive1 {
    public static void main (String [] args ){
        int [] arr = {1,1,0,1,1,1};
         System.out.println("Array ");
         for(int x : arr){
            System.out.print(x + " " );
         }
         int num = Find_ones(arr);
         System.out.println("\nNumber of maximum consecutive 1's present in the array are " + num);
    }
    public static int Find_ones (int [] arr){
       int countOg = 0;
       int countMov = 0;
       int n =  arr.length;

       for(int i = 0 ;i < n ; i++){
        if(arr[i] == 1 ){
            countMov++;
            if(countOg < countMov){
                countOg = countMov;
            }
        }
        else{
         countMov = 0;
        }
       }
       return countOg; 
    }
}
