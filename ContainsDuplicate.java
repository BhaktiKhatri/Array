package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/description/
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * @author NisuBhakti
 * Time Complexity: O(n); Space Complexity: O(n)
 */

public class ContainsDuplicate {

	public static boolean containsDuplicate(int[] arr) {
		Set<Integer> distinct = new HashSet<Integer>();
		for(int num: arr) {
			if(distinct.contains(num)) {
				return true;
			}
			distinct.add(num);
		}
		return false;
	}
	
	public static void main(String args[]) {
		int[] arr = {1,2,2,4};
		System.out.println(containsDuplicate(arr));
	}
	
}
