package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 442. Find All Duplicates in an Array
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once. 
 * Find all the elements that appear twice in this array. Could you do it without extra space and in O(n) runtime?
 * Input: [4,3,2,7,8,2,3,1] Output: [2,3]
 * Explanation from: https://www.youtube.com/watch?v=HuZJqRDOPo0
 * Code from: @YuxinCao https://leetcode.com/problems/find-all-duplicates-in-an-array/discuss/92387/Java-Simple-Solution
 * Time Complexity: O(N); Space Complexity: O(1)
 * Pocket Gems 
 */

public class FindAllDuplicatesInArray {

	// when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		System.out.println("nums: "+Arrays.toString(nums));
		
		for(int i=0; i<nums.length; i++) {
			
			System.out.println("i: "+i+" nums[i]: "+nums[i]+" Math.abs(nums[i]): "+Math.abs(nums[i]));
			
            int index = Math.abs(nums[i])-1;
            System.out.println("index: "+index+" nums[index]: "+nums[index]);
            
            if(nums[index] < 0) {
                res.add(index+1); //res.add(Math.abs(nums[index]));
                System.out.println("res: "+res);
            }
            nums[index] = -nums[index];
        }
		System.out.println("res: "+res);
        return res;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,1,3,6,6};  //{4,3,2,7,8,2,3,1};
		System.out.println(findDuplicates(arr));
	}
}
