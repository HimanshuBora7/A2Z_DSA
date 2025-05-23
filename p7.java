//check for prime number with oprimised approach 
//instead of checking every number till n , we will check till
//sqaure root of n and second factor will be found out by diving the i by n 
// and the place where division of n and i equals i we stop it means we have
//covererd all the factors 

public class p7 {
    public static void main(String[] args) {
        int n = 53;
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;

                if ((n / i) != i) {
                    count++;
                }
            }
            
        }
        if (count == 2) {
                System.out.println("Entered number is a prime number ");
            } else {
                System.out.println("Entered number is not a prime number ");
            }
    }
}