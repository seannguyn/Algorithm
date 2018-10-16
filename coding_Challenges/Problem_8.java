package coding_Challenges;

import java.util.Stack;

public class Problem_8 {
	
	/*
	 * Find total shape
	 * 
	 * https://practice.geeksforgeeks.org/problems/x-total-shapes/0
	 */
	
	public Problem_8() {
		
	}
	
	class IntPair {
	  final int x;
	  final int y;
	  IntPair(int x, int y) {this.x=x;this.y=y;}
	}
	
	public void solution(String[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int shapes = 0;
		
		// init visited matrix;
		boolean[][] visited = new boolean[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				visited[i][j] = false;
			}
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(matrix[i][j].equals("X") && visited[i][j] == false) {
					DFS(matrix,i,j,visited);
					shapes+=1;
				}
			}
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("shapes: "+shapes);
		
		
	}
	
	public void DFS(String[][] matrix, int x,int y, boolean visited[][]) {
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		Stack<IntPair> stack = new Stack<>();
		IntPair init = new IntPair(x,y);
		
		stack.push(init);
		
		while (!stack.isEmpty()) {
			
			IntPair current = stack.pop();
			visited[current.x][current.y] = true;
			
			if (current.x + 1 < row && matrix[current.x + 1][current.y].equals("X") && visited[current.x + 1][current.y]==false){
				IntPair down = new IntPair(current.x + 1,current.y);
				stack.push(down);
			}
			if (current.x - 1 >= 0  && matrix[current.x - 1][current.y].equals("X") && visited[current.x - 1][current.y]==false) {
				IntPair up = new IntPair(current.x - 1,current.y);
				stack.push(up);
			}
			if (current.y + 1 < col && matrix[current.x][current.y + 1].equals("X") && visited[current.x][current.y + 1]==false) {
				IntPair right = new IntPair(current.x,current.y + 1);
				stack.push(right);
			}
			if (current.y - 1 >= 0  && matrix[current.x][current.y - 1].equals("X") && visited[current.x][current.y - 1]==false) {
				IntPair left = new IntPair(current.x,current.y - 1);
				stack.push(left);
			}
		}
	}
	
	public String[][] scanLine(int row, int col, String string) {
		
		String[] charList = string.split("");
		
		String[][] res = new String[row][col];
		
		int rowCounter = 0; 
		int colCounter = 0;
		
		for (int i = 0; i < charList.length; i++) {
			if (!charList[i].equals(" ")) {
				res[rowCounter][colCounter] = charList[i];
				colCounter++;
			}
			else {
				rowCounter++;
				colCounter = 0;
			}
		}
		
		return res;
	}
	
	public static void main (String args[]) {
		
		Problem_8 p8 = new Problem_8();
		System.out.println();
		System.out.println("TEST 1");
		String s1 = "OOOOXXO OXOXOOX XXXXOXO OXXXOOO";
		int row1 = 4, col1 = 7;
		String [][]matrix1 = p8.scanLine(row1, col1, s1);
		p8.solution(matrix1);
		
		System.out.println();
		System.out.println("TEST 2");
		String s2 = "OOOXOOO OXXXXXO OXOOOXO";
		int row2 = 3, col2 = 7;
		String [][]matrix2 = p8.scanLine(row2, col2, s2);
		p8.solution(matrix2);
		
		System.out.println();
		System.out.println("TEST 3");
		String s3 = "XXO OOX OXO OOO XOX XOX OXO XXO XXX OOO";
		int row3 = 10, col3 = 3;
		String [][]matrix3 = p8.scanLine(row3, col3, s3);
		p8.solution(matrix3);
	}

}
