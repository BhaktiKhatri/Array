package Array;

import java.util.Arrays;

/**
 * Leetcode 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/description/
 * Explanation and Code: https://leetcode.com/problems/next-permutation/solution/
 * For explanation see the image in the above link and also the steps in https://www.programcreek.com/2014/06/leetcode-next-permutation-java/
 * https://www.quora.com/How-would-you-explain-an-algorithm-that-generates-permutations-using-lexicographic-ordering
 * Time Complexity: O(n). In worst case, only two scans of the whole array are needed. 
 * Space Complexity: O(1). No extra space is used. In place replacements are done.
 * Google
 * Medium
 */

public class NextPermutation {

	public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        System.out.println("nums: "+Arrays.toString(nums));
        
        while(i >= 0 && nums[i] >= nums[i + 1]) {
        	System.out.println("i: "+i+" nums[i]: "+nums[i]+" nums[i + 1]: "+nums[i + 1]);
            i--;
        }
        
        if(i >= 0) {
            int j = nums.length - 1;
            
            while(j >= 0 && nums[i] >= nums[j]) {
            	System.out.println("j: "+j+" nums[i]: "+nums[i]+" nums[j]: "+nums[j]);
            	j--;
            }
            swap(nums, i, j);
            System.out.println("nums: "+Arrays.toString(nums));
        }
        reverse(nums, i + 1);
    }

    public static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	
	public static void main(String[] args) {
		int[] arr = {3,2,1};//{1, 5, 8, 4, 7, 6, 5, 3, 1};
		System.out.println(Arrays.toString(arr));
		nextPermutation(arr);
		System.out.println(Arrays.toString(arr));
	}

}
