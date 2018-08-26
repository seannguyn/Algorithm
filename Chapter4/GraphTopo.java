package Chapter4;
import java.util.*;
public class GraphTopo {

	/**
	 * the DFS topological sort is imlement as follow
	 * 
	 * public void DFS(int src, boolean[] visited, Stack<> stack) {
	 * 
	 * 		visited[src]= true;
	 * 
	 * 		for each adjacent node (i) of src {
	 * 			if (!visited[i]) {
	 * 				DFS(i,visited,stack);
	 * 			}
	 * 		}
	 * 
	 * 		// Push current vertex to stack which stores result
     *   		stack.push(new Integer(v));
     *  
	 * 
	 * }
	 * 
	 * 
	 * public void topologicalSort() {
	 * 
	 * 		boolean[] visited = new boolean[size];
	 * 		Stack<> stack = new Stack;
	 * 
	 * 		for (int i = 0; i < size; i++) {
	 * 
	 * 			// initialise visited array
	 * 			visited[i] = false
	 * 			
	 * 		}
	 * 
	 * 		for (int i = 0; i < size; i++) {
	 * 		
	 * 			if (!visited[i]) DFS(i,visited,stack);
	 * 
	 * 		}
	 * 
	 * 		// Print contents of stack
        		while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
	 * 
	 * }
	 * 
	 */
	
	public GraphTopo() {
		nodeList = new HashMap<>();
	}
	public HashMap<String,NodeTopo> nodeList;
	
	public void addNode(String name) {
		nodeList.put(name,new NodeTopo(name));
	}
	
	public void addEdge(String from, String to) {
		NodeTopo n_from = nodeList.get(from);
		NodeTopo n_to = nodeList.get(to);
		
		n_from.outgoing.add(n_to);
		n_to.incoming.add(n_from);
	}
	
	public void topologicalSort() {
		
		Queue<NodeTopo> q = new LinkedList<NodeTopo>();
		while (q.size() != nodeList.size()) {
			for (String name : nodeList.keySet()) {
				
				NodeTopo current = nodeList.get(name);
				
				if (current.incoming.isEmpty() && !q.contains(current) ) {
					q.add(current);
					for (NodeTopo n : current.outgoing) {
						n.incoming.remove(current);
					}
				}
			}
		}
		
		
		while (!q.isEmpty()) {
			NodeTopo n = q.poll();
			System.out.print(n.data+" ");
		}
		System.out.println();
	}
	
}
