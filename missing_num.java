
// we are given a read only array of N integers with values also in the range [1,N] both inclusive. Each integer apprears exactly ones except A which appears twice and B which is missing so we have to find the repeating and missing numbers A and B
// example input arr [] = {3,1,2,5,3};
// result : {3,4};

public class missing_num {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 5, 3 };

        int[] result1 = brute(arr, 5);

        for (int x : result1) {
            System.out.print(x + " ");
        }

    }

    public static int[] brute(int[] arr, int n) {

        int[] result = new int[2];
        int[] hash = new int[n + 1];

        for (int y : arr) {
            hash[y]++;
        }
        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 2) {
                result[0] = i;
            }
            if (hash[i] == 0) {
                result[1] = i;
            }
        }
        return result;
    }
}
