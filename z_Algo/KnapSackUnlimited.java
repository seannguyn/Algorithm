package z_Algo;

public class KnapSackUnlimited {

	public KnapSackUnlimited() {
		
	}
	
	public void knapSack(int W, int[] w, int[] v) {
		
		int[] table = new int[W+1];
		
		for (int i = 0; i <= W; i++) {
			table[i] = 0;
		}
		
		for (int i = 1; i <= W; i++) {
			for (int j = 0; j < w.length; j++) {
				if (i - w[j] >= 0) {
					table[i] = max(table[i],table[i - w[j]] + v[j]);
				}
			}
		}
		
		System.out.println("max capacity: "+table[W]);
		
	}
	
	public int max(int a, int b) {
		return (a >= b) ? a:b;
	}
	
}
