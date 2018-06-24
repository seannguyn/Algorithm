package sorting;

public class QuickSort {

	public QuickSort() {
		
	}
	
	public void quickSort(int[] a, int l, int r)
	{
		if (l < r) {
			
			int m = l + (r-l)/2;
			
			int i = l; int j = r;
			
			while (i <= j) {
				
				while (a[i] < a[m]) i++;
				while (a[j] > a[m]) j--;
				
				if (i <= j) {
					
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					
					i++;
					j--;
				}
				
			}
			
			if(l<j) quickSort(a,l,j);
			if(i<r) quickSort(a,i,r);
			
		} else {
			return;
		}
	}
}
