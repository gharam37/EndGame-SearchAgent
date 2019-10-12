


  
public class Node implements Comparable{
	
	public Node Parent;
	public double Cost;
	public State CurrentState;
	public Operator Operator; //What got us here
	public int Depth;

	public Node() {
		
		this.Parent=null;
		this.Cost=0;
		Operator=null;
		CurrentState=null;
		
		
	}
	public Node(State CurrentState)
	{
		this.CurrentState=CurrentState;
	}
	public Node(Node Parent, State CurrentState,Operator Operator) {
		this.Parent=Parent;
		this.CurrentState=CurrentState;
		this.Operator=Operator;
		if(this.Parent==null)
		{
			Depth=0;
			Cost=0;
		}
		else
		{
			Depth=Parent.Depth+1;
			Cost=Parent.Cost+Operator.Cost;
		}
		
	}
	
	//Compare cost of nodes for cost functions
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
	
    public String  toString() {
    	return "{Node "+""+"State "+CurrentState+"Performed Operator "+Operator+"Cost "+Cost;
		
		
	}

}
