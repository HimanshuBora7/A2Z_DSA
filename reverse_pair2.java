import java.util.*;

public class reverse_pair2 {
    public static void main(String[] args) {
        int arr[] = { 4, 1, 2, 3, 1 };
        int n = 5;
        int count = sol(arr, n);
        System.out.println("output " + count);
    }

    public static int sol(int[] arr, int n) {
        return merger_sort(arr, 0, n - 1);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        List<Integer> temp = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static int count_pair(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right])
                right++;
            count += (right - (mid + 1));
        }
        return count;
    }

    public static int merger_sort(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high)
            return count;

        int mid = (high + low) / 2;
        count += merger_sort(arr, low, mid);
        count += merger_sort(arr, mid + 1, high);
        count += count_pair(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }
}
