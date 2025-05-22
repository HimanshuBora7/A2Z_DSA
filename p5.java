//armstrong number 
//armstrong number are those number whose individual digits 
//when raised to the number of digits in the number and added
//it results in the same number  
public class p5 {
    public static void main (String [] args ){
        int n = 1634;
        int og_number=n;
        int og_number2 = n;
        int count = 0;
        while(n>0){
            n = n/10;
            count++;
        }
      
        int arm_no = 0;
       while(og_number2 > 0 ){
        int last_Digit = og_number2%10;
        
        arm_no += Math.pow (last_Digit,count);
        
        og_number2 = og_number2/10;
       }
       System.out.println("armstrong number :" + arm_no);
       if(arm_no == og_number){
        System.out.println("Entered number is a armstrong number ");
       }
       else{
        System.out.println("Entered number is not a armstrong number ");
       }
    }
}
