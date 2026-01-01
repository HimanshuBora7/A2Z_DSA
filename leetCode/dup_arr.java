package leetCode;

/*Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. */
public class dup_arr {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 4, 5, 6, 6 };
        System.out.println(arr.length);
        int result = removeDuplicates(arr);

        System.out.println("unique elements " + result);
    }

    public static int removeDuplicates(int[] arr) {
        int[] hashArr = new int[arr[arr.length - 1] + 1                             ];

        for (int x : arr) {
            hashArr[x]++;
        }
        int count = 0;
        for (int x : hashArr) {
            if (x > 0) {
                count++;

            }
        }
        return count;
    }
}
