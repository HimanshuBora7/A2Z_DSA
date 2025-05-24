//reversing an array using while loop 

public class a1{
    public static void main (String [] args ){
        int [] arr1 = {1,2,3,4,2};
        System.out.println("original array ");
        for(int i =0;i<arr1.length;i++){
            System.out.print(arr1[i] + " ");
        }
        int i = 0;
        int j = arr1.length-1;

        while(i < j){
            int x = arr1[i];
            arr1[i] = arr1[j];
            arr1[j] = x;
            i++;
            j--;
        }
        System.out.println("\nswapped array ");
        for(int a =0;a<arr1.length;a++){
            System.out.print(arr1[a] + " ");
        }
    }
}