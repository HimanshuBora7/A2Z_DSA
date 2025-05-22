//reverse a given number 

public class p3 {
    public static void main (String [] args ){
        int n = -85;
        int rev_num=0;
        while(n>0){
            int last_Digit=n%10;
            n=n/10;
            rev_num = (rev_num*10)+last_Digit;
        }
        System.out.println("Reversed number is " + rev_num);
    }
}
