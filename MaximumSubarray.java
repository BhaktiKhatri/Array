package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 53. Maximum Subarray
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * https://leetcode.com/problems/maximum-subarray/description/
 * Also known as Kadane's Algorithm
 * @author NisuBhakti
 * Time Complexity: O(n)
 */

public class MaximumSubarray {

	public static int maxSubArraySum(int[] nums) {
		System.out.println("nums: "+Arrays.toString(nums));
		int max_so_far = nums[0];
		int curr_max = nums[0];
		int num = 0;
		System.out.println("max_so_far: "+max_so_far+" curr_max: "+curr_max);
		
		for(int i=1; i<nums.length; i++) {
			num = nums[i];
			System.out.println("num: "+num+" curr_max: "+curr_max+" curr_max + num: "+(curr_max+num));
			
			curr_max = Math.max(num, curr_max + num);			//curr_max keeps the max no from the num[i] and the sum of (num[i] + and prev max num)  
			System.out.println("max_so_far: "+max_so_far+" curr_max: "+curr_max);
			
			max_so_far = Math.max(max_so_far, curr_max);		//max_so_far keeps the max of curr_max
			System.out.println("max_so_far: "+max_so_far);
			System.out.println("num: "+num+" curr_max: "+curr_max+" max_so_far: "+max_so_far);
		}
		return max_so_far;
	}
	
	//returns subarray which has max sum
	//Code: https://github.com/Partsaleva/Java-practice/blob/34d976aceebb9b09eba62b13ec0b81e1a2673c60/Algorithm/src/MaxSumSubArray.java
	//Question: https://www.hackerrank.com/challenges/maxsubarray/problem?isFullScreen=true
	public static int[] maxSumSubArray(int nums[]) 
    { 
		int start = 0;
		int end = 0;
        int curr_max = nums[0];
        int max_so_far = nums[0];

        System.out.println("nums: "+Arrays.toString(nums));
        
        for(int i=1; i<nums.length; i++) {
            System.out.println("nums[i]: "+nums[i]+" curr_max: "+curr_max+" curr_max+ nums[i]: "+(curr_max + nums[i])+" start: "+start);
        	
        	if(nums[i] > curr_max + nums[i] ) {
        		curr_max = nums[i];
                start = i;
            } 
        	else {
        		curr_max = curr_max + nums[i];
            }
        	
        	System.out.println("max_so_far: "+max_so_far+" curr_max: "+curr_max+" start: "+start+" end: "+end+" i: "+i);

            if(max_so_far < curr_max) {
            	max_so_far = curr_max;
                end = i + 1;
            }
            System.out.println("start: "+start+" end: "+end+" curr_max: "+curr_max+" max_so_far: "+max_so_far);
        }
        
        int[] result = new int[end - start];
        int index=0;
        for(int i=start; i<end; i++) {
        	result[index] = nums[i];
        	index++;
        }
        
        return result;
    } 
	
	public static void main(String[] args)
    {
	    //int arr[] = {-2, -3, 4, 1, 3, -1, 5, 6,-19};
		int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
	    //int arr[] = {6, -1, 3, 5, -10};
	    int max_sum = maxSubArraySum(arr);
	    System.out.println("Maximum contiguous sum is: "+max_sum);
	    
	    //int[] res = maxSumSubArray(arr);
	    //System.out.println("Maximum contiguous sum sub array is: "+Arrays.toString(res));
    }
}
