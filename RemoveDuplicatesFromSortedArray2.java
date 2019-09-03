package Array;

import java.util.Arrays;

/**
 * Leetcode 80. Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/discuss/27976
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 * For example, Given sorted array nums = [1,1,1,2,2,3], Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 * Example 2: Given nums = [0,0,1,1,1,1,2,3,3], Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It doesn't matter what values are set beyond the returned length.
 * Explanation and Code from: @StefanPochmann https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/discuss/27976/3-6-easy-lines-C++-Java-Python-Ruby
 * Facebook
 * Medium
 */

public class RemoveDuplicatesFromSortedArray2 {

	//Just go through the numbers and include those in the result that haven't been included twice already
	public static int removeDuplicates(int[] nums) {
	    int i = 0;
	    System.out.println("nums: "+Arrays.toString(nums));
	    
	    for(int n: nums) {
	    	System.out.println("i: "+i+" n: "+n);
	        
	    	if(i < 2 || n > nums[i-2]) {
	    		System.out.println("i: "+i+" nums[i]: "+nums[i]);
	            nums[i] = n;
	            i++;
	        }
	    }
	    return i;
	}
	
	public int removeKDuplicates(int[] nums, int k) {
	    int i = 0;
	    for(int n : nums) {
	        if(i < k || n > nums[i-k]) {
	            nums[i] = n;
	            i++;
	        }
	    }
	    return i;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,3};
		System.out.println(removeDuplicates(arr));
	}

}
