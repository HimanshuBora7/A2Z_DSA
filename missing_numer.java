//find the missing number from the array 
//as input we will be given n and an input array 
//input array will be of size n-1 and we will have to find the missing number 

// ----BRUTE--FORCE----
//In brute force approach we can simply use linear search 

public class missing_numer {
public static void main (String []args ){
int [] array1 = { 1,2,3,5,6};
System.out.println("Original array ");
for(int x : array1){
    System.out.print(x + " ");
}
int n1 = 6;
// int x = find_missing(array1, n1);
// int x = Sum_miss(array1, n1);

int x = XOR_Way(array1,n1);


if(x != 0 ){
System.out.println("\nMissing number from the array is " + x );
}
else{
    System.out.println("nothing is missing from the array ");
}   


}



public static int find_missing(int [ ] array , int n ){
   
    int z = -1;
    for( int i = 1; i < n ;i++){
    if(array[i-1] != i ){
        z = i;
        break;
    }
    }
    return z;
}

// for solving this problem we can have two optimal approaches one is sum way and another one is XOR way 

// -- SUM -- waY -- 

// so we know the formula for sum of first n natural number vch is n(n+1) / 2 so we sum the elements given in the array and subtract that sum from our total sum , deficiet will be our missing number 
public static int Sum_miss(int [] arr, int n ){
    int sum  = (n*(n+1))/2;
    int sum_frm_array = 0 ;
    for(int i = 0 ; i<n-1;i++){
        sum_frm_array = sum_frm_array + arr[i];
    }

    return sum - sum_frm_array;
}

// ----XOR--WAY----

//basic property of XOR is that a ^ a = 0 and 0 ^ a = a ;
//so we take the XOR of fist n natural number in XOR1 
//then we take the XOR of elements from the array in XOR2 
//then we XOR1 ^ XOR2 so every number pairs n results in 0 except the number vch can't find pair n its  xor with 0 will result in the number itself and that wld be out answer


public static int XOR_Way(int [] arr, int n){
    int n1 = n-1;
    int XOR1 = 0;
   
    int XOR2 = 0;
    for(int i = 0 ;i < n1 ; i++){
        XOR2 = XOR2 ^ arr[i];
        XOR1 = XOR1 ^ (i+1);
    }
    XOR1 = XOR1 &n1;
    return XOR1 ^ XOR2;
}

}
