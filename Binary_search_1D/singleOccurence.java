package Binary_search_1D;

//   Given an array of N integers. Every number in the array except one appears twice. Find the single number in the array.
public class singleOccurence {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6 };
        int result = brute_force(arr);
        System.out.println("the number which has occured only once: " + result);
    }

    public static int brute_force(int[] arr) {

        // brute force approach is simple if we are at index i then the similar element
        // should be either at (i-1)th index or either at (i+1)th index exception to
        // this are the elements at the first position and at the last positon

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] != arr[i + 1]) {
                    return arr[i];
                }
            } else if (i == arr.length - 1) {
                if (arr[i] != arr[i - 1]) {
                    return arr[i];
                }
            } else {
                if (arr[i] != arr[i + 1] && arr[i] != arr[i - 1]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }
}
