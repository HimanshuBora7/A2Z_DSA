// Rearrange the array element by sign 
// we would be given an array of size n which would be consisting 
// n/2 positive numbers and n/2 negative numbers 
// so we have to arrange positive and negative numbers in alternate order
// while  preserving their relative order 
// eg we are given an array arr[] = { 3,1,-2,-5,2,-4}
// so the output for this should be arr[] = { 3,-2,1,-5,2,-4}

public class rearrange_array {
    public static void main(String[] args) {
        // int[] arr = { 3, 1, -2, -5, 2, -4 };
        int arrVaraition[] = {-1,2,3,4,-3,1};

        System.out.println("Original array : ");
        for (int x : arrVaraition) {
            System.out.print(x + " ");
        }

        // int [] arr2 = brute_force(arr);

        // int[] arr2 = optimal_approach(arr);
        int[] arr2 = variation(arrVaraition);

        System.out.println("rearranged array : ");
        for (int x : arr2) {
            System.out.print(x + " ");
        }
    }

    public static int[] brute_force(int[] arr) {
        int n = arr.length;
        System.out.print("\n\t\t n " + n + "\n");
        int[] pos_arr = new int[n / 2];
        int[] neg_arr = new int[n / 2];

        int i = 0;
        int j = 0;

        for (int x : arr) {
            if (x >= 0) {
                pos_arr[i] = x;
                i++;
            } else {
                neg_arr[j] = x;
                j++;
            }
        }
        int a = 0;
        int b = 0;
        for (int k = 0; k < arr.length; k++) {
            if (k % 2 == 0) {
                arr[k] = pos_arr[a];
                a++;
            } else {
                arr[k] = neg_arr[b];
                b++;
            }
        }
        return arr;
    }

    // optimal approach to solve this problem
    // as we know positive elements will go to even positions
    // so we iterate the original array and in new array we go on placing
    // the positive ones at even position and -ve ones at odd position

    public static int[] optimal_approach(int[] arr) {
        int[] newarr = new int[arr.length];

        int i = 0;
        int j = 1;
        for (int x : arr) {
            if (x > 0) {
                newarr[i] = x;
                i += 2;
            } else {
                newarr[j] = x;
                j += 2;
            }
        }
        return newarr;
    }

    // variation in question what if positive exceeds the number of -ve numbers or
    // vice versa
    // arr[] = {1,2,-4,-5,3,6}

    // solution for this should be arr[] = {1,-4,2,-5,3,6};

    public static int[] variation(int[] arr) {
        int pos = 0;
        int neg = 0;
        for (int x : arr) {
            if (x >= 0) {
                pos++;
            } else {
                neg++;
            }
        }
        // System.out.println("pos count " + pos);
        // System.out.println("neg count " + neg);

        int[] pos_Arr = new int[pos ];
        int[] neg_Arr = new int[neg ];

        int i = 0;
        int j = 0;

        for (int x : arr) {
            if (x >= 0) {
                pos_Arr[i] = x;
                i++;
            } else {
                neg_Arr[j] = x;
                j++;
            }
        }
    //     System.out.println("pos array :");
    //     for(int x : pos_Arr){
    //         System.out.println(x + " ");
    //     }
    //    System.out.println("\n negative array " );
    //    for(int x : neg_Arr){
    //     System.out.print(" " + x );
    //    }


        int a = 0;
        int b = 0;
        int flag = 0;
        int d = 0;

            while (a < pos_Arr.length && b < neg_Arr.length) {
                if (flag == 0) {
                    arr[d] = pos_Arr[a];
                    d++;
                    a++;
                    flag = 1;
                } else {
                    arr[d] = neg_Arr[b];
                    d++;
                    b++;
                    flag = 0;
                }
            }
            
            while( a < pos_Arr.length){
                arr[d] = pos_Arr[a];
                a++;
                d++;
            }
            while(b < neg_Arr.length){
             arr[d] = neg_Arr[b];
             d++;
             b++;
            }
        return arr;
    }

}
