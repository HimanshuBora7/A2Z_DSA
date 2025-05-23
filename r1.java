
import java.util.Scanner;

//starting with recursion 
//print the name 5 times 
public class r1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter how many times you wanna print name ");
        int n = sc.nextInt();
        print_name(1, n);
    }

    public static void print_name(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println("NAme");
        print_name(i + 1, n);
    }
}
