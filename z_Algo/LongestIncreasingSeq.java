package z_Algo;

public class LongestIncreasingSeq {

	public LongestIncreasingSeq() {
		
	}
	
	/**
	 * 
	 * dynamic programming: find the longest increasing subsequence
	 */
	
	public int longest(int[] a) {
		
		int[] table = new int[a.length];
		
		for (int i = 0; i< table.length; i++) {
			table[i] = 1;
		}
		
		for (int i = 0;i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && table[i] < table[j] + 1) {
					table[i] = table[j] + 1;
				}
			}
		}
		
		int max=0;
		
		for (int i = 0; i < table.length; i++) {
			if (max < table[i]) {
				max = table[i];
			}
		}
		
		return max;
	}
	
}
