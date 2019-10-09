
public class Node implements Comparable{
	
	Node Parent;
	double Cost;
	public Node() {
		
		this.Parent=null;
		this.Cost=0;
	}
	public Node(Node Parent,double Cost) {
		this.Parent=Parent;
		
	}
	
	public int compareTo(Object Node) {
		
		Node n = (Node) Node;
		if (Cost == n.Cost) {
			return 0;
		} else if (Cost > n.Cost) {
			return 1;
		} else {
			return -1;
		}
	}

}
