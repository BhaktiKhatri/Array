package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 830. Positions of Large Groups
 * https://leetcode.com/problems/positions-of-large-groups/description/
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 * The final answer should be in lexicographic order.
 * Example 1: Input: "abbxxxxzzy" Output: [[3,6]] Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2: Input: "abc" Output: [] Explanation: We have "a","b" and "c" but no large group.
 * Example 3: Input: "abcdddeeeeaabbbcd" Output: [[3,5],[6,9],[12,14]]
 * Note:  1 <= S.length <= 1000
 * Explanation and Code from: @lee215 https://leetcode.com/problems/positions-of-large-groups/discuss/128957/C++JavaPython-Straight-Forward 
 * Time Complexity: O(N), where N is the length of S.
 * Space Complexity: O(N), the space used by the answer.
 * Google
 * Easy
 */

public class PositionsOfLargeGroups {

	/*
	 * For every groups, find its start index i and end index j - 1
	 * Group length is j - i, if it's no less than 3, add (i, j) to result.
	 */
	
    public static List<List<Integer>> largeGroupPositions(String S) {
        int i = 0, j = 0, N = S.length();
        List<List<Integer>> res = new ArrayList<>();
        
        System.out.println("S: "+S+" N: "+N);
        
        while(j < N) {
        	System.out.println("i: "+i+" S.charAt(i): "+S.charAt(i)+" j: "+j+" S.charAt(j): "+S.charAt(j));
        	
            while (j < N && S.charAt(j) == S.charAt(i)) {
            	j++;
            }
            	
            System.out.println("i: "+i+" j: "+j+" (j-i): "+(j-i)+" res: "+res);
            
            if(j - i >= 3) { 
            	res.add(Arrays.asList(i, j - 1));
            }
            i = j;
        }
        return res;
    }

	
	public static void main(String[] args) {
		String S = "abcdddeeeeaabbbcd";
		System.out.println(largeGroupPositions(S));
	}

}
