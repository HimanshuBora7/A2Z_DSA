//program for fibonnaci sequence  
//a fibbonacci number is basically the sum of previous two number 
//F(n)=F(n−1)+F(n−2)
//with initial conditions F(0)=0 and F(1)=1.

public class f1{
    public static void main (String [] args ){
        int n = 5 ;
        int x = fiboo(n);
        System.out.println("fibo of "+ n + " is " + x );
    }
    public static int fiboo(int n ){
        if( n == 1){
            return 1;
        }
        if( n == 0){
         return 0;
        }
        return fiboo(n-1) + fiboo(n-2);
    }
}