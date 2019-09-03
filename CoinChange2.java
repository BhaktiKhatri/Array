package Array;

import java.util.Arrays;

//https://www.youtube.com/watch?v=_fgjrs570YE
/*
 * 518. Coin Change 2
 * https://leetcode.com/problems/coin-change-2/description/
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. 
 * You may assume that you have infinite number of each kind of coin. Note: You can assume that 
 * 0 <= amount <= 5000; 1 <= coin <= 5000; the number of coins is less than 500; the answer is guaranteed to fit into signed 32-bit integer
 * Example 1: Input: amount = 5, coins = [1, 2, 5]; Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2: Input: amount = 3, coins = [2]; Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2
 * Example 3: Input: amount = 10, coins = [10]; Output: 1
 * Explanation and Code from: https://www.youtube.com/watch?v=_fgjrs570YE https://leetcode.com/problems/coin-change-2/discuss/99212/Knapsack-problem-Java-solution-with-thinking-process-O(nm)-Time-and-O(m)-Space
 * https://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * 
 */

public class CoinChange2 {

	public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        System.out.println("amount: "+amount+" coins: "+Arrays.toString(coins));
        
        for(int coin: coins) {
        	System.out.println("coin: "+coin);
        	
            for(int i=coin; i<=amount; i++) {
            	System.out.println("i: "+i+" dp[i]: "+dp[i]+" dp[i-coin]: "+dp[i - coin]);
            	
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
	}
	
	public static void main(String[] args) {
		int amount = 5;
		int[] coins = {1,2,5};
		
		System.out.println(change(amount, coins));
	}

}