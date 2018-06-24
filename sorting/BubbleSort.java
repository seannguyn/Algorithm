package sorting;

public class BubbleSort {

	public BubbleSort() {
		
	}
	
	public void bubbleSort(int[] a) {
		
		int high = a.length - 1;
		
		for (int j = high; j >= 0;j--) {
			for (int i = 0; i < j-1; i++) {
				if (a[i]>a[i+1]) {
					a[i] = a[i+1] + a[i];
					a[i+1] = a[i] - a[i+1];
					a[i] = a[i] - a[i+1];
				}
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
	}
	
}
