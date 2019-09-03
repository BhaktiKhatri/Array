package Array;

import java.util.Arrays;

/**
 * Leetcode 561. Array Partition
 * https://leetcode.com/problems/array-partition-i/discuss/ 
 * @author NisuBhakti
 * Time complexity : O(nlog(n)). Sorting takes O(nlog(n)) time. We iterate over the array only once. Space complexity : O(1) Constant extra space is used.
 */
public class ArrayPartition1 {

	//We can sort the elements of the given array and form the pairings of the elements directly in the sorted order.
	//This will lead to the pairings of elements with minimum difference between them leading to the maximization of the required sum.
	public static int arrayPairSum(int[] nums) {
        System.out.println(Arrays.toString(nums));
		Arrays.sort(nums);
        int sum = 0;
        System.out.println(Arrays.toString(nums));
        
        for (int i = 0; i < nums.length; i = i + 2) {
        	System.out.println("i: "+i+" sum: "+sum+ " nums[i]: "+nums[i]);
        	sum = sum + nums[i];
        }
        
        System.out.println("sum: "+sum);
        return sum;
    }

	public static void main(String[] args) {
		int arr[] = {1,4,3,2};
		System.out.println("ans: "+ArrayPartition1.arrayPairSum(arr));
	}

}
