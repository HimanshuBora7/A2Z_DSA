//hashing means way a to solve a problem by prestoring and fetching 
//counting frequency of elements in an array using hashing approach 
//it is similar to count sort where we store the frequency in frequency array 

public class h1 {
public static void main (String [] args ){
int [] arr = { 1,3,2,1,3};
int [] hash  = new int[12];
int [] newf = freq_arr(hash, arr);
for(int i =0;i<newf.length;i++){
    if(newf[i] > 0 ){
        System.out.println( i + " : : " +newf[i]);
    }
}
}
public static int [] freq_arr(int [] hash , int [] arr){
 
for(int i = 0 ; i< arr.length ; i++){
 int x = arr[i];
 hash[x]++;
}
return hash;
}

}
