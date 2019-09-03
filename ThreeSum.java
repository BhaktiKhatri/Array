package Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode 15. 3Sum
 * https://leetcode.com/problems/3sum/description/
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * Note: The solution set must not contain duplicate triplets.
 * Example: Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * Explanation and Code from: @shpolsky https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution
 * https://leetcode.com/problems/3sum/discuss/7399/Easiest-Java-Solution
 * Time Complexity: O(N^2)
 * Medium
 * Microsoft, Facebook, Amazon, Bloomberg, Adobe, Works Applications
 */

public class ThreeSum {
	
	/**
	 * The idea is to sort an input array and then run through all indices of a possible first element of a triplet. For each possible first element we
	 * make a standard bi-directional 2Sum sweep of the remaining part of the array. Also we want to skip equal elements to avoid duplicates in the answer
	 * without making a set or smth like that.
	 * @param num given array
	 * @return list of triplets whose sum is zero
	 */
	public static List<List<Integer>> threeSum(int[] num) {
		System.out.println("num: "+Arrays.toString(num));
		Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    System.out.println("num: "+Arrays.toString(num));
	    
	    for(int i=0; i<num.length-1; i++) {
	    	
	    	System.out.println("i: "+i+" num[i]: "+num[i]);
	    	if(i > 0 && num[i] == num[i-1]) {
	    		continue;
	    	}

	    	int low = i+1, high = num.length-1;
	        System.out.println("low: "+low+" high: "+high);
	            
	            while(low < high) {
	            
	            	System.out.println("num[low]: "+num[low]+" num[high]: "+num[high]);
	            	
	            	if(num[low] + num[high] + num[i] == 0) {
	                    res.add(Arrays.asList(num[i], num[low], num[high]));
	                    System.out.println("res: "+res);
	                    
	                    while (low < high && num[low] == num[low+1]) {	//Skip duplicates
	                    	low++;
	                    }
	                    while (low < high && num[high] == num[high-1]) { //Skip duplicates
	                    	high--;
	                    }
	                    
	                    low++; 
	                    high--;
	                } 
	                else if (num[low] + num[high] + num[i] < 0) {	// If sum of three elements is less than zero then increment in left
	                	low++;
	                }
	                else { 
	                	high--;								// if sum is greater than zero than decrement in right side
	                }
	           }
	        
	    }
	    System.out.println("res: "+res);
	    return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {-1, 0, 1, 2, -1, -4};	//{1,-1,-1,0}; //{-2, 0, 0,2,2}; 
		System.out.println(threeSum(arr));
	}

}
