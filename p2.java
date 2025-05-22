//count the number of digits in a given number n
public class p2 {
    public static void main (String [] args ){
        int n =77899;
        int count = 0;
        while(n>0){
            n = n/10;
            count++;
        }
        System.out.print("NO of digits in the entered number is " + count);
    }
}
