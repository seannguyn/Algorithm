package z_Algo;

public class MaxNoAdjacent {

	public MaxNoAdjacent() {
		
	}
	
	/**
	 * 
	 * find max such that no item are adjacent to each other 
	 */
	
	public void maxNoAdjacent(int[] a) {
		
		int include=0;
		int exclude=0;
		
		int old_include = a[0];
		int old_exclude=0;
		
		for (int i = 1; i < a.length; i++) {
			include = old_exclude + a[i];
			exclude = max(old_include,old_exclude);
			
			old_exclude = exclude;
			old_include = include;
		}
		
		
		System.out.println(max(old_include,old_exclude));
		
	}
	
	public int max (int a, int b) {
		return (a>b)?a:b;
	}
	
}
