package dijkstra;
import java.util.*;
public class Node_ {

	public Node_(String port) {
		this.port = port;
		this.edgeOut = new ArrayList<>();
	}
	
	public String port;
	public List<Edge_> edgeOut;
	
}
