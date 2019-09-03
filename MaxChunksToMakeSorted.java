package Array;

import java.util.Arrays;

/*
 * 769. Max Chunks To Make Sorted
 * https://leetcode.com/problems/max-chunks-to-make-sorted/description/
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), 
 * and individually sort each chunk.  After concatenating them, the result equals the sorted array.
 * What is the most number of chunks we could have made?
 * Example 1: Input: arr = [4,3,2,1,0] Output: 1; Explanation: Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 * Example 2: Input: arr = [1,0,2,3,4] Output: 4; Explanation: We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 * Note: arr will have length in range [1, 10]. arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 * Explanation and Code from: https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)-Solution-with-detailed-explanation
 * https://translate.google.com/translate?hl=en&sl=zh-CN&u=https://www.liuchuo.net/archives/4315&prev=search
 * Google
 * Medium
 */

public class MaxChunksToMakeSorted {

	public static int maxChunksToSorted(int[] arr) {
        int count = 0;
        int max = 0;
        System.out.println("arr: "+Arrays.toString(arr));
        
        for(int i=0; i<arr.length; i++) {
        	
        	System.out.println("i: "+i+" arr[i]: "+arr[i]+" max: "+max);
            max = Math.max(max, arr[i]);
            
            System.out.println("i: "+i+" max: "+max+" count: "+count);
            if(max == i) 
            	count++;
            
            System.out.println("count: "+count);
        }
        System.out.println("count: "+count);
        return count;
    }
	
	public static void main(String[] args) {
		int[] arr = {0, 2, 4, 3, 1, 7, 5, 6};
		System.out.println(maxChunksToSorted(arr));
	}

}