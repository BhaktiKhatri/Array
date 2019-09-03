package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 216. Combination Sum III
 * https://leetcode.com/problems/combination-sum-iii/description/
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Input: k = 3, n = 7; Output: [[1,2,4]]
 * Time Complexity: O(N); Space Complexity:
 * Medium
 */

public class CombinationSum3 {

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new ArrayList<>();
		
		System.out.println("k: "+k+" n: "+n);
	    combination(ans, new ArrayList<Integer>(), k, 1, n);
	    return ans;
    }
	
	public static void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
		System.out.println("comb: "+comb+" k: "+k+" start: "+start+" n: "+n);
		
		if(comb.size() > k) {
	         return;
	    }
		else if(comb.size() == k && n == 0) {
			List<Integer> li = new ArrayList<Integer>(comb);
			ans.add(li);
			return;
		}
		
		for(int i = start; i <= n && i <= 9; i++) {
			System.out.println("i: "+i+" start: "+start+" ans: "+ans+" n: "+n+" comb: "+comb);
			
			comb.add(i);
			System.out.println("comb: "+comb+" i: "+i);
			
			combination(ans, comb, k, i+1, n-i);
			System.out.println("i: "+i+" start: "+start+" ans: "+ans+" n: "+n+" comb: "+comb);
			
			comb.remove(comb.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int k = 3;
		int n = 9;
		List<List<Integer>> ans = combinationSum3(k, n); 
		System.out.println(ans);
	}

}
