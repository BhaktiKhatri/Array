package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 163. Missing Ranges
 * https://leetcode.com/problems/missing-ranges/description/
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 * Explanation and Code from: @vimukthi https://leetcode.com/problems/missing-ranges/discuss/50476/Accepted-Java-solution-with-explanation
 * Time Complexity: O(N)
 * Google
 * Medium
 */

public class MissingRanges {

	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<String>();
        int justBelow = 0;
        
        System.out.println("nums: "+Arrays.toString(nums)+" lower: "+lower+" upper: "+upper);
        
        for(int n: nums) {
        	System.out.println("n: "+n);
        	
        	justBelow = n - 1;
        	System.out.println("lower: "+lower+" justBelow: "+justBelow);
        	
            if(lower == justBelow) {
            	list.add(lower+"");
            }
            else if(lower < justBelow) { 
            	list.add(lower + "->" + justBelow);
            }
            lower = n+1;
        }
        
        System.out.println("lower: "+lower+" upper: "+upper);

        if(lower == upper) {
        	list.add(lower+"");
        }
        else if(lower < upper) {
        	list.add(lower + "->" + upper);
        }
        return list;
    }
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 3, 50, 75};
		int lower = 0;
		int upper = 99;
		
		System.out.println(findMissingRanges(nums, lower, upper));
	}
}
