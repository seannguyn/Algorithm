package coding_Challenges;

/*
 * 		Problem statement:
 * 
 *  		Given an array of positive integers S and a window size k, 
 *		what is the largest sum possible of a contiguous subsequence (a window) 
 * 		with exactly k elements?
 * 
 */

public class Problem_12 {
	
	public Problem_12() {
		
	}
	
	public static void solution(int array[], int k) {
		// compute the sum for first k elements
		int sum = 0;
		
		for (int i = 0; i < k; i++) {
			sum += array[i];
		}
		int max = sum;
		
		// minus array[i-k] + array[i]
		for (int i = k; i < array.length; i++) {
			int newSum = sum - array[i-k] + array[i];
			max = max > newSum ? max : newSum;		
			sum = newSum;
		}
		System.out.println("output: max = "+max);
	}
	
	public static void main (String args[]) {
		System.out.println("TEST 1:");
		System.out.println("expected: max = 3 ");
		int array_1[] = {-2, -3, 4, -1, -2, 1, 5, -3}; 
		int k_1 = 4;
		solution(array_1, k_1);
	}
}
