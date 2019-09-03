package Array;

import java.util.Arrays;

/**
 * Leetcode 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 * Explanation from: @teddyyyy https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity
 * Code from: @mzchen https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity
 * Time Complexity: O(n)
 * LinkedIn
 * Medium
 */

public class MaximumProductSubArray {

	/*
	 * very nice . I guess a bit of more explanation would help people understand:
	 * this is very similar to the " max cumulative sum subarray" problem. here you keep 2 values: the max cumulative product UP TO current element 
	 * starting from SOMEWHERE in the past, and the minimum cumuliative product UP TO current element . it would be easier to see the DP structure if
	 * we store these 2 values for each index, like maxProduct[i],minProduct[i] .
	 * at each new element, u could either add the new element to the existing product, or start fresh the product from current index (wipe out previous
	 * results), hence the 2 Math.max() lines.
	 * if we see a negative number, the "candidate" for max should instead become the previous min product, because a bigger number multiplied by negative 
	 * becomes smaller, hence the swap()
	 */
	public static int maxProduct(int A[]) {
	    // store the result that is the max we have found so far
	    int r = A[0];
	    int imax = r;
	    int imin = r;
	    System.out.println(Arrays.toString(A));
	    
	    // imax/imin stores the max/min product of subarray that ends with the current number A[i]
	    for(int i=1; i<A.length; i++) {
	        // multiplied by a negative makes big number smaller, small number bigger so we redefine the extremums by swapping them
	        if (A[i] < 0) {
	        	System.out.println("before swap imax: "+imax+" imin: "+imin);
	        	//swap(imax, imin);
	        	int temp = imax;
	        	imax = imin;
	        	imin = temp;
	        	System.out.println("after swap imax: "+imax+" imin: "+imin);
	        }

	        System.out.println("A[i]: "+A[i]+" imax: "+imax+" imin: "+imin+" r: "+r+" imax * A[i]: "+(imax * A[i])+" imin * A[i]: "+(imin * A[i]));

	        // max/min product for the current number is either the current number itself or the max/min by the previous number times the current one
	        imax = Math.max(A[i], imax * A[i]);
	        imin = Math.min(A[i], imin * A[i]);

	        System.out.println("imax: "+imax+" imin: "+imin);
	        
	        // the newly computed max value is a candidate for our global result
	        r = Math.max(r, imax);
	    }
	    return r;
	}
	
	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,-2,4};
		System.out.println(maxProduct(arr));
	}

}
