package z_Algo;

public class ArrayQuery {

	public ArrayQuery() {
		
	}
	
	/**
	 * 
	 * find element between low, and high inclusive 
	 * 
	 */
	
	public void nQuery(int[] arr, int[] low, int hig[]) {
		
		int []result = new int[low.length];
		
		for (int i = 0; i < low.length; i++) {
			
			int l_i;
			int h_i;
			// find index of low
			int j = 0;
			while (j < arr.length) {
				if (low[i] > arr[j]) j++;
				else break;
			}
			l_i = j;
			
			// find index of high
			j = 0;
			while (j < arr.length) {
				if (hig[i] >= arr[j])  j++;
				else break;
			}
			h_i = j;
			
			// compute answer, store in result
			result[i] = h_i - l_i;
			
		}
		
		for (int i : result) {
			System.out.println(i);
		}
		
	}
	
	public void nQueryUnsorted(int[] arr, int[] low, int hig[]) {
		int []result = new int[low.length];
		for (int i = 0; i < low.length; i++) {
			int j = 0;
			int count = 0;
			while (j < arr.length) {
				if (arr[j] >= low[i] && arr[j] <= hig[i]) count++;
				j++;
			}
			result[i] = count;
		}
		for (int i : result) {
			System.out.println(i);
		}
	}
	
	
	public int higIndex(int[] a, int x) {
		
		int l = 0;
		int h = a.length -1;
		while (h >= l) {
			int m = l + (h - l)/2;
			if (a[m] > x) {
				h = m - 1;
			}
			else if (a[m] < x) {
				l = m + 1;
			}
			else if (a[m] == x) {
				return m;
			}
		}
		return l;
		
	}
	
	public int lowIndex(int[] a, int x) {
		
		int l = 0;
		int h = a.length -1;
		while (h >= l) {
			int m = l + (h - l)/2;
			if (a[m] > x) {
				h = m - 1;
			}
			else if (a[m] < x) {
				l = m + 1;
			}
			else if (a[m] == x) {
				return m;
			}
		}
		
		return h;
	}
	
	public void nQuerySmart(int[] arr, int[] low, int hig[]) {
		
		/**
		 * for each query, find low, high index by binary search. 
		 * therefore n log n 
		 * 
		 */
		
		int[] res = new int[low.length];
		
		for (int i = 0; i < low.length; i++) {
			
			int lowIndex = higIndex(arr,low[i]);
			int higIndex = lowIndex(arr,hig[i]);
			
//			System.out.print(lowIndex+ " "+higIndex+" ");
			res[i] = higIndex - lowIndex +1;
			
		}
		
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		
	}
	
}
