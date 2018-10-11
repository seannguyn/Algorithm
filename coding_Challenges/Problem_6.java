package coding_Challenges;

import java.util.Arrays;

/*
 * implementation of knapsack
 */

public class Problem_6 {

	public Problem_6() {
		
	}
	
	public void knapsackLimited() {
		
	}
	
	public void knapsnackUnlimited(int w[], int v[], int limit) {
		int table[] = new int[limit+1];
		Arrays.fill(table, 0);
		
		for (int i = 0; i <= limit; i++) {
			for (int j = 0; j < w.length; j++) {
				if (i - w[j] >=0) {
					table[i] = max(table[i - w[j]] + v[j],table[i]);
				}
			}
		}
		
		System.out.println("max capacity: "+ table[limit]);
		
	}
	
	public int max(int a, int b) {
		return a > b ? a: b;
	}
	
public static void main(String args[]) {
		
		int val[] = {10, 30, 20}; 
		int wt[] = {5, 10, 15};
		int W = 100;
		
		Problem_6 p6 = new Problem_6();
		
		p6.knapsnackUnlimited(wt, val, W);
		
	}
	
}
