package Array;

import java.util.Arrays;

/**
 * Leetcode 243. Shortest Word Distance
 * https://leetcode.com/problems/shortest-word-distance/description/
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * @author NisuBhakti
 * Time Complexity: O(n); This problem is inherently linear; we cannot do better than O(n) because at the very least, we have to read the entire input
 * Space complexity: O(1), since no additional space is allocated.
 */

public class ShortestWordDifference {

	public static int shortestDistance(String[] words, String word1, String word2) {
		int i1= -1, i2 = -1;
		int minDistance = words.length;
		
		System.out.println("words: "+Arrays.toString(words)+" word1: "+word1+" word2: "+word2);
		
		for(int i=0; i<words.length; i++) {
			System.out.println("i: "+i+" words[i]: "+words[i]+" i1: "+i1+" i2: "+i2+" minDistance: "+minDistance);
			
			if(words[i].equals(word1)) {
				i1 = i;
			}
			else if(words[i].equals(word2)) {
				i2 = i;
			}
			
			if(i1 != -1 && i2 != -1) {
				minDistance = Math.min(minDistance, Math.abs(i1-i2));
			}
		}
		return minDistance;
	}
	
	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(shortestDistance(words, "makes", "coding"));
	}
}