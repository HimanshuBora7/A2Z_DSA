//checking a string for pallindrome using recursion  
public class p9 {
    public static void main (String [] args ){
    String s1 = "kayaky";
    boolean result = check_func(0, s1);
    System.out.println(s1 + " is " + (result ? "a pallindrome " : "not a pallindrome "));

    }
    public static boolean check_func(int i , String s){
     if(i >= s.length()/2){
        return true;
     }        
     if(s.charAt(i) != s.charAt(s.length()-i-1)){
        return false;
     }
     return check_func(i+1, s);
    }
}
