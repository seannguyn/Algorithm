package dijkstra;
import java.util.*;

public class Graph_ {

	private static final boolean Edge = false;

	/**
	 * create graph, hash<Node>
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
	 * make sure you dont add duplicates node to the priority queue
	 * 
	 */
	
	public Graph_() {
		nodeH = new HashMap<>();
	}
	
	public HashMap<String,Node_> nodeH;
	
	public void addNode(String port) {
		Node_ n = new Node_ (port);
		this.nodeH.put(port, n);
	}
	
	public void addEdge(String from, String to, int cost) {
		Node_ Nfrom = nodeH.get(from);
		Node_ Nto = nodeH.get(to);
		Edge_ e = new Edge_(Nto, cost);
		Nfrom.edgeOut.add(e);
	}
	
	public void printNode() {
		for (String str : nodeH.keySet()) {
			Node_ n = nodeH.get(str);
			System.out.print("Node "+ n.port+": ");
			for (Edge_ e : n.edgeOut) {
				System.out.print(e.to.port+"("+e.cost+") ");
			}
			System.out.println();
		}
	}
	
	public void dijkstra(String src, String dst) {
		
		Node_ source = nodeH.get(src);
		Node_ dest = nodeH.get(dst);
		
		HashMap<Node_,Integer> dist = new HashMap<>();
		// initialize dist
		for (String str : nodeH.keySet()) {
			Node_ n = nodeH.get(str);
			dist.put(n, 1000);
		}
		
		HashMap<Node_,Boolean> visited = new HashMap<>();
		// initialize visited
		for (String str : nodeH.keySet()) {
			Node_ n = nodeH.get(str);
			visited.put(n, false);
		}
		
		PriorityQueue<State_> pq = new PriorityQueue<>();
		State_ s1 = new State_(source,0);
		pq.add(s1);
		State_ finalState = null;
		while (!pq.isEmpty()) {
			
			State_ s = pq.peek();
			pq.poll();
			
			
			Node_ current = s.getNode();
			int currentDist = s.cost;
			
			
			
			if (current.port.equals(dst)) {
				finalState = s;
				break;
			}

			
			for (Edge_ ed : current.edgeOut) {
				
				int distance = dist.get(ed.to);
				
				if ( s.cost + ed.cost < distance ) {
					distance = s.cost + ed.cost;
					
					dist.put(ed.to,distance);
					
					if (ed.to.port.equals("D")) {
						System.out.println("COST to D: "+distance);
					}
					
					// YOU FORGOT to reorder the queue when doing an update
					for (State_ st : pq) {
						if (st.node.equals(ed.to)) {
							pq.remove(st);
							st.cost = distance;
							pq.add(st);
							break;
						}
					}
				}
				
				if (visited.get(ed.to) == false) {
					
					if (ed.to.port.equals("D")) {
						System.out.println("add to D: "+distance);
					}
					
					State_ newState = new State_(ed.to,distance);
					pq.add(newState);
					visited.put(ed.to, true);
				}
				
			}
			
			
		}
		
		System.out.println("Node dest: "+finalState.node.port);
		System.out.println("cost dest: "+finalState.cost);
		
		
	}
	
}
