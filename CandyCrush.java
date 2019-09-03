package Array;

/**
 * Leetcode 723. Candy Crush
 * https://leetcode.com/problems/candy-crush/description/
 * This question is about implementing a basic elimination algorithm for Candy Crush.
 * Explanation and Code from: https://leetcode.com/problems/candy-crush/solution/
 * @author NisuBhakti
 * Time Complexity: O((R*C)^2), where R,C is the number of rows and columns in board. We need O(R*C) to scan the board, and we might crush only 3 candies repeatedly.
 * Space Complexity: O(1) additional complexity, as we edit the board in place.
 *
 */
public class CandyCrush {

	public static int[][] candyCrush(int[][] board) {
        int R = board.length, C = board[0].length;
        boolean todo = false;
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c + 2 < C; ++c) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r][c+1]) && v == Math.abs(board[r][c+2])) {
                    board[r][c] = board[r][c+1] = board[r][c+2] = -v;
                    todo = true;
                }
            }
        }
        for (int r = 0; r + 2 < R; ++r) {
            for (int c = 0; c < C; ++c) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r+1][c]) && v == Math.abs(board[r+2][c])) {
                    board[r][c] = board[r+1][c] = board[r+2][c] = -v;
                    todo = true;
                }
            }
        }

        for (int c = 0; c < C; ++c) {
            int wr = R - 1;
            for (int r = R-1; r >= 0; --r)
                if (board[r][c] > 0)
                    board[wr--][c] = board[r][c];
            while (wr >= 0)
                board[wr--][c] = 0;
        }

        return todo ? candyCrush(board) : board;
    }
	
	public static void main(String[] args) {
		
	}
}
