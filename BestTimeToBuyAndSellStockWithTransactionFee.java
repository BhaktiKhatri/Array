package Array;

import java.util.Arrays;

/**
 * Leetcode 714. Best Time to Buy and Sell Stock with Transaction Fee
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
 * Return the maximum profit you can make.
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2, Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1
 * Selling at prices[3] = 8
 * Buying at prices[4] = 4
 * Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Explanation and Code from: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108871/2-solutions-2-states-DP-solutions-clear-explanation!
 * http://www.cnblogs.com/grandyang/p/7776979.html
 * http://hanslen.me/2017/10/15/Best-Time-to-Buy-and-Sell-Stock-series-with-Dynamic-Programming-in-Java/
 * Time Complexity: O(N), where N is the number of prices; Space Complexity: O(1), the space used by cash and hold.
 */

public class BestTimeToBuyAndSellStockWithTransactionFee {

	/*
		 At the end of the i-th day, we maintain cash, the maximum profit we could have if we did not have a share of stock, and hold, 
		 the maximum profit we could have if we owned a share of stock.
		 To transition from the i-th day to the i+1-th day, we either sell our stock cash = max(cash, hold + prices[i] - fee) or 
		 buy a stock hold = max(hold, cash - prices[i]). At the end, we want to return cash. We can transform cash first without using temporary 
		 variables because selling and buying on the same day can't be better than just continuing to hold the stock.
	 */
	public static int maxProfit(int[] prices, int fee) {
		System.out.println("prices: "+Arrays.toString(prices)+" fee: "+fee);
		
		int cash = 0;
		int hold = -prices[0];
        System.out.println("cash: "+cash+" hold: "+hold);
        
        for(int i = 1; i < prices.length; i++) {

        	System.out.println("i: "+i+" prices[i]: "+prices[i]+" hold: "+hold+" hold + prices[i] - fee: "+(hold + prices[i] - fee)+" cash: "+cash);
        	
        	cash = Math.max(cash, hold + prices[i] - fee);	//sell stock
        	System.out.println("cash: "+cash+" prices[i]: "+prices[i]+" cash - prices[i]: "+(cash - prices[i])+" hold: "+hold);
        	
            hold = Math.max(hold, cash - prices[i]);		//buy stock
            System.out.println("hold: "+hold);
        }
        return cash;
    }
	
	public static void main(String[] args) {
		int[] prices = {2, 3, 1, 8, 3, 9};
		int fee = 2;
		System.out.println(maxProfit(prices, fee));
	}
}
