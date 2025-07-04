// Under the category of stocks problem we have six problems 
// out of which one is buying and selling of stocks 
// we are given an array of n integers where index denotes the day and 
// the value stored in the index denotes the price of that index on that particular day 
// so we have to maximize our profits by selecting the days on which we have to buy and sell the stocks
// buying should be prior to selling 
// selling at ith index so we have to take minimal from 0 to i-1 th index
// so we have to keep track of minimal element to tha left of every element


public class stocks {
    public static void main(String [] args ){
        int [] arr = { 7,1,5,3,6,4};
        int mini = arr[0];
        int profit = 0;
        {
            for(int i = 1 ; i < arr.length ;i++){
                int cost = arr[i] - mini;
                // ith is the day we are selling the stock 
                // so from the price of stock at ith day is
               
                profit = Math.max(profit, cost);
                // we take maximum of cost and profit as we want our profit to maximize 
                mini = Math.min(arr[i], mini);

                // to store the minimal element to the left of every element 

            }
        }

        System.out.println("maximum profit : " + profit);
    }
}
