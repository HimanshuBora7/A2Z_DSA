//GCD or HCF 
//greatest common divisor 
public class p8 {
    public static void main(String[] args) {
        int n1 = 11;
        int n2 = 22;
        int gcd = 1;

        for (int i = 1; i <= Math.min(n1, n2); i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        System.out.println("GCD or HCF for " + n1 + " and " + n2 + " is " + gcd);
    }
}
