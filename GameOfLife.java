package Array;

import java.util.Arrays;

/**
 * Leetcode 289. Game of Life
 * https://leetcode.com/problems/game-of-life/description/
 * Explanation and Code from: @Mr_Kim https://leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation
 * https://forum.letstalkalgorithms.com/t/game-of-life/516
 * Google, Snapchat, Dropbox, Two Sigma
 */

public class GameOfLife {

    private static int die = 2;
    private static int live = 3;
    
    public static void gameOfLife(int[][] board) {
        // we only flip the 1 to die and 0 to live so when we find a die around, it must be a previous 1 
    	//then we can count the 1s without being affected
        int rows = board.length;
        int cols = board[0].length;
        
        System.out.println("rows: "+rows+" cols: "+cols);
        
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
            	System.out.println("i: "+i+" j: "+j+" board: "+board);
            	
                int around = countLive(i,j,board);	//around = number of neighbors
                System.out.println("around: "+around+" board[i][j]: "+board[i][j]);
               
                if (board[i][j] == 0 && around == 3) {	//rule 4
                    board[i][j] = live;
                }
                else if (board[i][j] == 1) {
                    if (around == 2 || around ==3) {	//rule 2
                        continue;
                    }
                    
                    if (around < 2 || around > 3) {	//rule 1,3
                        board[i][j] = die;			
                    }
                }
            }
        }
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
            	System.out.println("i: "+i+" j: "+j+" board[i][j]: "+board[i][j]);
                 
            	if(board[i][j] == die) {
                     board[i][j] = 0;
                 }
                 
                 if (board[i][j] == live) {
                     board[i][j] = 1;
                 }
            }
        }
    }
    
    private static int countLive(int i, int j,int[][] board) {
    	System.out.println("i: "+i+" j: "+j);
        
    	int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        			//  down,  up,  right, left,   ddr,  ddl,   dur,  dul ; 
        for(int[] dir: dirs) {
        	System.out.println("dir: "+Arrays.toString(dir)+" count: "+count);
            
        	int x = i + dir[0];
            int y = j + dir[1];
            System.out.println("x: "+x+" y: "+y);
            
            if(x>=0 && y>=0 && x < board.length && y<board[0].length) {
                System.out.println("board[x][y]: "+board[x][y]+" count: "+count);
            	
                if (board[x][y] == 1 || board[x][y] == die)	//as it was 1 previously
                    count++;
            }
        }
        System.out.println("count: "+count);
        
        return count;
    }
	
	public static void main(String[] args) {
		int[][] board = {
		                 {0,1,0},
		                 {0,0,1},
		                 {1,1,1},
		                 {0,0,0}
						};
		
		gameOfLife(board);
	}
}