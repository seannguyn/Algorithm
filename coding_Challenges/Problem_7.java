package coding_Challenges;

import java.util.*;

public class Problem_7 {

	/*
	 *	Union by rank and path implementation 
	 */
	
	private HashMap<Integer,Node> map = new HashMap<>();
	
	private class Node {
		Node parent;
		int rank;
		int data;
		
		public Node (int data) {
			this.rank = 0;
			this.data = data;
			this.parent = this;
		}
	}
	/*
	 * init a set
	 */
	public void makeSet(int data) {
		Node n = new Node (data);
		map.put(data, n);
	}
	
	/*
	 * find the set that an element belongs to
	 */
	public int findSetInt(int nodeData) {
		return findSet(map.get(nodeData)).data;
	}
	
	public Node findSet(Node node) {
		
		if (node == node.parent) {
			return node.parent;
		}
		
		node.parent = findSet(node.parent);
		
		// path compression
		return node.parent;
	}
	
	/*
	 * union set, only increment rank if rank is equal
	 */
	public void union(int data1, int data2) {
		Node n1 = map.get(data1);
		Node n2 = map.get(data2);
		
		Node parent_n1 = findSet(n1);
		Node parent_n2 = findSet(n2);
		
		if (parent_n1 == parent_n2) {
			return;
		} else {
			if (parent_n1.rank >= parent_n2.rank) {
				
				// increment rank if they have same rank
				parent_n1.rank = parent_n1.rank == parent_n2.rank ? parent_n1.rank + 1 : parent_n1.rank;
				parent_n2.parent = parent_n1;
			} else {
				parent_n1.parent = parent_n2;
			}
		}
	}
	
	public static void main(String args[]) {
		
		Problem_7 p7 = new Problem_7();
		p7.makeSet(1);
		p7.makeSet(2);
		p7.makeSet(3);
		p7.makeSet(4);
		p7.makeSet(5);
		p7.makeSet(6);
		p7.makeSet(7);
		
		p7.union(1, 2);
		p7.union(2, 3);
		
		p7.union(5, 6);
		p7.union(5, 7);
		p7.union(7, 4);
		
		System.out.println(p7.findSetInt(3));
		System.out.println(p7.findSetInt(2));
		
		System.out.println(p7.findSetInt(5));
		System.out.println(p7.findSetInt(7));
		
		p7.union(4, 1);
		
		System.out.println(p7.findSetInt(4));
		
	}
}
