package Array;

import java.util.Arrays;

/**
 * Leetcode 718. Maximum Length of Repeated Subarray
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 * Explanation and Code from: https://leetcode.com/problems/maximum-length-of-repeated-subarray/discuss/109039/
 * http://www.cnblogs.com/grandyang/p/7801533.html
 * Time Complexity: O(M*N), where M,N are the lengths of A, B; Space Complexity: O(M*N), the space used by dp.
 * Citadel
 * Medium
 */

public class MaximumLengthOfRepeatedSubArray {

	/*
	 * This question gives us two arrays A and B. Let's return the longest repeating subarray of the array. So if we replace the array with a string, the actual problem is to solve the Longest Common Substring problem, and seemingly LeetCode does not have this obvious requirement of the longest substring of the same problem, pay attention to the longest subsequence Longest Common Subsequence is distinguished, and the longest subsequence is discussed in follow up. Well, let's look at this question first. DP is the best choice for this problem of extreme value. We use a two-dimensional DP array, where dp[i][j] represents the first i number of array A. And the length of the longest subarray of the first j digits of array B. If dp[i][j] is not zero, the ith array in A and the jth digit in B must be equal, for both arrays. [1,2,2] and [3,1,2], our dp array is:
	 *  	3 1 2 
		  1 0 1 0
 		  2 0 0 2 
		  2 0 0 1
 		We observe that where the dp value is not zero, it is the place where A[i] == B[j], and the dp value at the top left is added, that is dp[i-1][j-1 ], so the current dp[i][j] is equal to dp[i-1][j-1] + 1, and once A[i] != B[j], the direct assignment is 0. Because the sub-arrays are continuous, once they do not match, they cannot be increased in length. Every time we calculate a dp value, we must use to update the result res, so we can get the longest length of the same subarray, see the code as follows:
	 */
	
	public static int findLength(int[] A, int[] B) {
		int max = 0;
        int[][] dp = new int[A.length+1][B.length+1];	//dp[i][j] is the length of longest common subarray ending with nums[i] and nums[j]

        System.out.println("A: "+Arrays.toString(A)+" B: "+Arrays.toString(B));
        
        for(int i=0; i<=A.length; i++) {
            for(int j=0; j<=B.length; j++) {
                
            	if(i>0 && j>0)
            		System.out.println("i: "+i+" A[i-1]: "+A[i-1]+" j: "+j+" B[j-1]: "+B[j-1]);
            	
            	if(i == 0 || j == 0) {
            		dp[i][j] = 0;
            	}
            	else if(A[i-1] == B[j-1]) {
                    System.out.println("dp[i-1][j-1]: "+dp[i-1][j-1]);
            		
            		dp[i][j] = dp[i-1][j-1] + 1;
            		System.out.println("dp[i][j]: "+dp[i][j]+" max: "+max);
            		
                    max = Math.max(max, dp[i][j]);
                    System.out.println("max: "+max);
                }
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		int[] A = {1,2,2}; //{1,2,3,2,1};
		int[] B = {3,1,2}; //{3,2,1,4,7};
		//System.out.println(Arrays.toString(A));
		//System.out.println(Arrays.toString(B));
		System.out.println(findLength(A, B));
	}
}
