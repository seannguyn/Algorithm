package z_Algo;
import graph.*;
import sorting.*;
import dijkstra.*;

import java.util.*;

import Chapter4.*;
public class Test {

	public static void main(String[] args)  {
		
		System.out.println("==== Problem staircase ====");
		Staircase step = new Staircase();
		int res_0 = step.nStep(3);
		int res_1 = step.nStep_bottomUp(3);
		int res_2 = step.nStep_bottomUp(3, new int[] {1,2});
		System.out.println(res_0);
		System.out.println(res_1);
		System.out.println(res_2);
		
		System.out.println("==== Problem Max Increasing Subsequence Sum ====");
		MaxSubseqSum MaxSeqSum = new MaxSubseqSum();
		int MaxSum = MaxSeqSum.findMax(new int[] {1, 101, 2, 3, 100, 4, 5});
		System.out.println(MaxSum);
		
		System.out.println("==== Problem Roller Coaster ====");
		RollerCoaster rc = new RollerCoaster();
		int maxRide = rc.maxRide(new int[] {7,5,4,4}, new int[] {4,7,6,2}, 23);
		System.out.println(maxRide);
		
		System.out.println("==== Problem Common Element in 2 Array ====");
		CommonElem ce = new CommonElem();
		int common = ce.commonElem(new int[] {1,9}, new int[] {1,2,3,4,5,9});
		System.out.println("Common: "+common);
//		new int[] {1,2,3,4,5,6,7,8,9,10}
//		new int[] {1,3,4,6,7,9}
//		new int[]{1,2,4,5,9,10}
		
		
		System.out.println("==== Problem Most Occurring Element in Array ====");
		MostElem me = new MostElem();
		System.out.println("MOST: "+me.MostElem(new int[]{ 1, 5, 2, 1, 3, 2, 1 }));
		
		System.out.println("==== Problem KnapSack 0/1 ====");
		KnapSack ks = new KnapSack();
		int val = ks.limitedSupply(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50);
		System.out.println(val);
		
		// havent solved
		System.out.println("==== Problem Subset Sum ====");
		SubsetSum ss = new SubsetSum();
		System.out.println(ss.subsetSum(new int[] {1,2,3,4,5}, 10)); 
		
		System.out.println("==== Array Query ====");
		ArrayQuery aq = new ArrayQuery();
		aq.nQuery( new int[] { 1, 2, 3, 4, 9, 10, 11 ,12}, new int[] {2,9,3}, new int[] {5,13,11});
		System.out.println("-");
//		aq.nQueryUnsorted( new int[] { 1, 3, 4, 9, 10, 3 }, new int[] {1,9}, new int[] {4,12});
		aq.nQuerySmart( new int[] { 1, 2, 3, 4, 9, 10, 11 ,12}, new int[] {2,9,3}, new int[] {5,13,11});
		
		System.out.println("==== First recurring String ====");
		FirstRecurringString frs = new FirstRecurringString();
		frs.firstchar("bcaba");
		
		System.out.println("==== DFS ====");
		Graph g1 = new Graph(5);
		g1.addEgde(0, 2);
		g1.addEgde(0, 3);
		g1.addEgde(1, 0);
		g1.addEgde(2, 1);
		g1.addEgde(3, 4);
		g1.addEgde(4, 0);
		g1.DFS(0);
		
		System.out.println("==== BFS ====");
		Graph g2 = new Graph(4);
		g2.addEgde(0, 1);
	    g2.addEgde(0, 2);
	    g2.addEgde(1, 2);
	    g2.addEgde(2, 0);
	    g2.addEgde(2, 3);
	    g2.addEgde(3, 3);
		g2.BFS(2);
		
//		System.out.println("==== Topological Sort ====");
//		Graph g3 = new Graph(6);
//		g3.addEgde(2, 3);
//		g3.addEgde(3, 1);
//		g3.addEgde(4, 0);
//		g3.addEgde(4, 1);
//		g3.addEgde(5, 0);
//		g3.addEgde(5, 2);
//		
		
		
		
		System.out.println("==== Binary Search ====");
		BinarySearch bs = new BinarySearch();
		int res1 = bs.bsNextL(new int[] {0,2,4,5,6,8,10,11,12},3);
		int res4 = bs.bsNextS(new int[] { 1, 2, 3, 4, 9, 10, 11 ,12},5);
		int res2 = bs.bsNextS(new int[] {0,2,4,5,6,8,10,11,12},3);
		int res3 = bs.bs(new int[] {0,2,4,5,6,8,10,11,12},12);
		System.out.println(res4);
		System.out.println(res2);
		System.out.println(res3);
		
		System.out.println("==== KnapSack Unbound ====");
		KnapSackUnlimited ksu = new KnapSackUnlimited();
		ksu.knapSack(100, new int[] {5, 10, 15}, new int[] {10, 30, 20});
		
		
		System.out.println("==== MergeSort ====");
		MergeSort ms = new MergeSort();
		int[] array_1 = new int[] {15, 10, 5};
		int[] array_2 = new int[] {15, 10, 5};
		ms.mergeSort(array_1, 0, 2);
		
		for (int i = 0; i < array_1.length; i++) {
			System.out.print(array_1[i]+" ");
		}
		System.out.println();
		
		System.out.println(ms.mergeSort_inv(array_2, 0, 2)+" Inversion");
		
		System.out.println("==== Dijkstra algo ====");
		Graph_ g_ = new Graph_();
		g_.addNode("A");
		g_.addNode("B");
		g_.addNode("C");
		g_.addNode("D");
		g_.addNode("E");
		g_.addNode("F");
		g_.addNode("G");
		
		g_.addEdge("A", "B", 4);
		g_.addEdge("A", "C", 3);
		g_.addEdge("A", "E", 7);
		
		g_.addEdge("B", "A", 4);
		g_.addEdge("B", "C", 6);
		g_.addEdge("B", "D", 5);
		
		g_.addEdge("C", "A", 3);
		g_.addEdge("C", "B", 6);
		g_.addEdge("C", "D", 11);
		g_.addEdge("C", "E", 8);
		
		g_.addEdge("D", "B", 5);
		g_.addEdge("D", "C", 11);
		g_.addEdge("D", "E", 2);
		g_.addEdge("D", "F", 2);
		g_.addEdge("D", "G", 10);
		
		g_.addEdge("E", "C", 8);
		g_.addEdge("E", "G", 5);
		g_.addEdge("E", "A", 7);
		g_.addEdge("E", "D", 2);
		
		g_.addEdge("F", "D", 2);
		g_.addEdge("F", "G", 3);
		
		g_.addEdge("G", "F", 3);
		g_.addEdge("G", "D", 10);
		g_.addEdge("G", "E", 3);
		
//		g_.printNode();
		
		g_.dijkstra("A", "D");
		
		System.out.println("==== Longest increasing subsequence ====");
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		int res5 = lis.longest(new int[] { 10, 22, 9, 33, 21, 50, 41, 60 });
		System.out.println("result: "+res5);
		
		System.out.println("==== Bubble Sort ====");
		BubbleSort bbs = new BubbleSort();
		bbs.bubbleSort(new int[] { 10, 22, 9, 33, 21, 50, 41, 60 });
		
		System.out.println("==== Longest common subsequence ====");
		
		LongestCommonSubseq lcs = new LongestCommonSubseq();
		lcs.longest("AGGTAB", "GXTXAYB");
		
		System.out.println("==== QuickSort ====");
		QuickSort qs = new QuickSort();
		int [] qs_array = new int[] { 10, 22, 9, 33, 21, 50, 41, 60 };
		qs.quickSort(qs_array, 0, qs_array.length-1);
		
		for (int i = 0; i < qs_array.length; i++) {
			System.out.print(qs_array[i]+" ");
		}
		System.out.println();
		
		System.out.println("==== Rabin Karp ====");
		StringMatch_RK rk = new StringMatch_RK();
		rk.RabinKarp("geeksforgeeks", "geekl");
		
		System.out.println("==== Max without adjacent ====");
		MaxNoAdjacent mna = new MaxNoAdjacent();
		mna.maxNoAdjacent(new int[] {5, 5, 10, 100, 10, 5});
		
		System.out.println("==== Segment Tree ====");
		int[] input = new int[] {-1,2,4,0};
		int length = input.length;
//		for(int i = 0; i< 100; i++) {
//			if (length <= pow(2,i))
//		}
		
		System.out.println("==== Chapter 4 ====");
		BinaryTree bt = new BinaryTree(null);
		NodeBT n = bt.arrayToBST(new int[] {1, 2, 3,4,5,6,7,8},0,7);
		n.preorder(n);
		System.out.println();
		n.inorder(n);
		
		System.out.println();
		NodeBT node1 = new NodeBT(2);
		node1.insertion(node1,1);
		node1.insertion(node1,3);
		node1.insertion(node1,4);
		
		NodeBT node2 = new NodeBT(2);
		node2.right = new NodeBT(1);
		node2.left = new NodeBT(3);
		
				
		System.out.println(node1.isBalance(node1));
		
		LinkedList<Integer> ListLinked = new LinkedList<Integer>();
		
		System.out.println(n.isBST(n));
		
		System.out.println(n.isBST(node2));
		
		GraphTopo gTopo = new GraphTopo();
		gTopo.addNode("A");
		gTopo.addNode("B");
		gTopo.addNode("C");
		gTopo.addNode("D");
		gTopo.addNode("E");
		gTopo.addNode("F");
		gTopo.addNode("G");
		
		
		gTopo.addEdge("A", "E");
		gTopo.addEdge("B", "A");
		gTopo.addEdge("B", "E");
		gTopo.addEdge("C", "A");
		gTopo.addEdge("D", "G");
		gTopo.addEdge("F", "A");
		gTopo.addEdge("F", "B");
		gTopo.addEdge("F", "C");
		
		gTopo.topologicalSort();
		
	}
	
	
	
}
