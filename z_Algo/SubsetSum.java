package z_Algo;

public class SubsetSum {

	public SubsetSum() {
		
	}
	
	/**
	 * 
	 * find all the sum
	 * 
	 */
	
	public int subsetSum(int a[], int sum) {
		
		int m = a.length;
		int count = 0;
		
		int [][] table = new int [m+1][sum+1];
		
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= sum; j++) {
				if (i==0 || j ==0) {
					table[i][j] = 0;
				}
				else if (a[i-1] <= j) {
					int temp = a[i-1] + table[i-1][j-a[i-1]];
					table[i][j] = max(temp,table[i][j-1]);
					if (temp == sum) count++;
				}
				else {
					table[i][j] = table[i][j-1];
				}
			}
		}
		
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= sum; j++) {	
				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}
		
		return count;
	}
	
	public int max (int a, int b) {
		return (a>b)?a:b;
	}
	
}
