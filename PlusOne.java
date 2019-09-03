package Array;

import java.util.Arrays;

/**
 * Leetcode 66. Plus One
 * https://leetcode.com/problems/plus-one/discuss/
 * https://www.youtube.com/watch?v=W95W3TELO9E
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * @author NisuBhakti
 * Time Complexity: O(N)
 * most significant digit is on the left and least significant digit is on the far right side
 */

public class PlusOne {

	public static int[] plusOne(int[] digits) {
        System.out.println(Arrays.toString(digits));
		
	    for(int i=digits.length-1; i>=0; i--) {
	    	System.out.println("i: "+i+" digits[i]: "+digits[i]);
	        
	    	if(digits[i] == 9) {
	            digits[i] = 0;
	        }
	        else {
	        	digits[i]++;
	        	return digits;
	        }
	    }
	    
	    int[] newNumber = new int[digits.length+1];
	    newNumber[0] = 1;
	    return newNumber;
	}
	 
	public static void main(String[] args) {
		int[] arr = {9,9};
		arr = plusOne(arr);
		System.out.println(Arrays.toString(arr));
	}

}
