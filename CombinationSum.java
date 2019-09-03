package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/description/
 * Code from https: @issac3 https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * For example, given candidate set [2, 3, 6, 7] and target 7, 
 * A solution set is: 
 *	[
 *	  [7],
 *	  [2, 2, 3]
 *	]
 * Time Complexity: O(N)
 * I think it`s, O(k * 2 ^ n), where k is the average length of all the combinations and n is the size of nums
 * Explanation and code from: https://www.youtube.com/watch?v=irFtGMLbf-s
 * Uber, Snapchat
 * Medium
 */

public class CombinationSum {

	public static List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    
	    System.out.println("nums: "+Arrays.toString(nums));
	    
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}

	public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		System.out.println("tempList: "+tempList+" remain: "+remain+" start: "+start);
		
	    if(remain == 0) {
	    	list.add(new ArrayList<>(tempList));
	    	return;
	    }
	    else { 
	        for(int i=start; i<nums.length; i++) {
	        	System.out.println("i: "+i+" nums[i]: "+nums[i]+" tempList: "+tempList);
	        	if(nums[i] > remain) {
	        		break;
	        	}
	            
	        	tempList.add(nums[i]);
	            System.out.println("i: "+i+" tempList: "+tempList);
	            
	            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	            System.out.println("i: "+i+" remain: "+remain+" tempList: "+tempList);
	            
	            tempList.remove(tempList.size() - 1);
	            System.out.println("i: "+i+" remain: "+remain+" tempList: "+tempList);
	        }
	    }
	}
	
	public static void main(String[] args) {
		int[] candidate = {2,3,5};
		int target = 8;
		System.out.println(combinationSum(candidate, target));
	}

}
