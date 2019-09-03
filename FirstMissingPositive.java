package Array;

import java.util.Arrays;

/*
 * 41. First Missing Positive
 * https://leetcode.com/problems/first-missing-positive/description/
 * Given an unsorted integer array, find the smallest missing positive integer.
 * Example 1: Input: [1,2,0]; Output: 3
 * Example 2: Input: [3,4,-1,1]; Output: 2
 * Example 3: Input: [7,8,9,11,12]; Output: 1
 * Note: Your algorithm should run in O(n) time and uses constant extra space
 * Code from: @tankztc https://leetcode.com/problems/first-missing-positive/discuss/17083/O(1)-space-Java-Solution
 * Explanation from: https://leetcode.com/problems/first-missing-positive/discuss/17302/Concise-O(N)-solution
 * https://www.programcreek.com/2014/05/leetcode-first-missing-positive-java/
 * https://leetcode.com/problems/first-missing-positive/discuss/17071/My-short-c++-solution-O(1)-space-and-O(n)-time?page=1
 * We visit each number once, and each number will be put in its right place at most once, so it is O(n) + O(n). 
 * Although there are two nesting of cyclic (for and while), but its time complexity is still O(n).
 * Medium
 */

public class FirstMissingPositive {

	// ignore all the negative, > n
	// put the other value back to its order position A[A[i]-1]
	
	/*
	 * Put each number in its right place.
	 * For example: When we find 5, then swap it with A[4].
	 * At last, the first place where its number is not right, return the place + 1.
	 * {3,4,-1,1};
	 */
    public static int firstMissingPositive(int[] nums)
    {
    	int n = nums.length;
    	System.out.println("nums: "+Arrays.toString(nums)+" n: "+n);
    	
    	for(int i=0; i<n; i++) {
    		System.out.println("i: "+i+" nums[i]: "+nums[i]+" nums[i]-1: "+(nums[i]-1));
    		
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
            	System.out.println("nums: "+Arrays.toString(nums)+" i: "+i+" nums[i]: "+nums[i]+" nums[i]-1: "+(nums[i]-1));
                swap(nums, i, nums[i]-1);
                System.out.println("nums: "+Arrays.toString(nums));
            }
        }
        
    	System.out.println("nums: "+Arrays.toString(nums));
    	
        for(int i=0; i<nums.length; i++) {
        	System.out.println("i: "+i+" nums[i]: "+nums[i]+" i+1: "+(i+1));
        	
        	if(nums[i] != i+1)    
            	return i+1;
        }
        System.out.println("n+1: "+(n+1));
        
        return n + 1;
    } 
    
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
	
	public static void main(String[] args) {
		int[] nums = {3,4,-1,1}; 
		
		System.out.println(firstMissingPositive(nums));
	}
}