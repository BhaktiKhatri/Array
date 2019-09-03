package Array;

import java.util.Arrays;

/*
 * 795. Number of Subarrays with Bounded Maximum
 * https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/description/
 * We are given an array A of positive integers, and two positive integers L and R (L <= R)
 * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least L and at most R
 * Example: Input: A = [2, 1, 4, 3]; L = 2; R = 3; Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3]
 * Note: L, R  and A[i] will be an integer in the range [0, 10^9]
 * The length of A will be in the range of [1, 50000]
 * Explanation and Code from: @kay_deep https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/discuss/117595/Short-Java-O(n)-Solution?page=1
 * https://www.geeksforgeeks.org/number-subarrays-maximum-value-given-range/
 * Time Complexity: O(N), where N is the length of A
 * Space Complexity: O(1)
 * Adobe
 * Medium
 */

public class NumberOfSubarraysWithBoundedMaximum {

	/*
	 * An efficient approach is based on below facts :
	 * Any element > R is never included in any subarray.
	 * Any number of elements smaller than L can be included in subarray as long as there is at least one single element between L and R inclusive.
	 * 
	 * The condition A[i]>=L && A[i]<=R,means that A[j:i is a valid subarray and thus we can have (i-j+1) valid subarrays, count is the valid subarrays
	 * between j to i at this point
	 * The condition A[i]<L means that A[j:i] is still a valid subarray but we need the last element (>=L and <=R) which is within A[j:i], thus adding
	 * last valid number of subarrays which is count.
	 * Else just move the back pointer forward
	 * 
	 * Great idea, the explanation is: in every iteration, we add the number of valid subarrays that ends at the current element.
	 * For example, for input A = [0, 1, 2, -1], L = 2, R = 3:
	 * for 0, no valid subarray ends at 0;
	 * for 1, no valid subarray ends at 1;
	 * for 2, three valid subarrays end at 2, which are [0, 1, 2], [1, 2], [2];
	 * for -1, the number of valid subarrays is the same as 2, which are [0, 1, 2, -1], [1, 2, -1], [2, -1];
	 * 
	 */
	public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int j = 0, count = 0, res = 0;
        
        System.out.println("arr: "+Arrays.toString(A)+" L: "+L+" R: "+R);
        
        for(int i=0; i<A.length; i++) {
        	
        	System.out.println("i: "+i+" A[i]: "+A[i]+" L: "+L+" R: "+R);
        	
            if(A[i] >= L && A[i] <= R) {
            	System.out.println("i: "+i+" j: "+j+" res: "+res+" count: "+count);
                res = res + i - j + 1;
                count = i - j + 1;
                System.out.println("i: "+i+" j: "+j+" res: "+res+" count: "+count);
            }
            else if(A[i] < L) {	
            	System.out.println("i: "+i+" j: "+j+" res: "+res+" count: "+count);
            	res = res + count;
                System.out.println("i: "+i+" j: "+j+" res: "+res+" count: "+count);
            }
            else {		// A[i] > R
            	System.out.println("i: "+i+" j: "+j+" res: "+res+" count: "+count);
                j = i + 1;
                count = 0;
                System.out.println("i: "+i+" j: "+j+" res: "+res+" count: "+count);
            }
        }
        return res;
    }
	
//	public int numSubarrayBoundedMax1(int[] A, int L, int R) {
//        return count(A, R) - count(A, L-1);
//    }
//
//    public int count(int[] A, int bound) {
//        int ans = 0, cur = 0;
//        System.out.println("A: "+Arrays.toString(A)+" bound: "+bound);
//        
//        for(int x: A) {
//        	System.out.println("x: "+x+" bound: "+bound+" cur: "+cur);
//            cur = x <= bound ? cur + 1 : 0;
//            ans = ans + cur;
//        }
//        return ans;
//    }
	
	public static void main(String[] args) {
		int[] A = {0, 1, 2, -1}; 				//{2, 1, 4, 3};
		int L = 2;
		int R = 3;
		
		System.out.println(numSubarrayBoundedMax(A, L, R));
	}

}
