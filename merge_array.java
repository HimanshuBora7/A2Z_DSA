
import java.util.Arrays;

//problem statement: merger two sorted subarrays without extra space 
// detailed problem statement: given two sorted arrays arr1[] and arr2[] of size n and m in non decreasing order.Merge them in sorted order. MOdify arr1 so that it contains the first N element and modify arr2 so it contains the last M elements 
public class merge_array {
    public static void main(String[] args) {
        int arr1[] = { 1, 3, 5, 7 };
        int arr2[] = { 0, 2, 6, 8, 9 };

        System.out.println("Prior merging");
        System.out.print("arr1: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\nArr2: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        // brute_force(arr1, arr2);
        // optimal_approach(arr1, arr2);
        optimal_approach2(arr1, arr2);

        System.out.println("\nAfter merging");

        System.out.print("arr1: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\nArr2: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

    }

    public static void brute_force(int[] arr1, int[] arr2) {
        int len = arr1.length + arr2.length;
        int[] arr3 = new int[len];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                i++;
                k++;
            } else {
                arr3[k] = arr2[j];
                k++;
                j++;
            }
        }
        while (i < arr1.length) {
            arr3[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            arr3[k] = arr2[j];
            j++;
            k++;
        }

        for (int a = 0; a < arr1.length; a++) {
            arr1[a] = arr3[a];
        }
        for (int b = arr1.length; b < arr3.length; b++) {
            arr2[b - arr1.length] = arr3[b];
        }

    }

    // optimal approach ~ wihtout using extra space (we will take benefit of the
    // fact that individual arrays i.e arr1 and arr2 are sorted )
    // as we know that largest element of arr1 would be at its last index similarly
    // smallest element of arr2 wld be at first index
    // so we compare them and interchange them if arr1[last_element ] >
    // arr2[smallest_element] and updates the pointer
    // we repeat this step untill we reach an element where arr1[i] < arr2[j]
    // at this point we have collected smalled ones on left that is in array 1
    // and larger ones on right in arr2
    // now our task is to individually sort them again in this way we have sorted
    // them without using extra space
    public static void optimal_approach(int[] arr1, int[] arr2) {
        int i = arr1.length - 1;
        int j = 0;

        while (arr1[i] > arr2[j] && (i > 0 && j < arr2.length)) {
            int temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    // another approach to solve this problem optimally is using gap method which is
    // derived from shell sort

    // here we initiale gap with m (arr1 lenght) + n (arr2 lenght);
    // and put two pointer gap apart
    // next step is to check elements at ith n jth location and incrementing them
    // till j goes out off the array
    // in next step we reduce the gap by dividing it by 2 and taking its cieling
    // value

    public static void optimal_approach2(int[] arr1, int[] arr2) {

        int m = arr1.length;
        int n = arr2.length;

        int len = m + n;
        int gap = (len / 2) + (len % 2);

        // the expression (len / 2) + (len % 2) combines these two results. This
        // effectively rounds up the division of len by 2 to the next integer if len is
        // odd, or keeps it as is if len is even. In other words, it computes the
        // ceiling of len / 2.
        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {
                // we are in (left pointer) arr1 and (right pointer) arr2
                if (left < m && right >= m) {
                    swap_greater(arr1, arr2, left, right - m);
                }
                // means we(both left n right) are in arr2
                else if (left >= m) {
                    swap_greater(arr2, arr2, left - m, right - m);
                }
                // both in array 1 means left and right both are in arr1
                else {
                    swap_greater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1)
                break;
            else {
                gap = (gap / 2) + (gap % 2);
            }
        }
    }

    public static void swap_greater(int[] arr1, int[] arr2, int m, int n) {
        if (arr1[m] > arr2[n]) {
            int temp = arr1[m];
            arr1[m] = arr2[n];
            arr2[n] = temp;
        }
    }
}
