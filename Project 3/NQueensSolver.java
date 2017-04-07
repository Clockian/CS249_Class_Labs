
public class NQueensSolver implements INQueensSolver{
	
	@Override
	public boolean[][] nQueens(int n) {
		boolean[][] prior = new boolean[n][n];
		return nQueensRecursive(n, prior, 0, 0);
	}

	@Override
	public boolean[][] nQueensRecursive(int numQueens, boolean[][] prior, int row, int col) {
		// Check if a solution exists
		if (solveNQueens(numQueens, 0, prior, row, col) == false)
        {
            System.out.print("Solution does not exist");
            return null;
        }
        return prior;
	}
	
	public boolean solveNQueens(int numQueens, int curQueens, boolean[][] prior, int row, int col){
		// Base case, all Queens are placed
		if(curQueens == numQueens){
			return true;
		}
		
		// Check if Queen can be placed on board (row, col)
		if(check(numQueens, prior, row, col)){
			// If so, place Queen
			prior[row][col] = true;
			curQueens++;
			
			// Recur to place rest of Queens
			if(solveNQueens(numQueens, curQueens, prior, row, col)){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean check(int numQueens, boolean[][] prior, int row, int col){
		// Check row for any Queens
		for(int irow = 0; irow < prior.length; irow++){
			if(prior[irow][col] == true){
				return false;
			}
		}
		
		// Check col for any Queens
		for(int icol = 0; icol < prior.length; icol++){
            if (prior[row][icol] == true){
                return false;
            }
		}
 
        // Check upper diagonal on left side
		for(int jrow = row, jcol = col; jrow >= 0 && jcol >= 0; jrow--, jcol--){
            if(prior[jrow][jcol] == true){
                return false;
            }
		}
		
		// Check lower diagonal on right side
		for(int jrow = row, jcol = col; jrow < prior.length && jcol < prior.length; jrow++, jcol++){
            if(prior[jrow][jcol] == true){
                return false;
            }
		}
		
		// Check upper diagonal on right side
		for(int krow = row, kcol = col; krow >= 0 && kcol < prior.length; krow++, kcol--){
            if(prior[krow][kcol] == true){
                return false;
            }
		}
		
        // Check lower diagonal on left side
		for(int krow = row, kcol = col; krow < prior.length && kcol >= 0; krow--, kcol++){
            if(prior[krow][kcol] == true){
                return false;
            }
		}
 
        return true;
	}
	
	/*for(int ii = 0; ii < n; ii++){
	for(int jj = 0; jj < n; jj++){
		prior[ii][jj] = false;
	}
}*/
		/*	if (solveNQUtil(prior, numQueens, row, col) == false)
        {
            System.out.print("Solution does not exist");
            return null;
        }
 
        return prior;
	}*/
	
	/* A recursive utility function to solve N
    Queen problem */
	//public boolean solveNQUtil(boolean[][] prior, int numQueens, int row, int col)
	//{
     /* base case: If all queens are placed
        then return true */
		/*if (col >= numQueens)
         return true;

     /* Consider this column and try placing
        this queen in all rows one by one */
		/* for (int irow = 0; irow < numQueens; row++)
     {
         /* Check if queen can be placed on
            board[i][col] */
		/*  if (check(prior, numQueens, irow, col))
         {
             /* Place this queen in board[i][col] */
		/*   prior[irow][col] = true;

             /* recur to place rest of the queens */
		/*   if (solveNQUtil(prior, irow, row, col + 1) == true)
                 return true;

             /* If placing queen in board[i][col]
                doesn't lead to a solution then
                remove queen from board[i][col] */
		/*    prior[irow][col] = false; // BACKTRACK
         }
     }

     /* If queen can not be place in any row in
        this colum col, then return false */
		/* return false;
 }
	
	public boolean check(boolean[][] prior, int numQueens, int row, int col){
		
		/* Check this row on left side */
		/* for (int icol = 0; icol < col; icol++)
            if (prior[row][icol] == true)
                return false;
 
        /* Check upper diagonal on left side */
		/*  for (int irow = row, jcol = col; irow >= 0 && jcol >= 0; irow--, jcol--)
            if (prior[irow][jcol] == true)
                return false;
 
        /* Check lower diagonal on left side */
		/*  for (int irow = row, jcol = col; jcol >= 0 && irow < numQueens; irow++, jcol--)
            if (prior[irow][jcol] == true)
                return false;
 
        return true;
	}*/

}
