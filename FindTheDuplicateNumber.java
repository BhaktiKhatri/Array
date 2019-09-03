package Array;

import java.util.Arrays;

/**
 * Leetcode 287. Find the Duplicate Number
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * Example 1: Input: [1,3,4,2,2]; Output: 2
 * Example 2: Input: [3,1,3,4,2]; Output: 3
 * Note: You must not modify the array (assume the array is read only).You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2). There is only one duplicate number in the array, but it could be repeated more than once.
 * Explanation and Code from: Approach #3 Floyd's Tortoise and Hare (Cycle Detection) https://leetcode.com/problems/find-the-duplicate-number/solution/
 * Time complexity : O(n), Space complexity : O(1)
 * Bloomberg
 * Medium
 */

public class FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
    	System.out.println(Arrays.toString(nums));

    	// Find the intersection point of the two runners
        int tortoise = nums[0];
        int hare = nums[0];
        System.out.println("tortoise: "+tortoise+" nums[tortoise]: "+nums[tortoise]+" hare: "+hare+" nums[hare]: "+nums[hare]+" nums[nums[hare]]: "+nums[nums[hare]]);
        
        do {
        	System.out.println("tortoise: "+tortoise+" nums[tortoise]: "+nums[tortoise]+" hare: "+hare+" nums[hare]: "+nums[hare]+" nums[nums[hare]]: "+nums[nums[hare]]);
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } 
        while (tortoise != hare);
        System.out.println("tortoise: "+tortoise+" hare: "+hare);
        
        // Find the "entrance" to the cycle
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        System.out.println("ptr1: "+ptr1+" ptr2: "+ptr2);
        
        while(ptr1 != ptr2) {
        	System.out.println("ptr1: "+ptr1+" nums[ptr1]: "+nums[ptr1]+" ptr2: "+ptr2+" nums[ptr2]: "+nums[ptr2]);
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        System.out.println("ptr1: "+ptr1+" ptr2: "+ptr2);
        
        return ptr1;
    }

    //Refer this: https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)-time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation.
    public static int findDuplicate1(int[] nums) {
    	System.out.println(Arrays.toString(nums));

    	// Find the intersection point of the two runners
        int slow = nums[0];
        int fast = nums[nums[0]];
        System.out.println("slow: "+slow+" nums[slow]: "+nums[slow]+" fast: "+fast+" nums[fast]: "+nums[fast]+" nums[nums[fast]]: "+nums[nums[fast]]);
        
        while(slow != fast) {
        	System.out.println("slow: "+slow+" nums[slow]: "+nums[slow]+" fast: "+fast+" nums[hare]: "+nums[fast]+" nums[nums[fast]]: "+nums[nums[fast]]);
            slow = nums[slow];
            fast = nums[nums[fast]];
        } 
        System.out.println("slow: "+slow+" fast: "+fast);
        
        // Find the "entrance" to the cycle
        fast = 0;
        System.out.println("slow: "+slow+" fast: "+fast);
        
        while(slow != fast) {
        	System.out.println("slow: "+slow+" nums[slow]: "+nums[slow]+" fast: "+fast+" nums[fast]: "+nums[fast]);
        	slow = nums[slow];
        	fast = nums[fast];
        }
        System.out.println("slow: "+slow+" fast: "+fast);
        
        return slow;
    }
    
	public static void main(String[] args) {
		int[] nums = {2,5,9,6,9,3,8,9,7,1}; 	//{1,4,6,6,6,2,3};
		System.out.println(findDuplicate(nums));
	}
}