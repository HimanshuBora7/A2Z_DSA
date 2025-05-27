//checking a string for pallindrome using recursion  
public class p9 {
    public static void main (String [] args ){
    String s1 = "A man, a plan, a canal: Panama";
    //cleaning the string :convert to lowercase and remove non alphanumeric 
    String cleaned = s1.toLowerCase().replaceAll("[^a-z0-9]", "");

    boolean result = check_func(0, cleaned);
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
