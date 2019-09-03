package Array;

import java.util.Arrays;

/**
 * Leetcode 611. Valid Triangle Number
 * https://leetcode.com/problems/valid-triangle-number/description/
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of nums triangle.
 * Input: [2,2,3,4], Output: 3; Explanation: Valid combinations are: 
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Explanation and code from: https://leetcode.com/problems/valid-triangle-number/discuss/104174?page=1
 * Time complexity : O(n^2) Loop of k and j will be executed O(n^2) times in total, because, we do not reinitialize the value of k for nums new value of jj chosen(for the same ii). Thus the complexity will be O(n^2+n^2)=O(n^2).
 * Space complexity : O(logn). Sorting takes O(logn) space. 
 * Expedia
 * Medium
 */

public class ValidTriangleNumber {

	/*
	   1. Remember, the array is sorted
	   2. If the sum of two small elements (at left index and right index) is greater than the rightmost element (largest), then it is obvious that the 
	   	  subsequent sum of pairs will be greater than the rightmost element.
	   	  In your case [2,2,4,5], if (2+4 > 5) then keeping the right index at the same position and increasing the left (the second 2+4 is obviously > 5)
	   3. The reason for count+=r-l is to find out how many pairs satisfy this property
		  In this case, there are two pairs that satisfy this property (2,4) and (2,4). since the right index is decremented, the count becomes r-l which is 2-0 (2 pairs)
	 */
	
	public static int triangleNumber(int[] nums) {
		System.out.println("nums: "+Arrays.toString(nums));
		
		Arrays.sort(nums);
	    int count = 0;
	    
	    System.out.println("nums: "+Arrays.toString(nums));
	    
	    for(int i=nums.length-1; i>=2; i--) {
	        int l = 0, r = i-1;
	        
	        System.out.println("i: "+i+" l: "+l+" r: "+r);
	        
	        while(l < r) {
	        	System.out.println("i: "+i+" l: "+l+" r: "+r);
	        	System.out.println("nums[i]: "+nums[i]+" nums[l]: "+nums[l]+" nums[r]: "+nums[r]);
	        	
	        	if(nums[l] + nums[r] > nums[i]) {
	                count = count + r - l;
	                r--;
	                System.out.println("count: "+count+" r: "+r);
	            }
	            else { 
	            	l++;
	            	System.out.println("l: "+l);
	            }
	        }
	    }
	    System.out.println("count: "+count);
	    
	    return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,2,3,4};
		System.out.println(Arrays.toString(nums));
		System.out.println(triangleNumber(nums));
	}
}
