package Array;

import java.util.Arrays;

/*
 * 123. Best Time to Buy and Sell Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * Example 1: Input: [3,3,5,0,0,3,1,4]; Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3. Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2: Input: [1,2,3,4,5]; Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4. Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3: Input: [7,6,4,3,1]; Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * Explanation and Code from: @han35 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/39615/My-explanation-for-O(N)-solution!
 * 
 */

public class BestTimeToBuyAndSellStock3 {

    public static int maxProfit(int[] prices) {
    	int sell1 = 0;
    	int sell2 = 0;
    	int buy1 = Integer.MIN_VALUE;
    	int buy2 = Integer.MIN_VALUE;
		
    	System.out.println("prices: "+Arrays.toString(prices));
    	
        for(int i: prices) {
        	System.out.println("i: "+i+" buy1: "+buy1+" sell1: "+sell1+" buy2: "+buy2+" sell2: "+sell2);
        	
			buy1 = Math.max(buy1, -i);
			System.out.println("buy1: "+buy1);
			
			sell1 = Math.max(sell1, buy1 + i);
			System.out.println("sell1: "+sell1);
			
			buy2 = Math.max(buy2, sell1 - i);
			System.out.println("buy2: "+buy2);
			
			sell2 = Math.max(sell2, buy2 + i);
			System.out.println("sell2: "+sell2);
		}
        System.out.println("sell2: "+sell2);
        
		return sell2;
    }

	public static void main(String[] args) {
		int[] prices = {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(prices));
	}

}
