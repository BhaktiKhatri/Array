package Array;

import java.util.Arrays;

/*
 * 775. Global and Local Inversions
 * https://leetcode.com/problems/global-and-local-inversions/description/
 * We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.
 * The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].
 * The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].
 * Return true if and only if the number of global inversions is equal to the number of local inversions.
 * Example 1: Input: A = [1,0,2]; Output: true; Explanation: There is 1 global inversion, and 1 local inversion.
 * Example 2: Input: A = [1,2,0]; Output: false; Explanation: There are 2 global inversions, and 1 local inversion.
 * Note: A will be a permutation of [0, 1, ..., A.length - 1]; A will have length in range [1, 5000]; The time limit for this problem has been reduced.
 * Explanation and Code from: https://leetcode.com/problems/global-and-local-inversions/discuss/113644/Easy-and-Concise-Solution-C++JavaPython
 * https://translate.google.com/translate?hl=en&sl=zh-CN&u=https://blog.csdn.net/liuchuo/article/details/79195105&prev=search
 * https://translate.google.com/translate?hl=en&sl=zh-CN&u=https://blog.csdn.net/u014688145/article/details/79193891&prev=search
 * Time Complexity: O(N), where N is the length of A
 * Space Complexity: O(1)
 * Amazon
 * Medium
 */

public class GlobalAndLocalInversions {

	/*
	 * All local inversions are global inversions. In order for local inversion == global inversion, only local inversion can exist in A 
	 * If the number of global inversions is equal to the number of local inversions, it means that all global inversions in permutations are local inversions
	 * so in order for the count of local inversions to be same as global inversion, there should not be any extra global inversions as the local inversions 
	 * are already global inversions. So, there should be no (extra) global inversions
	 * It also means that we can not find A[i] > A[j] with i + 2 <= j i.e there would be no global inversions 
	 * In other words, max(A[i]) < A[i+2] so that we don't have any global inversions
	 * So, if max(A[i]) > A[i+2] then there will be global inversions so return false
	 * In this first solution, I traverse A and keep the current biggest number cmax. Then I check the condition cmax < A[i+2]
	 */
	public static boolean isIdealPermutation(int[] A) {
        int cmax = 0;
        int n = A.length;
        
        System.out.println("A: "+Arrays.toString(A));
        
        for(int i=0; i<n-2; i++) {
        	
        	System.out.println("i: "+i+" A[i]: "+A[i]+" cmax: "+cmax);
        	
            cmax = Math.max(cmax, A[i]);
            System.out.println("cmax: "+cmax+" A[i+2]: "+A[i+2]);
            
            if(cmax > A[i+2]) {
                return false;
            }
        }
        return true;
   }
	
	public static void main(String[] args) {
		int[] A = {1,2,0};
		System.out.println(isIdealPermutation(A));
	}

}
