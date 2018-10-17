package coding_Challenges;

import java.util.*;

public class Problem_9 {
	/*
	 * topological sort
	 * 
	 */
	
	Graph g;
	public Problem_9() {
		
	}
	
	class Graph {
		
		LinkedList<Integer> list[];
		int element;
		
		public Graph(int element) {
			this.list = new LinkedList[element];
			this.element = element;
			for (int i = 0; i < element; i++) {
				list[i] = new LinkedList();
			}
		}
		
		public void addEdge(int from, int to) {
			this.list[from].add(to);
		}
	}
	
	public void topologicalSort(Graph g) {
		
		Stack<Integer> stack = new Stack<>();
		
		boolean visited[] = new boolean[g.element];
		
		for (int i = 0; i < g.element; i++) {
			visited[i]= false;
		}
		
		for (int i = 0; i < g.element; i++) {
			if (visited[i] == false) {
				topoSortUtil(visited, stack, i, g);
			}
		}
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	public void topoSortUtil(boolean[] visited, Stack stack, int from, Graph g) {
		visited[from] = true;
		for (int e : g.list[from]) {
			if (!visited[e]) {
				topoSortUtil(visited, stack, e, g);
			}
		}
		stack.push(from);
	}
	
	public static void main(String args[]) {
		Problem_9 p9 = new Problem_9();
		p9.g = p9.new Graph(6);
		
		p9.g.addEdge(5, 2); 
		p9.g.addEdge(5, 0); 
		p9.g.addEdge(4, 0); 
		p9.g.addEdge(4, 1); 
		p9.g.addEdge(2, 3); 
		p9.g.addEdge(3, 1); 
		
		p9.topologicalSort(p9.g);
	}
}
