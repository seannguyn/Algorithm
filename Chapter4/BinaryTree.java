package Chapter4;

public class BinaryTree {

	public BinaryTree(NodeBT root) {
		this.root = root;
	}
	NodeBT root;
	
	public NodeBT arrayToBST(int[] array,int l, int r) {
		
		if (l <= r) {
			int mid = (r + l) / 2; 
			NodeBT n = new NodeBT(array[mid]);
			n.left = arrayToBST(array,l,mid-1);
			n.right = arrayToBST(array,mid+1,r);
			
			return n;
		}
		
		return null;
		
	}
	
	
	
}
