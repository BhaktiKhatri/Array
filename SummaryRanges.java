package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 228. Summary Ranges
 * https://leetcode.com/problems/summary-ranges/description/
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * Input: [0,1,2,4,5,7], Output: ["0->2","4->5","7"]
 * Explanation and Code from: https://leetcode.com/problems/summary-ranges/solution/
 * Time complexity : O(n), Each element is visited constant times: either in comparison with neighbor or put in the result list.
 * Space complexity : O(1), All the auxiliary space we need is the two indices, if we don't count the return list.
 * Google
 * Medium
 */

public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        System.out.println(Arrays.toString(nums));
        
        for(int i=0, j=0; j < nums.length; j++) {
        	if(j < nums.length-1)
        		System.out.println("i: "+i+" j: "+j+" nums[j]: "+nums[j]+" nums[j+1]: "+nums[j+1]+" nums[i]: "+nums[i]);
        	
        	//check if j + 1 extends the range [nums[i], nums[j]]
            if(j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                continue;
            }
            
            // put the range [nums[i], nums[j]] into the list
            if(i == j) {
                summary.add(nums[i] + "");
            }
            else {
                summary.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return summary;
    }
	
	public static void main(String[] args) {
		int[] nums = {0,2,3,4,6,8,9};
		System.out.println(summaryRanges(nums));
	}
}
