//printing all the divisiors of a entered number 

public class p6 {
public static void main (String [] args ){
    int n = 36;
    int i =1 ;
    while(i<=n){
        if(n%i == 0){
            System.out.print( i + " ");
        }
        i++;
    }
}    
}
