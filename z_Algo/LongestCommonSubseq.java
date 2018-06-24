package z_Algo;

public class LongestCommonSubseq {

	public LongestCommonSubseq() {
		
	}
	
	/**
	 * build a table 2D, row is string1, col is string 2
	 * 
	 * if (i==0 || j ==0): table[i][j] = 0
	 * 
	 * if string1[i] == string2[j]: 1 + table[i-1][j-1]
	 * 
	 * else max(table[i-1][j],table[i][j-1])
	 * 
	 * 
	 * 
	 * @return
	 */
	
	public int longest(String x, String y) {
		
		char[] a = x.toCharArray();
		char[] b = y.toCharArray();
		
		int m = a.length;
		int n = b.length;
		
		int[][] table = new int[m+1][n+1];
		
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				} else if(a[i-1] == b[j-1]) {
					table[i][j] = 1 + table[i-1][j-1];
				} else {
					table[i][j] = (table[i-1][j] > table[i][j-1]) ? table[i-1][j] : table[i][j-1];
				}
			}
		}
		
		System.out.println(x + " " +y + " " + table[m][n]);
		
		// traceback 
		
		return table[m][n];
	}
}
