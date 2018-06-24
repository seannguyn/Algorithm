package z_Algo;

public class StringMatch_RK {

	public StringMatch_RK() {
		
	}
	
	public void RabinKarp(String s, String sub) {
		
		char[] x = s.toCharArray();
		char[] y = sub.toCharArray();
		
		int sub_mod = 0;
		for (int i = 0; i < y.length; i++) {
			sub_mod += y[i];
		}
		sub_mod = sub_mod % 997;
		
		int mod = 0;
		
		for (int i = 0; i < x.length - y.length; i++) {
			
			int count_1 = 0;
			int count_2 = 0;
			
			while (count_1 < y.length) {
				mod += x[i+count_1];
				count_1++;
			}
			
			if (mod % 997 == sub_mod) {
				for (int k = 0; k < y.length; k++) {
					if (x[i+k] == y[k]) count_2++;
				}
			}
			
			if (count_2 == y.length) {
				System.out.println("matched");
				return;
			}
			
		}
		
		System.out.println("not matched");
		return;
	}
	
}
