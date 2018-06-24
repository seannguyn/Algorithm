package z_Algo;

public class BinarySearch {

	public BinarySearch() {
		
	}
	
	/**
	 * binary search
	 * 
	 */
	
	public int bsNextL(int a[], int x) {
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
	
	public int bsNextS(int a[], int x) {
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
	
	public int bs(int a[], int x) {
		int l = 0;
		int h = a.length -1;
		while (h >= l) {
			int m = l + (h - l)/2;
			if (a[m] > x) {
				h = m -1;
			}
			else if (a[m] < x) {
				l = m + 1;
			}
			else if (a[m] == x) {
				return m;
			}
		}
		
		return -1;
	}
	
}
