package z_Algo;

public class KnapSack {
	
	public KnapSack() {
		
	}
	
	public int limitedSupply(int[] v, int[] w, int lim) {
		
		int n = w.length;
		int m = v.length;
		
		int[][] table = new int[m+1][lim+1];
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= lim; j++) {
				
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				}
				else if(w[i-1] <= j) {
					
					table[i][j] = max (v[i-1]+table[i-1][j-w[i-1]], table[i-1][j]);
					
				}else {
					table[i][j] = table[i-1][j];
				}
			}
 		}
		
//		for (int i = 0; i <= n; i++) {
//			for (int j = 0; j <= lim; j++) {
//				
//				System.out.print(table[i][j]+" ");
//			}
//			System.out.println();
// 		}
		return table[m][lim];
	}
	
	public int max (int a, int b) {
		return (a>b)?a:b;
	}
	
}
