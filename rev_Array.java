public class rev_Array {
    public static void main (String [ ] args){
        int [] arr = {1,2,3,4};
        System.out.println("original array ");
        for(int x : arr){
            System.out.print(x + " ");
        }
        for(int i= 0 ; i < arr.length/2 ; i++){
           int temp = arr[arr.length-i-1];
           arr[arr.length-i-1] = arr[i];
           arr[i] = temp;
        }
        System.out.println("\nreversed array ");
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}
