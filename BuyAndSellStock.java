package Array;

import java.util.Arrays;

/**
 * Leetcode 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/
 * https://www.youtube.com/watch?v=76-CYD0jn7s
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * @author NisuBhakti
 * Time Complexity: O(n): only one pass is needed; Space Complexity: O(1): Only 2 variables are used
 */

public class BuyAndSellStock {

	public static int maxProfit(int prices[]) {
		System.out.println(Arrays.toString(prices));
        
		int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        
        for(int i=0; i<prices.length; i++) {
        	System.out.println("prices[i]: "+prices[i]+" minprice: "+minprice+" maxprofit: "+maxprofit);
        	
        	if(prices[i] < minprice) {
                minprice = prices[i];
        	}
            else if(prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        	System.out.println("prices[i]: "+prices[i]+" minprice: "+minprice+" maxprofit: "+maxprofit);
        }
        return maxprofit;
    }
	
	static int isPowerOfTwo(int n) {
		int num = n;
        //return (int) (Math.ceil((Math.log(n) / Math.log(2)))) == (int) (Math.floor(((Math.log(n) / Math.log(2)))));
		//return ((x&(x-1))-1);
		if((n & n-1) == 0){ //this checks if n is a power of 2
	         n--; //Since n is a power of 2 we have to subtract 1
	      }
	      while((n & n-1) != 0){ //the while will keep on going until n is a power of 2, in which case n will only have 1 bit on which is the maximum power of 2 less than n. You could eliminate the != 0 but just for clarity I left it in
	         n = n & n-1; //we will then perform the bitwise operation AND with n and n-1 to eliminate the least significant bit of n 
	      }
	      return num-n;
    }
	
	public static void main(String[] args) {
		int[] arr = {100, 80, 120, 130, 70, 60, 100, 125};
		int profit = maxProfit(arr);
		System.out.println(profit);
		//System.out.println(isPowerOfTwo(3));
	}

}
