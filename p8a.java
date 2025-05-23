//solving the gcd problem with euclidian algorithm 
//which states that gcd(a,b) = gcd(a-b,b) given a > b
//we can optimise this approach by using modulo operater
// big number % small number till one of the number becomes zero
//the moment one of the number becomes zero other one is our gcd 

public class p8a {
    public static void main (String [] args ){
        int a = 20;
        int b = 40;

        while(a != 0 && b != 0){
            if(a > b){
                a = a%b;
            }
            else {
                b = b%a;
            }
        }
        if(a == 0){
            System.out.println(b );
        }
        else{
            System.out.print(a);
        }
    }
}
