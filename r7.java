//factorial of number using recursion 
// factorised 
//
import java.util.Scanner;
public class r7{
    public static void main(String [] args ){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of which u wanna find the factorial ");
        int n = sc.nextInt(); 
        int fact = factorial(n);
        System.out.println("Factorial of "+ n + " is "+ fact);
    }
    public static int factorial(int n ){
        if(n ==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}