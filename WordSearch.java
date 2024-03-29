package Array;

/**
 * Leetcode 79. Word Search
 * https://leetcode.com/problems/word-search/description/
 * Given a 2D board and a word, find if the word exists in the grid. The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * Given board = [
 * 				  ['A','B','C','E'],
 * 				  ['S','F','C','S'],
 * 				  ['A','D','E','E']
 * 				 ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * Explanation from: https://leetcode.com/problems/word-search/discuss/27658
 * http://codesniper.blogspot.com/2015/03/79-word-search-leetcode.html
 * Code from: @hyuna915 https://leetcode.com/problems/word-search/discuss/27658/Accepted-very-short-Java-solution.-No-additional-space.
 * Microsoft, Facebook, Bloomberg
 * Medium
 */

public class WordSearch {

	public static boolean exist(char[][] board, String word) {
		System.out.println("word: "+word+" word.length(): "+word.length());
	    for(int i=0; i<board.length; i++) {
	        for(int j=0; j<board[0].length; j++) {
	        	System.out.println("i: "+i+" j: "+j);
	        	
	        	if(exist(board, i, j, word, 0)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	private static boolean exist(char[][] board, int i, int j, String word, int index) {
		System.out.println("i: "+i+" j: "+j+" index: "+index);
	    if(index == word.length()) 
	    	return true;
	    if(i > board.length-1 || i <0 || j<0 || j > board[0].length-1 || board[i][j] != word.charAt(index))
	        return false;

	    System.out.println("board[i][j]: "+board[i][j]);
	    
	    board[i][j]='*';
	    boolean result = exist(board, i-1, j, word, index+1) || exist(board, i, j-1, word, index+1) || exist(board, i, j+1, word, index+1) || exist(board, i+1, j, word, index+1);
	    board[i][j] = word.charAt(index);
	    return result;
	}
	
	public static void main(String[] args) {
		char[][] board = {
		                  {'A','B','C','E'},
		                  {'S','F','C','S'},
		                  {'A','D','E','E'}
						};
		String word = "ABCCED";
		System.out.println(exist(board, word));
		
		for(int i = 0; i < board.length; i++) {
	        for(int j = 0; j < board[0].length; j++) {
	        	System.out.print(board[i][j]+" ");
	        }
	        System.out.println();
		}
	        
	}

}
