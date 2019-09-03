package Array;

import java.util.Arrays;

/**
 * Leetcode 245. Shortest Word Distance III
 * https://leetcode.com/problems/shortest-word-distance-iii/description/
 * Code and explanation from: https://leetcode.com/problems/shortest-word-distance-iii/discuss/67097?page=1
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2. Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list. word1 and word2 may be the same and they represent two individual words in the list.
 * For example, assume that words = ["practice", "makes", "perfect", "coding", "makes"]. 
 * Given word1 = “makes”, word2 = “coding”, return 1. Given word1 = "makes", word2 = "makes", return 3.
 * Time Complexity: O(N)
 */

public class ShortestWordDistance3 {

	public static int shortestWordDistance(String[] words, String word1, String word2) {
        int n = words.length, min = n - 1;
        System.out.println("words: "+Arrays.toString(words)+" word1: "+word1+" word2: "+word2);
        
        for(int i=0, j=-1; i<n; i++) {
        	System.out.println("i: "+i+" j: "+j+" min: "+min);
        	System.out.println("words[i]: "+words[i]);
        	
            if(words[i].equals(word1) || words[i].equals(word2)) {
                if(j != -1 && (!words[j].equals(words[i]) || word1.equals(word2))) { 
                	min = Math.min(min, i - j);
                }
                j = i;
            }
        }
        return min;
    }
	
	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "makes";
		String word2 = "makes";
		System.out.println(shortestWordDistance(words, word1, word2));
	}
}