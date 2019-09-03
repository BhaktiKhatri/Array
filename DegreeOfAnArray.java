package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 697. Degree of an Array
 * https://leetcode.com/problems/degree-of-an-array/description/
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements. Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * @author NisuBhakti
 * Time Complexity: O(N), where N is the length of nums. Every loop is through O(N) items with O(1) work inside the for-block. 
 * Space Complexity: O(N), space used by leftIndex, rightIndex, and count.
 */

public class DegreeOfAnArray {

	/**
	 * An array that has degree d, must have some element x occur d times. If some subarray has the same degree, then some element x (that occured d times), still occurs d times.
	 * The shortest such subarray would be from the first occurrence of x until the last occurrence. For each element in the given array, let's know left, the index of its first occurrence; and right, the index of its last occurrence. 
	 * For example, with nums = [1,2,3,2,5] we have left[2] = 1 and right[2] = 3.
	 * Then, for each element x that occurs the maximum number of times, right[x] - left[x] + 1 will be our candidate answer, and we'll take the minimum of those candidates.
	 * @param nums: given array
	 * @return smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums
	 */
	
	public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> leftIndex = new HashMap<Integer, Integer>();	//key - array element; value- leftmost index of array element
        Map<Integer, Integer> rightIndex = new HashMap<Integer, Integer>();	//key - array element; value- rightmost index of array element
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();		//key - array element; value- number of times it occurs in array

        for (int i=0; i<nums.length; i++) {
            int x = nums[i];
            if(leftIndex.get(x) == null) 
            	leftIndex.put(x, i);
            rightIndex.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        
        System.out.println("left: "+leftIndex+" right: "+rightIndex+" count: "+count);

        int shortestLength = nums.length;
        int degree = Collections.max(count.values());
        System.out.println("degree: "+degree);
        
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                shortestLength = Math.min(shortestLength, rightIndex.get(x) - leftIndex.get(x) + 1);
            }
        }
        return shortestLength;
    }
	
	 //Refer this
	//https://leetcode.com/problems/degree-of-an-array/discuss/108650/Easy-understand-Java-Solution-(Beats-100-solutions)
	 public static int findShortestSubArray1(int[] nums) {
	        if(nums.length == 0 || nums == null) 
	        	return 0;
	        System.out.println("nums: "+Arrays.toString(nums));
	        
	        Map<Integer, int[]> map = new HashMap<>();
	        for(int i=0; i<nums.length; i++) {
	           System.out.println("i: "+i+" nums[i]: "+nums[i]+" map: "+map);
	           if (!map.containsKey(nums[i])) {
	               map.put(nums[i], new int[]{1, i, i});  // the first element in array is degree, second is first index of this key, third is last index of this key
	           } 
	           else {
	               int[] temp = map.get(nums[i]);
	               temp[0]++;
	               temp[2] = i;
	           }
	        }
	        System.out.println("map: "+map);
	        
	        int degree = Integer.MIN_VALUE;
	        int res = Integer.MAX_VALUE;
	        
	        for(int[] value : map.values()) {
	        	System.out.println("value: "+Arrays.toString(value)+" degree: "+degree+" res: "+res);
	            if (value[0] > degree) {
	                degree = value[0];
	                res = value[2] - value[1] + 1;
	            } 
	            else if(value[0] == degree) {
	                res = Math.min(value[2] - value[1] + 1, res);
	            } 
	        }
	        System.out.println("res: "+res);
	        return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 1};
		System.out.println(Arrays.toString(arr));
		System.out.println(findShortestSubArray1(arr));
	}
}
