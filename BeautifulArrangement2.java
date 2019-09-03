package Array;

import java.util.Arrays;

/**
 * Leetcode 667. Beautiful Arrangement II
 * https://leetcode.com/problems/beautiful-arrangement-ii/description/
 * Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement: 
 * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers. If there are multiple answers, print any of them
 * Input: n = 3, k = 1; Output: [1, 2, 3], Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.
 * Explanation and Code from: Approach #2 https://leetcode.com/problems/beautiful-arrangement-ii/solution/
 * @author NisuBhakti
 * Time Complexity: O(n), We are making a list of size n; Space Complexity: O(n), Our answer has a length equal to n.
 */

public class BeautifulArrangement2 {

	public static int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int c = 0;
        for (int v = 1; v < n-k; v++) {
            ans[c++] = v;
        }
        for (int i = 0; i <= k; i++) {
            ans[c++] = (i%2 == 0) ? (n-k + i/2) : (n - i/2);
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int n = 3;
		int k = 2;
		int[] arr = constructArray(n, k);
		System.out.println(Arrays.toString(arr));
	}

}
