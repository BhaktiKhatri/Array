package Array;

import java.util.Arrays;

/**
 * Leetcode 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * https://www.youtube.com/watch?v=Taq95cvRom8
 * @author NisuBhakti
 * Time Complexity: O(n)
 */
public class BuyAndSellStock2 {

	public static int maxProfit(int[] prices) {
		int total = 0;
		System.out.println(Arrays.toString(prices));
		
		for(int i=0; i<prices.length-1; i++) {
			System.out.println("i: "+i+" prices[i]: "+prices[i]);
			
			int profit = prices[i+1] - prices[i];
			System.out.println("profit: "+profit+" total: "+total);
			
			if(profit > 0) {
				total = total + profit;
			}
			System.out.println("total: "+total);
		}
		System.out.println("total: "+total);
		return total;
	}
	
	//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/39402/Is-this-question-a-joke
	//Approach 3: Simple One Pass https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
	public static int maxProfit1(int[] prices) {
	    int total = 0;
	    System.out.println(Arrays.toString(prices));
	    
	    for(int i=0; i<prices.length-1; i++) {
	    	System.out.println("i: "+i+" prices[i]: "+prices[i]+" prices[i+1]: "+prices[i+1]+" total: "+total);
	        
	    	if(prices[i+1] > prices[i]) { 
	        	total = total + prices[i+1]-prices[i];
	        }
	    }
	    System.out.println("total: "+total);
	    return total;
	}
	
	public static void main(String[] args) {
		int[] arr = {100, 80, 120, 130, 70, 60, 100, 125};
		//int[] arr = {1,2,3,4,5};//{7,1,5,3,4,6};
		
		int profit = maxProfit1(arr);
		System.out.println(profit);
	}
}