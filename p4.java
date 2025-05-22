//checking for pallindrome if the entered number is pallindrome print true other wise print FAlse


public class p4 {
    public static void main (String [] args ){
        int n =44;
        int og_number=n;
        int rev_num = 0 ;
        while(n>0){
            int last_Digit = n%10;
            n = n/10;
            rev_num = (rev_num *10)+last_Digit;
        }
       if(og_number == rev_num){
        System.out.println("True is number is pallindrome ");
       }
       else{
        System.out.println("False this number is not a pallindrome ");
       }
        
    }
}
