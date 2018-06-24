package z_Algo;
import java.util.*;

public class FirstRecurringString {
	public FirstRecurringString() {
		
	}
	
	/**
	 * 
	 * find the first occurring char in the string 
	 */
	
	public void firstchar(String s) {
		
		HashMap<Character, Integer> h = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (h.get(c) == null) {
				h.put(c, 1);
			}
			else {
				int count = h.get(c);
				System.out.println(c);
				break;
			}
		}
		
		
	}
}
