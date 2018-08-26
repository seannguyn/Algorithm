package Chapter4;
import java.util.*;
public class NodeTopo {

	public NodeTopo(String name) {
		this.data = name;
		outgoing = new ArrayList<>();
		incoming = new ArrayList<>();
	}
	
	public String data;
	public List<NodeTopo> outgoing;
	public List<NodeTopo> incoming;
	
}
