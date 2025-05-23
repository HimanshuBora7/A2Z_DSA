
import java.util.Scanner;

//sum n number using recursion 
public class r5 {
    public static void main (String [] args ){
        Scanner sc = new Scanner(System.in);
        System.out.println("ENter the value of N ");
        int n = sc.nextInt();
        sum(n,0);
    }
    public static void sum(int i,int sum ){
          if(i < 1 ){
            System.out.println(sum);
            return;
          }
          sum(i-1,i+sum);
    }
}
