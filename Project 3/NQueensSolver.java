/*
 * Created by Jasque Saydyk
 * Project 03 - Recursion
 * CS 249
 * 10 April 2017
 * Description - This program unsuccessfully solves the N-Queens problem with recursion.
 * It does use recursion to attempt to solve the problem, but it any test beyond maybe 3 Queens
 * Why does it fail? Well, if I could answer that, I probably would have been able to do this assignment correctly.
*/
public class NQueensSolver implements INQueensSolver{
	@Override
	public boolean[][] nQueens(int n) {
		boolean[][] prior = new boolean[n][n];
		
		// Load array with default value of false
		for(int ii = 0; ii < prior.length; ii++){
			for(int jj = 0; jj < prior.length; jj++){
				prior[ii][jj] = false;
			}
		}
		return nQueensRecursive(n, prior, 0, 0);
	}

	@Override
	public boolean[][] nQueensRecursive(int numQueens, boolean[][] prior, int row, int col) {
		// Check if a solution exists
		return solveNQueens(numQueens, 0, prior, row, col);
	}
	
	public boolean[][] solveNQueens(int numQueens, int curQueens, boolean[][] prior, int row, int col){
		// Base case, all Queens are placed
		if(curQueens == numQueens){
			return prior;
		}
		// Check if Queen can be placed on board in any of the slots on the row
		if(check(prior, row, col++)){
			// If so, place the Queen
			prior[row][col] = true;
			curQueens++;
			
			// Recur to place rest of Queens on the next row
			solveNQueens(numQueens, curQueens, prior, row++, 0);
		
			// If placing a Queen on the board doesn't lead to a solution then remove the Queen
	        prior[row][col] = false;
	        curQueens--;
		}
		// Else go to next row if run out of columns?
		
		// If queen can not be place in any row in this col, then end?
		return prior;
	}
	
	public boolean check(boolean[][] prior, int row, int col){
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
		for(int krow = row, kcol = col; krow >= 0 && kcol < prior.length; krow--, kcol++){
            if(prior[krow][kcol] == true){
                return false;
            }
		}
		
        // Check lower diagonal on left side
		for(int krow = row, kcol = col; krow < prior.length && kcol >= 0; krow++, kcol--){
            if(prior[krow][kcol] == true){
                return false;
            }
		}
 
        return true;
	}
}