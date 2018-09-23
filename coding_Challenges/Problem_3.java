package coding_Challenges;

import java.util.*;

/*
 * implement dynamic programming
 * 
 * Find the longest increasing subsequence 
 */

public class Problem_3 {
	
	public int[] array;
	
	public Problem_3(int[] array) {
		this.array = array;
	}
	
	public void solution() {
		HashMap table = new HashMap<Integer, List<Integer>>();
		
		
		
		for (int i = 0; i < this.array.length; i++) {
			List<Integer> init = new ArrayList<>();
			init.add(this.array[i]);
			table.put(this.array[i], init);
		}
		
		
		
		for (int i = 1; i < this.array.length; i++) {
			
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j]) {
					
					
					List<Integer> oldList = new ArrayList<Integer>((List)table.get(array[j]));
					oldList.add(array[i]);
					
					if (oldList.size() > ((List)table.get(array[i])).size()) {	
						table.put(array[i], oldList);
					}
					
				} else {
					List<Integer> it = new ArrayList<>();
					it.add(array[i]);
					table.put(this.array[i], it);
				}
			}
			
		}
		
		Iterator it = table.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " : "+pair.getValue());
	    }
		
	}
	
	public static void main (String args[]) {
		int[] arr = new int[] {3, 10, 2, 1, 20};
		
		Problem_3 p3 = new Problem_3(arr);
		p3.solution();
		
		System.out.println("================================");
		
		p3.array = new int[] {50, 3, 10, 7, 40, 80};
		p3.solution();
		
		System.out.println("================================");
		
		p3.array = new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		p3.solution();
		
		
	}

}
