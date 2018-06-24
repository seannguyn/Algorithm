package dijkstra;

public class State_ implements Comparable<State_> {
	
	public State_(Node_ n, int cost) {
		this.node = n;
		this.cost = cost;
	}
	
	public Node_ getNode() {
		return this.node;
	}
	
	public Node_ node;
	public int cost;
	
	@Override
	public int compareTo(State_ another) {
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
