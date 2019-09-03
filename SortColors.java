package Array;

import java.util.Arrays;

/**
 * Leetcode 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/description/
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue. Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively. Note: You are not suppose to use the library's sort function for this problem.
 * Example: Input: [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
 * Follow up: A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 * Code and explanation from: @dennyrong https://leetcode.com/problems/sort-colors/discuss/26472/Share-my-at-most-two-pass-constant-space-10-line-solution
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * Time Complexity: O(N)
 * Microsoft, Facebook, PocketGems
 * Medium
 */

public class SortColors {

    public static void swap(int[] nums, int start, int end) {
    	int temp = nums[start];
    	nums[start] = nums[end];
    	nums[end] = temp;
    }
    
    // the basic idea is to use two pointer low and high and an iterator i
    // every elem left low pointer is 0, elem right high pointer is 2
    public static void sortColors(int nums[])
    {
    	if(nums.length == 0 || nums.length == 1)
            return;
    	
    	int low = 0;
        int high = nums.length - 1;
        
        System.out.println("nums: "+Arrays.toString(nums));
        
        for(int i=low; i<=high;) {
            
        	System.out.println("i: "+i+" low: "+low+" high: "+high);
        	System.out.println("nums[i]: "+nums[i]+" nums[low]: "+nums[low]+" nums[high]: "+nums[high]+"nums: "+Arrays.toString(nums));
        	
        	if(nums[i] == 0) {
               //swap nums[i] and nums[low] and i,low both ++
        	   swap(nums, i, low);
               i++;
               low++;
            }
            else if(nums[i] == 2) {
               //swap nums[i] and nums[high] and high--;
               swap(nums, i, high);
               high--;
            }
            else {
                i++;
            }
        }
    }
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}

}
