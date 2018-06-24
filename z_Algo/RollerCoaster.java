package z_Algo;

/*
 * At a certain theme park there are n rides, numbered from
	1 to n. Before you can go on ride i you must pay its cost C[i] dollars, plus a
	deposit, D[i] dollars. This means you must have at least C[i] + D[i] dollars to
	go on the ride. Once you have finished the ride, D[i] dollars are returned to
	you, as long as you did not damage the ride!
	
	Careful Cheryl never damages any rides, and currently has T dollars on her.
	Cheryl would like to know the maximum number of different rides she can go
	on. She can go on rides in any order she chooses.
	
	You may assume C[1..n] and D[1..n] are both positive integer arrays of length n
	
	design an O(n log n + nT) algorithm to determine the
maximum number of different rides Cheryl can go on.
 */


public class RollerCoaster {
	public RollerCoaster() {
		
	}
	
	public int maxRide(int[] D, int[] C, int T) {
		
		int nD = D.length;
		
		int [][] lookup = new int[nD+1][T+1];
		int amount_spend = 0;
		
		for (int i = 0; i <= nD; i++) {
			for (int j = 0; j <= T; j++) {
				
				if (i == 0 || j == 0) {
					lookup[i][j] = 0;
					
				}
				
				else if (amount_spend + D[i-1] + C[i-1] <= j) {
					lookup[i][j] = lookup[i-1][j] + 1;
				}
				
				else if (amount_spend + D[i-1] + C[i-1] > j){
					lookup[i][j] = lookup[i-1][j];
				}
			}
			
			if (i != 0) {
				amount_spend += C[i-1];
			}
			
		}
		
//		for (int i = 0; i <= nD; i++) {
//			for (int j = 0; j <= T; j++) {
//				System.out.print(lookup[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		return lookup[nD][T];
	}
	
}
