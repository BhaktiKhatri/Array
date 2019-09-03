package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 532. K-diff Pairs in an Array
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. 
 * Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * @author NisuBhakti
 * Time Complexity: O(N)
 */

public class KDiffPairsinArray {
	
	public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   
        	return 0;
        
        System.out.println("nums: "+Arrays.toString(nums)+" k: "+k);
        
        Map<Integer, Integer> map = new HashMap<>();	//key- array element; value- number of that array element in array; eg 1 appears twice in [3,1,4,1,5] so map{1=2}
        int count = 0;
        
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        System.out.println("map: "+map);
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	System.out.println("entry: "+entry+" entry.getValue(): "+entry.getValue()+" count: "+count);
        	
            if(k == 0) {						//when k=0 pairs will be (1,1), (2,2) etc so its map will be {1=2,2=2}
                if (entry.getValue() >= 2) {	//count how many elements in the array that appear more than twice.
                    count++;
                } 
            } 
            else {
            	System.out.println("entry.getKey(): "+entry.getKey()+" k: "+k);
                
            	if (map.containsKey(entry.getKey() + k)) {			//|pair1-pair2| = k => pair1 = pair2 + k; so find pair1 in map; if found count++ 
                    count++;
                }
            }
        }
        System.out.println("count: "+count);
        
        return count;
    }

	public static void main(String[] args) {
		int[] arr = {1,1,2,3,4,5}; //{3, 1, 4, 1, 5};
		System.out.println(findPairs(arr,0));
	}
}