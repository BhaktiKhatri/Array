package Array;

public class BattleshipsInABoard {
	
	/* A utility function to print a 2D matrix */
    public static void printMatrix(char matrix[][])
    {
        int i, j;
        for (i=0; i<matrix.length; i++)
        {
            for(j=0; j<matrix[0].length; j++)
            {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

	public static int countBattleships(char[][] board) {
        if(board == null) {
            return 0;
        }
        
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        
        System.out.println("m: "+m+" n: "+n);
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
            	System.out.println("i: "+i+" j: "+j+" board[i][j]: "+board[i][j]+" count: "+count);
            	
                if(board[i][j] == '.') {
                    continue;
                }
                
                if(i > 0 && board[i-1][j] == 'X') {
                    continue;
                }
                
                if(j > 0 && board[i][j-1] == 'X') {
                    continue;
                }
                
                count++;
            }
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		char[][] board = {
							{'X','.','.','X'},
							{'.','.','.','X'},
							{'.','.','.','X'}
						};
		
		printMatrix(board);
		System.out.println(countBattleships(board));
	}

}
