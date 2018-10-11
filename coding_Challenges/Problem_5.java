package coding_Challenges;
import java.util.*;

/*
 * Recursive stair case problem
 */

public class Problem_5 {

	public Problem_5() {
		
	}
	
	public void solutions(int rules[], int stairs) {
		int table[] = new int[stairs+1];
		Arrays.fill(table, 0);
		table[0] = 1;
		
		for (int i = 1; i < table.length; i++) {
			for (int j = 0; j < rules.length; j++) {
				if (i - rules[j]>= 0) {
					table[i] += table[i - rules[j]];
				}
			}
		}
		
		System.out.println(table[stairs]+" ways!!");
	}
	
	public static void main(String args[]) {
		
		int rules[] = {1,2};
		int stairs = 4;
		
		Problem_5 p5 = new Problem_5();
		
		p5.solutions(rules, stairs);
		
	}
	
}
