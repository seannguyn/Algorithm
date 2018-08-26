package Chapter4;

import java.util.*;

public class NodeBT {

	public NodeBT left;
	public NodeBT right;
	public NodeBT nextRight;
	public int data;
	
	public NodeBT(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.nextRight = null;
	}
	
	public void preorder(NodeBT n) {
		if (n == null) {
			return;
		}
		System.out.print(n.data+" ");
		preorder(n.left);
		preorder(n.right);
		
		
	}
	
	public void inorder(NodeBT n) {
		if (n == null) {
			return;
		}
		inorder(n.left);
		System.out.print(n.data+" ");
		inorder(n.right);
		
		
	}
	
	public NodeBT insertion(NodeBT root, int data) {
		
		if (root == null) {
			root = new NodeBT(data);
			return root;
		}
		
		if (root.data > data) {
			root.left = insertion(root.left,data);
		}
		else if (root.data < data) {
			root.right = insertion(root.right,data);
		}
		return root;
	}
	
	public int height(NodeBT root) {
		if (root == null) {
			return 0;
		}
		
		return 1 + max(height(root.left),height(root.right)); 
	}
	
	public int max(int a, int b) {
		return (a>b)? a:b;
	}
	
	public boolean isBalance(NodeBT root) {
		
		if (root == null) {
			return true;
		}
		
		int ls = height(root.left);
		int rs = height(root.right);
		
		if (abs(ls - rs) <= 1 && isBalance(root.left) && isBalance(root.right)) {
			return true;
		}
		return false;
	}
	
	public int abs(int a) {
		return a < 0 ? -a:a;
	}
	
	public void inorderL(NodeBT node, LinkedList<Integer> linked) {
		if (node == null) {
			return;
		}
		inorderL(node.left,linked);
		linked.add(node.data);
		inorderL(node.right,linked);
	}
	
	public boolean isBST(NodeBT root) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		inorderL(root,linkedList);
		
		int head = linkedList.poll();
		
		while (!linkedList.isEmpty()) {
			int elem = linkedList.poll();
			if (head > elem) {
				return false;
			}
			head = elem;
		}
		return true;
		
	}
	
}
