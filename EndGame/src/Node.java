


  
public class Node implements Comparable{
	
	//Node Parent;
	double Cost;
	CellType type;
	boolean visited=false;
	public Node() {
		
		//this.Parent=null;
		this.Cost=0;
	}
	public Node(CellType type,double Cost) {
		//this.Parent=Parent;
		this.type=type;
		this.Cost=Cost;
		
	}
	
	public String  toString() {
		
		return type+"";
		
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
