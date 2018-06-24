package z_Algo;

public class MaxSubseqSum {

	public MaxSubseqSum () {
		
	}
	
	public int findMax(int a[]) {
		int length = a.length;
		int[] table = new int[length];
		
		// initialise value in table
		
		for (int i = 0; i < length; i++) {
			table[i] = a[i];
		}
		
		/*
		 * Find the max value
		 * for i -> length, 
		 * 	for j=0 -> i
		 * 		if a[i] > a[j] && table[i] < table[j] + a[i]
		 * 			table[i] = table[j] + a[i]
		 * 
		 * 
		 */
		
		for (int i = 1; i < length; i++) {
			
			for (int j = 0; j < i; j++) {
				
				if (a[i] > a[j] && table[i] < table[j] + a[i]) {
					table[i] = table[j] + a[i];
				}
				
			}
		}
		
		int max = table[0];
		
		for (int i = 1; i < table.length; i++) {
			if (table[i] > max) max = table[i];
		}
		
		return max;
	}
	
}
