package z_Algo;

public class Staircase {

	public Staircase() {
		
	}
	
	public int nStep(int n) {
		
		if (n <= 1) return 1;
		return nStep(n-1) + nStep(n-2);
	}
	
	public int nStep_bottomUp(int n) {
		int[] r = new int[n+1];
		
		r[0] = 1;
		r[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			r[i] = r[i-1] + r[i-2];
		}
		
		return r[n];
	}
	
	public int nStep_bottomUp(int n, int[] a) {
		
		if (n == 0) return 1;
		
		int[] r = new int[n+1];
		
		r[0] = 1;
		
		
		for(int i = 1; i <= n; i++) {
			int total = 0;
			for (int j = 0; j <a.length; j++) {
				if (i - a[j] >= 0) {
					total = total + r[i-a[j]];
				}
			}
			r[i] = total;
		}
		
		return r[n];
	}
	
}
