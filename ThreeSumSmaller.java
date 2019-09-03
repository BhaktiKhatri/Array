package Array;

import java.util.Arrays;

/**
 * Leetcode 259. 3Sum Smaller
 * https://leetcode.com/problems/3sum-smaller/description/
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * For example, given nums = [-2, 0, 1, 3], and target = 2. Return 2. Because there are two triplets which sums are less than 2: [-2, 0, 1], [-2, 0, 3]
 * Explanation and code from: https://leetcode.com/problems/3sum-smaller/discuss/68817/Simple-and-easy-understanding-O(n2)-JAVA-solution
 * Time Complexity: O(n^2); The twoSumSmaller function takes O(n) time because both left and right traverse at most n steps. Thus, the overall time complexity is O(n^2)
 * Space Complexity: O(1)
 * Medium
 * Google
 */

public class ThreeSumSmaller {

	/**
	 * Let us try sorting the array first. For example, nums = [3,5,2,8,1] becomes [1,2,3,5,8] 
	 * Let us look at an example nums = [1,2,3,5,8], and target = 7
	 * [1, 2, 3, 5, 8]
	 *  ↑           ↑
	 *  left       right
	 *  Let us initialize two indices, leftindex and rightindex pointing to the first and last element respectively.
	 *  When we look at the sum of first and last element, it is 1 + 8 = 9, which is greater than or equal to target. That tells us no index pair
	 *  will ever contain the index right. So the next logical step is to move the right pointer one step to its left.
	 *  [1, 2, 3, 5, 8]
	 *   ↑        ↑
	 *   left    right
	 *  Now the pair sum is 1 + 5 = 6, which is < target. How many pairs with one of the index = left that satisfy the condition? 
	 *  You can tell by the difference between right and left which is 3, namely (1,2), (1,3), and (1,5). Therefore, we move left
	 *  one step to its right.
	 * @param nums given array
	 * @param target sum
	 * @return the number of triplet pairs that have sum smaller than the target sum
	 */
	public static int threeSumSmaller(int[] nums, int target) {
	    Arrays.sort(nums);
	    System.out.println(Arrays.toString(nums)+" target: "+target);
	    
	    int pairNum = 0;
	    for(int i=0; i<nums.length; i++) {
	    	System.out.println("i: "+i+" nums[i]: "+nums[i]);
	    	int low = i + 1;
	    	int high = nums.length-1;
	    	
	    	System.out.println("low: "+low+" high: "+high);
	    	
	    	while(low < high) {
	    		System.out.println("nums[low]: "+nums[low]+" nums[high]: "+nums[high]);
	    		
	    		if(nums[i] + nums[low] + nums[high] < target) {
	    			pairNum = pairNum + high - low;
	    			low++;
	    		}
	    		else
	    		{
	    			high--;
	    		}
	    	}
	    }
	    return pairNum;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,5,8}; //{-2,0,1,3};
		System.out.println(threeSumSmaller(arr, 7));
	}

}
