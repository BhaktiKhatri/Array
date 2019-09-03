package Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Leetcode 674. Longest Continuous Increasing Subsequence
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/discuss/
 * @author NisuBhakti
 * Time Complexity: O(N), where N is the length of nums. We perform one loop through nums; Space Complexity: O(1), the space used by count and result
 */

public class LongestContinuousIncreasingSubsequence {

	/**
	 * The idea is to use count to record the length of the current continuous increasing subsequence which ends with
	 * nums[i], and use result to record the maximum count
	 * @param nums: given array
	 * @return length of longest increasing subsequence
	 */
	public static int findLengthOfLCIS(int[] nums) {
		int result = 0, count = 0;
		ArrayList<Integer> alist = new ArrayList<>();
		int cnt = 0;
		
		for(int i=0; i<nums.length; i++) {
			if(i == 0 || nums[i-1] < nums[i]) {
				result = Math.max(result, ++count);
				if(result != cnt)
					alist.add(nums[i]);
				cnt = result;
				
			}
			else {
				count = 1;
			}
		}
		System.out.println("list: "+alist);
		return result;
	}
	
	//Refer this
	//Explanation and code: @WatchYourBack https://leetcode.com/problems/longest-continuous-increasing-subsequence/discuss/107365/JavaC%2B%2BClean-solution
    public static int findLengthOfLCIS1(int[] nums) {
    	if(nums == null)
            return 0;
        
        if(nums.length == 1)
            return 1;
        
        int maxLenSoFar = 0, curMaxLen = 1;
        System.out.println("nums: "+Arrays.toString(nums));
        
        for(int i = 1; i < nums.length; i++) {
        	System.out.println("i: "+i+" nums[i]: "+nums[i]+" curMaxLen: "+curMaxLen+" maxLenSoFar: "+maxLenSoFar);
            
//        	if(i == 0) { 
//        		curMaxLen = 1;
//            }
            if (nums[i] > nums[i-1]) {
            	curMaxLen++;
            }
            else {
            	System.out.println("i: "+i+" curMaxLen: "+curMaxLen+" maxLenSoFar: "+maxLenSoFar);
            	maxLenSoFar = Math.max(maxLenSoFar, curMaxLen);
            	curMaxLen = 1;
            }
        }
        System.out.println("curMaxLen: "+curMaxLen+" maxLenSoFar: "+maxLenSoFar);
        maxLenSoFar = Math.max(maxLenSoFar, curMaxLen);
        
        return maxLenSoFar;
    }
	
	public static void main(String[] args) {
		int[] arr = {2,2,2,2,2}; //{1,3,5,4,7};
		System.out.println(findLengthOfLCIS1(arr));
	}
}