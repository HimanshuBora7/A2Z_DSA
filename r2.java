
import java.util.Scanner;

//print number from 1 to n using recursion 
//like if n = 4 then the output should be 1,2,3,4

public class r2 {
    public static void main (String [] args ){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n ");
        int n = sc.nextInt();
        print_num(1, n);
    }
    public static void print_num(int i , int n){
        if(i > n){
            return;
        }
        System.out.println(i);
        print_num(i+1, n);
    }
}
