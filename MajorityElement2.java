package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 229. Majority Element II
 * https://leetcode.com/problems/majority-element-ii/description/
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 * Explanation and Code from: https://leetcode.com/problems/majority-element-ii/discuss/63520 (@cdai)
 * Time Complexity: O(N)
 * Zenefits
 * Medium
 */

public class MajorityElement2 {

	public static List<Integer> majorityElement(int[] nums) {
		Integer major1 = null, major2 = null, cnt1 = 0, cnt2 = 0;
	    
		for (Integer num : nums) {
	        if (num.equals(major1)) {
	            cnt1++;
	        } 
	        else if (num.equals(major2)) {
	            cnt2++;
	        }
	        else if (cnt1 == 0) {
	            major1 = num;
	            cnt1 = 1;
	        }
	        else if (cnt2 == 0) {
	            major2 = num;
	            cnt2 = 1;
	        }
	        else {
	            cnt1--;
	            cnt2--;
	        }
	    }
	    
	    cnt1 = cnt2 = 0;
	    for (Integer num : nums) {
	        if (num.equals(major1))
	        	cnt1++;
	        else if (num.equals(major2))
	        	cnt2++;
	    }
	    
	    List<Integer> result = new ArrayList<>();
	    if (cnt1 > nums.length / 3) 
	    	result.add(major1);
	    if (cnt2 > nums.length / 3) 
	    	result.add(major2);
	    return result;
    }
	
	public static void main(String[] args) {
	    int arr[] = new int[]{2, 1, 2, 4, 2};
	    System.out.println(majorityElement(arr));
	}

}
