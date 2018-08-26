
public class MatrixMaxPath {
/**
 * 
 * 
 * You are playing a game on an n × n grid of cells. Each cell contains a single
 
integer: the cell in row r, column c contains the integer A[r][c], where

A[1..n][1..n] is a two-dimensional array of integers. You start at the top-left

cell (1, 1) and will move to the bottom-right cell (n, n). At each step, you can

only move to the cell immediately below or to the right. Specifically, from cell

(r, c) you can move to (r + 1, c) or (r, c + 1) only. Your score is equal to the

sum of the integers among all cells you have passed through: you would like

to maximise this score.
 */
	
	public MatrixMaxPath() {
		
	}
	
	public void maxPath(int[][] a) {
		
		int row = a.length;
		int col = a[0].length;
		
		int[][] matrix = new int[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = 0;
			}
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 && j == 0) {
					matrix[i][j] = a[i][j];
				}
				else if (i == 0 || j == 0) {
					if (i == 0) {
						matrix[i][j] = a[i][j] + a[i][j-1];
					}
					else if (j == 0) {
						matrix[i][j] = a[i][j] + a[i-1][j];
					}
				}
				else {
//					matrix[i][j] = a[i][j] + max();
				}
			}
		}
		
	}
	
	public int max (int a, int b) {
		return (a>b)?a:b;
	}
	
}
