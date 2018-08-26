package graph;
import java.util.*;

public class Graph<E> implements GraphI<E>{

	
	public Graph(int size) {
		this.adjNode = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			this.adjNode[i] = new LinkedList<>();
			this.numV=size;
		}
	}
	
	private LinkedList<Integer>[] adjNode;
	private int numV;
	
	@Override
	public void addEgde(int from, int to) {
		this.adjNode[from].add(to);
	}
	
	public void DFS(int source) {
		boolean[] visited = new boolean[numV];
		visited[source] = true;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		while (!stack.empty()) {
			
			int vertex = stack.peek();
			stack.pop();
			System.out.print(vertex +" ");
			visited[vertex] = true;
			
			for (int i : adjNode[vertex]) {
				if (!visited[i]) {
					stack.push(i);
				}
			}
			
		}
		System.out.println();
	}
	
	public void BFS(int source) {
		boolean[] visited = new boolean[numV];
		visited[source] = true;
		
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(source);
		
		while (!ll.isEmpty()) {
			
			int vertex = ll.removeFirst();
			visited[vertex] = true;
			System.out.print(vertex +" ");
			
			for (int v : adjNode[vertex]) {
				if (!visited[v]) ll.addLast(v);
			}
			
			
		}
		System.out.println();
		
	}
	
	public void DFS_0(int src, boolean[] visited, Stack<Integer> stack) {
		
		Stack<Integer> temp = new Stack<>();
		temp.push(src);
		
		boolean[] temp_visited = new boolean[visited.length];
		
		while (!temp.isEmpty()) {
			
			int current = temp.pop();
			visited[current] = true;
			
			for (int i : adjNode[current]) {
				if (!visited[i]) {
					stack.push(i);
				}
			}
			
			if (visited[current]) {
				
			}
		}
	}
	
	public void TopologicalSort() {
		
	}
	
	/**
	 * create graph, hash<Node,HashSet<Node>>
	 * 
	 * create node
	 * 
	 * visited = hash
	 * dist = hash
	 * 
	 * n = pop from queue, add to visited
	 * 
	 * hash.get(n) = hashset
	 * 
	 * foreach node in the hashset, recalculate the distance
	 * 
	 * 
	 */
	
}
