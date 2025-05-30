//perform selection sort 
//in selection sort we take minimum element from the unsorted sub array and place it on the 0th location and this process goes on
public class selection {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 1, 7,  };
        for(int x : arr){
            System.out.print(x + " ");
        }
        arr = selection_sort(arr);
        System.out.println("\n.S.O.R.T.E.D.\n");
         for(int x : arr){
            System.out.print(  x + " ");
        }
    }

    public static int[] selection_sort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }

            }
            if (min != i) {
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;

            }
        }
      return arr;
    }
}
