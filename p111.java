import java.util.*;

public class p111 {
    public static void main(String[] args) {
        System.out.println("Calculator activated");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first  number");
        int a = sc.nextInt();
        System.out.println("enter the second number");
        int b = sc.nextInt();

        if (a < 0 || b < 0) {

            System.out.println("Negative numbers not allowed");

        } else {
            System.out.println("ENter following numbers to perform the operation ");
            System.out.println("1.ADD 2.Subtract 3.Divide 4.Multiply");
            int c = sc.nextInt();
            if (c == 1) {
                System.out.println("added +" + (a + b));
            } else if (c == 2) {
                int d = a - b;
                System.out.println("subtracted" + d);
            } else if (c == 3) {
                System.out.println("Divide" + (a / b));
            } else if (c == 3) {
                System.out.println("Mulitply" + (a * b));
            } else {
                System.out.println("ERROR");
            }
        }
    }
}