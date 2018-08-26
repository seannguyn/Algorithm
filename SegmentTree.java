
public class SegmentTree {
	/**
	 * build: O(n)
	 * maintain: O(n) space
	 * operation: O(log n)
	 * 
	 * Segment tree is a binary tree
	 * Element of the array will be the leaf of the binary tree
	 * 
	 * length of the tree is: (length of close to power of 2 ) * 2 - 1
	 * 
	 * for example if array length is 4, then segmen tree is 4*2-1
	 * 
	 * for example if array length is 5, find the next value that is a power of 2 which is 8
	 * ,then segmen tree is 8*2-1
	 * 
	 * 
	 * 3 cases:
	 * total overlap: (if tree range is inside query range) return
	 * partial overlap: search both branch
	 * no overlap: search both branch
	 * 
	 * low index: 2i + 1
	 * hig index: 2i + 2
	 * parent: (i-1)/2 
	 * 
	 * conceptual tree looks like a binary tree
	 * actual tree is store in an array where the length is described above 
	 * 
	 * 
	 */
	
	public void construct(int[] array, int[] st, int low, int high, int pos) {
		if (low == high) {
			st[pos] = array[low];
			return;
		}
		int mid = low + (high - low) / 2;
		
		construct(array,st,low,mid,2*pos+1);
		construct(array,st,mid+1,high,2*pos+2);
		
		st[pos] = min(st[pos*2+1],st[pos*2+2]);
	}
	
	public int min(int a,int b) {
		return (a>b)?b:a;
	}
	
}
