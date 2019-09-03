package Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Leetcode 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * Input:nums = [1,1,1], k = 2; Output: 2
 * Explanation and Code from: Approach #4 https://leetcode.com/problems/subarray-sum-equals-k/solution/
 * https://stackoverflow.com/questions/45066119/finding-number-of-subarrays-whose-sum-equals-k
 * http://zxi.mytechroad.com/blog/hashtable/leetcode-560-subarray-sum-equals-k/
 * Time complexity : O(n), The entire nums array is traversed only once.
 * Space complexity : O(n), Hashmap map can contain upto n distinct entries in the worst case.
 * Google
 * Medium
 */

public class SubArraySumEqualsK {

	public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        
        System.out.println("nums: "+Arrays.toString(nums)+" k: "+k);
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();	//key-sum; value-count of sum
        map.put(0, 1);
        System.out.println("map: "+map);
        
        for(int i=0; i<nums.length; i++) {
            
        	System.out.println("i: "+i+" nums[i]: "+nums[i]+" sum: "+sum);

        	sum = sum + nums[i];
            System.out.println("sum: "+sum+" map: "+map+" sum-k: "+(sum-k));
        	
            //if map.containsKey(sum - k) is true - it means that the remaining sum is k
            if(map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
            }
            System.out.println("count: "+count);
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {3,4,7,2,-3,1,4,2};  //{1,1,1};
		int k = 7;
		System.out.println(subarraySum(nums, k));
	}
}
