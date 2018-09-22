package coding_Challenges;

import java.util.*;

import dijkstra.State_;

/*
 * Implement Dijkstra Algorithm
 */

public class Problem_2 {
	
	public Graph g;
	
	public Problem_2() {
		this.g = new Graph (new String [] {"A","B","C","D","E","F","G","H","I"});
	}

	private class Node {
		
		public HashMap hm;
		public String name;
		
		public Node (String name) {
			this.name = name;
			hm = new HashMap<Node,Integer>();
		}
		
		public void addEdge(Node n, int weight) {
			hm.put(n, weight);
		}
	}
	
	public class State implements Comparable<State> {
		public Node n;
		public int cost;
		public State(Node n, int cost) {
			this.n= n;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(State another) {
			// TODO Auto-generated method stub
			if (this.cost > another.cost) {
				return 1;
			}
			else if (this.cost == another.cost) {
				return 0;
			}
			else {
				return -1;
			}
		}
	}
	
	public class Graph {
		public HashMap nodeList;
		private HashMap dijkstra;
		
		public Graph(String[] bruh) {
			this.nodeList = new HashMap<String,Node>();
			
			for(String s : bruh) {
				Node n = new Node(s);
				this.nodeList.put(s,n);
				System.out.println("NODE: "+this.nodeList.get(s));
			}
		}
		
		public void addEdge(String from, String to, int weight) {
			Node nodeFrom = (Node) this.nodeList.get(from);
			Node nodeTo = (Node) this.nodeList.get(to);
			System.out.println("NODE: "+nodeFrom.name);
			nodeFrom.addEdge(nodeTo,weight);
			nodeTo.addEdge(nodeFrom,weight);
		}
		
		public void dijkstraAlgo(String src, String sink) {
			PriorityQueue<State> pq = new PriorityQueue<>();
			
			List<Node> visited = new ArrayList<>();
			
			HashMap dist = new HashMap<String,Integer>();
			
			// initialize dist to MAX
			Iterator it = this.nodeList.entrySet().iterator();
			while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        dist.put(pair.getKey(), 1000);
		        
		    }
			
			// add source to pq,
			Node n = 	(Node) this.nodeList.get(src);
			System.out.println("SUP + "+n);
			pq.add(new State (n,0));
			
			//  dist to source is 0
			dist.put(src,0);
			
			while(!pq.isEmpty() ) {
				State current = pq.poll();
				Node curr = current.n;
				visited.add(curr);
				if (curr.name.equals(sink)) break;
				
				Iterator it_ = curr.hm.entrySet().iterator();
				
				while (it_.hasNext()) {
			        Map.Entry pair = (Map.Entry)it_.next();
			        System.out.println("SUPPP: "+((Node)pair.getKey()).name);
			        int cost = (int) dist.get( ((Node)pair.getKey()).name );
			        int from_ = (int) dist.get( curr.name );
			        int edge_ = (int) pair.getValue();
			        
			        if (cost > from_ + edge_) {
			        		cost = from_ + edge_;
			        		dist.put( ((Node)pair.getKey()).name, cost);
			        		
			        		// YOU FORGOT to reorder the queue when doing an update
						for (State st : pq) {
							if (st.n.equals((Node)pair.getKey())) {
								pq.remove(st);
								st.cost = cost;
								pq.add(st);
								break;
							}
						}
			        }
			        
			        Node newN = (Node) pair.getKey();
			        if (!visited.contains( newN )) {

						State newState = new State(newN,cost);
						pq.add(newState);
						visited.add(newN);
					}			        
			        
			    }
				
			}
			System.out.println("from " + src+ " to " +sink+" : "+dist.get(sink));
			
		}
	}
	
	public static void main(String args[]) {
		System.out.println("starting..");
		Problem_2 p2 = new Problem_2();
		
		p2.g.addEdge("A", "B", 4);
		p2.g.addEdge("A", "H", 8);
		
		p2.g.addEdge("B", "C", 8);
		p2.g.addEdge("B", "H", 11);
		
		
		p2.g.addEdge("C", "D", 7);
		p2.g.addEdge("C", "F", 4);
		p2.g.addEdge("C", "I", 2);
		
		p2.g.addEdge("D", "E", 9);
		p2.g.addEdge("D", "F", 14);
		
		p2.g.addEdge("E", "F", 10);
		
		p2.g.addEdge("F", "G", 2);
		
		p2.g.addEdge("G", "I", 6);
		p2.g.addEdge("G", "H", 1);
		
		p2.g.addEdge("H", "I", 7);
		
		p2.g.dijkstraAlgo("A","I");

	}
	
}
