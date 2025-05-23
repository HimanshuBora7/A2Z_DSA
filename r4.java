
import java.util.Scanner;

//print N to 1 using backtracking 
//without using (i-1,n) parameter
public class r4 {
    public static void main (String [] args ){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Value of N ");
        int n = sc.nextInt();
        print_num(n);
    }
    public static void print_num(int n ){
        if( n < 1 ){
            return;
        }
        System.out.println(n);
        print_num(n-1);
    }
}
