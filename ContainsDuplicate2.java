package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/solution/
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * @author NisuBhakti
 * Time complexity : O(n); We do n operations of search, delete and insert, each with constant time complexity.
 * Space complexity : O(min(n,k)); The extra space required depends on the number of items stored in the hash table, which is the size of the sliding window, min(n,k).
 */

public class ContainsDuplicate2 {
	
	/**
	 * Loop through the array, for each element do
	 * Search current element in the HashTable, return true if found
	 * Put current element in the HashTable
	 * If the size of the HashTable is larger than k, remove the oldest item.
	 * Return false
	 * @param nums
	 * @param k
	 * @return
	 */
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
	    Set<Integer> set = new HashSet<>();
	    for(int i=0; i<nums.length; i++) {
	        if (set.contains(nums[i])) 
	        	return true;
	        else 
	        	set.add(nums[i]);
	        if (set.size() > k) {
	            set.remove(nums[i - k]);
	        }
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,1};
		System.out.println(containsNearbyDuplicate(arr, 3));
	}
}
