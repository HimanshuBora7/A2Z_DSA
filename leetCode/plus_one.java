package leetCode;
/*You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4] */

/*approach

Think of this like manual addition you did in primary school. When you add 1 to a number, you only care about the last digit first.

    If the last digit is 0−8, you just add 1 and you're done! (e.g., 123 becomes 124).

    If the last digit is 9, it becomes 0 and you "carry the one" to the next neighbor on the left.

3. Approaching the Solution (The Step-by-Step)

Instead of converting the array to a number, modify the array directly from right to left.

    Start a loop from the end of the array (digits.length - 1) moving toward the start.

    Check the digit: * If the digit is less than 9, just increment it by 1 and return the array immediately. You don't need to check any other digits!

        If the digit is 9, set it to 0. The loop will naturally move to the next digit on the left (the "carry" effect).

    The "All Nines" Edge Case: If the loop finishes and you haven't returned yet, it means every single digit was a 9 (like 999).

        In this case, you need a new array of size n + 1.

        Set the first element (index 0) to 1.

    Pro Tip: In Java, when you create new int[length], all values are automatically initialized to 0. So for the 999 → 1000 case, you only need to set the very first index to 1! */

public class plus_one {
    public static void main(String[] args) {
        int[] arr = { 9, 9, 9 };

        int[] res = plusOne(arr);

        for (int x : res) {
            System.out.println(x);
        }
    }

    public static int[] plusOne(int[] digits) {
        int last_ind = digits.length - 1;

        for (int i = last_ind; i >= 0; i--) {
            if ((digits[i] >= 0 && digits[i] <= 8)) {
                digits[i] += 1;
                return digits;
            } else if (digits[i] == 9) {
                digits[i] = 0;
            }

        }
        int[] arr = new int[last_ind + 2];
        arr[0] = 1;
        return arr;
    }

}
