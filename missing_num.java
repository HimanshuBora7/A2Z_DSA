
// we are given a read only array of N integers with values also in the range [1,N] both inclusive. Each integer apprears exactly ones except A which appears twice and B which is missing so we have to find the repeating and missing numbers A and B
// example input arr [] = {3,1,2,5,3};
// result : {3,4};

public class missing_num {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 5, 3 };

        // int[] result1 = brute(arr, 5);

        int[] result1 = maths_approach(arr, 5);
        System.out.println("number");

        for (int i = 0; i < result1.length; i++) {
            if (i == 0) {
                System.out.println("twice occuring number : " + result1[0]);
            } else {
                System.out.println("missing number: " + result1[1]);
            }
        }
        System.out.println();

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

    // optimal approach is using basic matermatics
    // as we know we have number of elements till N
    // so in step 1 we sum the numbers in array and store it in Sn
    // and we calculate sum of first n natural number using formula n(n+1)/2
    // so by this we get our first eqn where x - y = diffn
    // where we assume that x is our repeating number and y is our missing number
    // by this way we get our first equation
    // and to find the value of two variable we need two equation
    // so in step 2 we take sum of square of the given numbers in array
    // and subtract sum of first n square natural number
    // sum is n(n+1)(2n+1)/6 ;

    public static int[] maths_approach(int[] arr, int n) {
        // sum of N natural number

        int Sn = (n * (n + 1) / 2);
        System.out.println("Sum n " + Sn);
        int sumN = 0;

        for (int i = 0; i < arr.length; i++) {
            sumN += arr[i];
        }
        System.out.println("Sum of given array: " + sumN);

        int diff1 = sumN - Sn;

        System.out.println("diff1: " + diff1);

        // sum of square of first N nstural number
        int S2n = ((n) * (n + 1) * ((2 * n) + 1)) / 6;
        System.out.println("sum of n square:" + S2n);
        int Sum2N = 0;

        for (int i = 0; i < n; i++) {
            Sum2N += arr[i] * arr[i];
        }
        System.out.println("sum of sqaure of given num: " + Sum2N);
        int diff2 = Sum2N - S2n;
        System.out.println("diff2: " + diff2);
        // diff1 = x -y
        // diff2 = (x^2 - y^2)=(x-y)(x+y)
        // diff2 / x-y = x + y
        // diff2/diff1 = x + y = diff3
        // (x - y) + (x + y) = diff3+diff2
        // 2x = diff3 + diff2;
        // x = (diff3+diff2)/2;
        // x is our repeating number
        // x - diff1 = y (missing number )

        int diff3 = diff2 / diff1;
        int a = (diff3 + diff1) / 2;
        int b = a - diff1;
        int[] result = new int[2];

        result[0] = a;
        result[1] = b;
        return result;
    }
}
