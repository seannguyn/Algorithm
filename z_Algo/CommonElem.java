package z_Algo;

public class CommonElem {
	
	public CommonElem() {
		
	}
	
	/**
	 * 
	 * find common element between 2 array
	 * 
	 */
	
	public int commonElem(int a[], int b[]) {
		
		int i = 0;
		int j = 0;
		
		int count = 0;
		
		while (i < a.length && j < b.length)
		  {
		    if (a[i] < b[j])
		       i++;
		    else if (b[j] < a[i])
		       j++;
		    else /* if arr1[i] == arr2[j] */
		    {
		       count++;
		       i++;
		       j++;
		    }
		  }
		
//		while (i < a.length || j < b.length) {
//			if (a[i] >= b[j]) {
//				if(a[i] == b[j]) {
//					count++;
//					
//					i = (i+1 < a.length) ? i+1:i;
//					j = (j+1 < b.length) ? j+1:j;
////					System.out.println("i: "+i+" j: "+j );
//				}
//				else if (a[i] > b[j]) {
//					if (j+1==b.length) break;
//					j++;
//				}
//			}
//			else if (a[i] < b[j]){
//				if (i+1==b.length) break;
//				i++;
//			}
//			
//			if ((i+1==a.length) && (j+1==b.length)) break;
//		}
		
		return count;
	}

}
