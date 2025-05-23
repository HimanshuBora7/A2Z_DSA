
import java.util.Scanner;

//sum of n number using functional recursion 
//means wihtout using parameter 
public class r6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of n ");
        int n = sc.nextInt();
        int sum1 = sum(n);
        System.out.println("sum of " + n + " number is " + sum1);
    }

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }
}
