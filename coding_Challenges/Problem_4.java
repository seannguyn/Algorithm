package coding_Challenges;
import java.util.*;

/*
 * return all the pair that add up to a number in an array
 */

public class Problem_4 {
	
	private int[] array;

	public Problem_4(int array[]) {
		this.array = array;
	}
	
	public void printPair(int num) {
		HashMap hash = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < this.array.length; i++) {
			int diff = num - array[i];
			
			if (hash.get(diff) != null) {
				System.out.println(array[i]+" "+diff);
			}
			hash.put(array[i], i);
		}
	}
	
	public static void main (String args[]) {
		int arr[] = {1,2,3,4,5,6,7,8,9,0};
		
		Problem_4 p4 = new Problem_4(arr);
		p4.printPair(7);
		
		
	}
	
}
