package coding_Challenges;

public class Problem_11 {
	
	/*
	 * dynamic programming, count the longest common subsequence
	 */
	
	public Problem_11() {
		
	}
	
	public void solution(String a, String b) {
		
		int len_a = a.length();
		int len_b = b.length();
		
		String char_a[] = a.split("");
		String char_b[] = b.split("");
		
		int table[][] = new int[len_a+1][len_b+1];
		for (int i = 0; i <= len_b; i++) {
			table[0][i] = 0;
		}
		for (int i = 0; i <= len_a; i++) {
			table[i][0] = 0;
		}
		
		for (int i = 1; i <= len_a; i++) {
			for (int j = 1; j <= len_b; j++) {
				if (char_a[i-1].equals(char_b[j-1])) {
					table[i][j] = table[i-1][j-1] + 1;
				} else {
					table[i][j] = max(table[i-1][j],table[i][j-1]);
				}
			}
		}
		
		for (int i = 1; i <= len_a; i++) {
			for (int j = 1; j <= len_b; j++) {
				System.out.print(table[i][j]+",");
			}
			System.out.println();
		}
		System.out.println("..."+table[len_a][len_b]+"...");
	}
	
	public int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static void main (String args[]) {
		Problem_11 p11 = new Problem_11();
		p11.solution("ABCDGH", "AEDFHR");
		p11.solution("AGGTAB", "GXTXAYB");
	}
	
}
