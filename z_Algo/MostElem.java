package z_Algo;
import java.util.*;

public class MostElem {
	
	public MostElem() {
		
	}
	
	/**
	 * find the most occurring element in an array
	 * 
	 */
	
	public int MostElem(int a[]) {
		
		
		
		Map <Integer, Integer> occur = new HashMap<>();
		for (int i = 0; i<a.length;i++) {
			if (occur.get(a[i])!=null) {
				int oc = occur.get(a[i]);
				oc++;
				occur.put(a[i], oc);
			}
			else {
				occur.put(a[i], 0);
			}
		}
		int max = 0;
		int value = 0;
		for (int key: occur.keySet()) {
			if (occur.get(key)>max) {
				max = occur.get(key);
				value = key;
			}
		}
		
		return value;
	}

}
