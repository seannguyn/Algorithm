package coding_Challenges;

import java.util.*;

/*
 * Given an array of integer, count the number of occurrences of each element
 */

public class Problem_1 {
	
	

	Problem_1(int arr[]) {
		this.arr = arr;
	}
	private int[] arr;
	
	public void solution() {
		HashMap hm = new HashMap<Integer, Integer>();
		int[] max = new int[] {0,0};
		for (int i = 0; i < this.arr.length; i++) {
			int count = 0;
			if (hm.get(arr[i]) == null) {
				hm.put(arr[i], 1);
			}
			else {
				count = (int) hm.get(arr[i]);
				count += 1;
				hm.put(arr[i], count);
			}
			if (count > max[1]) {
				max[1] = count;
				max[0] = arr[i];
			}
		}
		
		System.out.println(hm.keySet());
		
		Iterator it = hm.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	    
	    System.out.println(max[0]+" has the maximum occurrence with: "+max[1]);
	    
 	}
	
	public static void main(String args[]) {
		Problem_1 p = new Problem_1(new int[] {1, 1, 2, 2, 2, 2, 3,4,4,4,5,5,5,10,14} );
		p.solution();
	}
	
}
