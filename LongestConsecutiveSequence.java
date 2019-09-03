package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 * Example: Input: [100, 4, 200, 1, 3, 2]; Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Explanation and Code from: @yfcheng https://leetcode.com/problems/longest-consecutive-sequence/discuss/41057/Simple-O(n)-with-Explanation-Just-walk-each-streak
 * Time complexity: O(n); Although the time complexity appears to be quadratic due to the while loop nested within the for loop, closer inspection reveals
 * it to be linear. Because the while loop is reached only when currentNum marks the beginning of a sequence (i.e. currentNum-1 is not present in nums),
 * the while loop can only run for n iterations throughout the entire runtime of the algorithm. This means that despite looking like O(n*n) complexity, 
 * the nested loops actually run in O(n+n)=O(n) time. All other computations occur in constant time, so the overall runtime is linear.
 * Space complexity: O(n); In order to set up O(1) containment lookups, we allocate linear space for a hash table to store the O(n) numbers in nums. 
 * Other than that, the space complexity is identical to that of the brute force solution.
 */

public class LongestConsecutiveSequence {

	/*
	 * First turn the input into a set of numbers. That takes O(n) and then we can ask in O(1) whether we have a certain number.
	 * Then go through the numbers. If the number x is the start of a streak (i.e., x-1 is not in the set), then test y = x+1, x+2, x+3, ... and 
	 * stop at the first number y not in the set. The length of the streak is then simply y-x and we update our global best with that. Since we check each
	 * streak only once, this is overall O(n). 
	 */
	
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        System.out.println("nums: "+Arrays.toString(nums));
        
        for(int n : nums) {
            set.add(n);
        }
        System.out.println("set: "+set);
        
        int best = 0;
        for(int n: set) {
        	System.out.println("n: "+n+" (n - 1): "+(n - 1));
        	
            if(!set.contains(n - 1)) {  						// only check for one direction
                int m = n + 1;
                System.out.println("m: "+m);
                
                while(set.contains(m)) {
                    m++;
                }
                System.out.println("m: "+m+" n: "+n+" best: "+best);
                
                best = Math.max(best, m - n);
            }
        }
        System.out.println("best: "+best);
        return best;
    }

	
	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2};
		
		System.out.println(longestConsecutive(nums));
	}

}
