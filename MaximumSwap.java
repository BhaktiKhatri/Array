package Array;

import java.util.Arrays;

/**
 * Leetcode 670. Maximum Swap
 * https://leetcode.com/problems/maximum-swap/description/
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
 * Input: 2736; Output: 7236; Explanation: Swap the number 2 and the number 7.
 * Explanation and Code from: Approach #2 https://leetcode.com/problems/maximum-swap/solution/
 * Time Complexity: O(N), where N is the total number of digits in the input number. Every digit is considered at most once. 
 * Space Complexity: O(1), The additional space used by last only has up to 10 values.
 */

public class MaximumSwap {

	/*
		Intuition: At each digit of the input number in order, if there is a larger digit that occurs later, 
		we know that the best swap must occur with the digit we are currently considering.
		
		Algorithm: We will compute last[d] = i, the index i of the last occurrence of digit d (if it exists). 
		Afterwards, when scanning the number from left to right, if there is a larger digit in the future, 
		we will swap it with the largest such digit; if there are multiple such digits, we will swap it with the one that occurs the latest.
	*/
	public static int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        
        System.out.println("num: "+num+" arr: "+Arrays.toString(arr));
        
        for(int i=0; i<arr.length; i++) {
        	System.out.println("i: "+i+" arr[i]: "+arr[i]);
        	last[arr[i] - '0'] = i;
        }

        System.out.println("last: "+Arrays.toString(last));
        
        for(int i=0; i<arr.length; i++) {
            for(int d = 9; d > arr[i] - '0'; d--) {
               
            	System.out.println("i: "+i+" d: "+d+" last[d]: "+last[d]);
            	
            	if(last[d] > i) {
                    	System.out.println("arr[i]: "+arr[i]+" arr[last[d]]: "+arr[last[d]]);
	            		char tmp = arr[i];
	                    arr[i] = arr[last[d]];
	                    arr[last[d]] = tmp;
                    return Integer.valueOf(new String(arr));
                }
            }
        }
        return num;
    }
	
	public static void main(String[] args) {
		int num = 2736;
		System.out.println(maximumSwap(num));
	}
}