package sorting;

public class MergeSort {

	public MergeSort() {
		
	}
	public int mergeSort_inv(int[] a, int l, int r) {
		
		int inv = 0;
		
		if (l < r) {
			int m =(r-l ) / 2;
			
			inv += mergeSort_inv(a,l,m);
			inv += mergeSort_inv(a,m+1,r);
			
			inv += merge_inv(a,l,m,r);
			
		}
		
		return inv;
		
	}
	
	public int merge_inv(int[] arr, int l, int m, int r) {
		
		int inv = 0;
		
		int[] n1 = new int[m-l+1];
		int[] n2 = new int[r-m];
		
		for (int i = 0; i < n1.length; i++) {
			n1[i] = arr[l+i];
		}
		for (int i = 0; i < n2.length; i++) {
			n2[i] = arr[m+1+i];
		}
		
		int i = 0;
		int j = 0;
		int k = l;
		
		while (i < n1.length && j < n2.length) {
			if (n1[i] <= n2[j]) {
				arr[k] = n1[i];
				i++;
			}
			else {
				inv += m - l +1;
				arr[k] = n2[j];
				j++;
			}
			k++;
		}
		
		while (i < n1.length) {
			arr[k] = n1[i];
			i++;
			k++;
		}
		while (j < n2.length) {
			arr[k] = n2[j];
			j++;
			k++;
		}
		
		return inv;
		
	}

	public void mergeSort(int[] a, int l, int r) {
		
		if (l < r ) {
			int m = l+(r - l)/2;
			mergeSort(a,l,m);
			mergeSort(a,m+1,r);
			
			merge(a,l,m,r);
			
		}
		
	}
	
	public void merge(int[] arr, int l, int m, int r) {
		
		int[] n1 = new int[m-l+1];
		int[] n2 = new int[r-m];
		
		for (int i = 0; i < n1.length;i++) {
			n1[i] = arr[l+i];
		}
		
		for (int i = 0; i < n2.length;i++) {
			n2[i] = arr[m+1+i];
		}
		
		int i = 0;
		int j = 0;
		int k = l;
		
		while (i<n1.length && j<n2.length) {
			if (n1[i] <= n2[j]) {
				arr[k] = n1[i];
				i++;
			} else {
				arr[k] = n2[j];
				j++;
			}
			k++;
		}
		
		while (i < n1.length) {
			arr[k] = n1[i];
			i++;
			k++;
		}
		
		while (j < n2.length) {
			arr[k] = n2[j];
			j++;
			k++;
		}
		
	}

}
