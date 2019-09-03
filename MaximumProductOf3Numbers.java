package Array;

import java.util.Arrays;

/**
 * Leetcode 628. Maximum Product of Three Numbers
 * https://leetcode.com/problems/maximum-product-of-three-numbers/discuss/
 * Simply find out the three largest numbers and the two smallest numbers using one pass.
 * @author NisuBhakti
 * Time complexity : O(n) Only one iteration over the nums array of length n is required; Space complexity : O(1) Constant extra space is used
 */

public class MaximumProductOf3Numbers {

	public static int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;			//min1 and min2 are needed when there are -ve numbers in array
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        
        System.out.println("nums: "+Arrays.toString(nums));
        
        for(int n: nums) {
        	System.out.println("n: "+n+" max1: "+max1+" max2: "+max2+" max3: "+max3+" min1: "+min1+" min2: "+min2);
        	
        	if (n <= min1) {
                min2 = min1;
                min1 = n;
            } 
        	else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } 
            else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } 
            else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        
        System.out.println("min1: "+min1+" min2: "+min2);
        System.out.println("max1: "+max1+" max2: "+max2+" max3: "+max3);
        
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
	
	public static void main(String[] args) {
		int[] arr = {-1,-2,3,4,5};
		System.out.println(maximumProduct(arr));
	}

}
