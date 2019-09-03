package Array;

/**
 * Leetcode 665. Non-decreasing Array
 * https://leetcode.com/problems/non-decreasing-array/description/
 * http://nirajsdatabase.blogspot.com/2017/08/given-array-with-n-integers-your-task.html
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 * Input: [4,2,3]; Output: True; Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * @author NisuBhakti
 * Time Complexity: O(N)
 */

public class NonDecreasingArray {

	public static boolean checkPossibility(int[] nums) {
		int count = 0;
		
		for(int i=0; i<nums.length-1 && count<=1; i++) {
			if(nums[i] > nums[i+1]) {					// e.g. [-1,3,2,4] 3>2; -1<=2
				if(i > 0) {
					if(nums[i-1] <= nums[i+1]) {	//if number is lesser or equal modify nums[i] to previous number. 2<=2 modify nums[i] =2
						nums[i] = nums[i-1];
					}
					else {							//in all other cases modify the next number to the current number to match the sequence
						nums[i+1] = nums[i];		//e.g. {3,4,2,4} 4>2; 3 not < 2 i.e 4,3 > 2
					}
				}
				count++;
			}
		}
		return count <= 1;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,4,2,4};
		System.err.println(checkPossibility(arr));
	}

}
