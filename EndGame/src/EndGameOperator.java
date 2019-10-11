
public class EndGameOperator extends Operator{
	

	public EndGameOperator(double Cost, String type) {
		super(Cost, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node ApplyOnNode(Node node) {
		Node Child=null;
		if(this.Type.contentEquals("UP"))
		{
			Child=ApplyUp(node);
		}
		else if(this.Type.contentEquals("DOWN"))
		{
			Child=ApplyDown(node);

			
		}
		else if(this.Type.contentEquals("RIGHT"))
		{
			Child=ApplyRight(node);

		}
		else if(this.Type.contentEquals("LEFT"))
		{
			Child=ApplyLeft(node);
		}
		else if(this.Type.contentEquals("COLLECT"))
		{
			Child=ApplyCollect(node);

		}
		else if(this.Type.contentEquals("KILL"))
		{
			Child=ApplyKill(node);

		}
		else if(this.Type.contentEquals("SNAP"))
		{
			
			Child=ApplySnap(node);

		}
		return Child;
	}
	
	public Node ApplyUp(Node n)
	{
		Node child=null;
		return child;
	}
	public Node ApplyDown(Node n)
	{
		Node child=null;
		return child;
	}
	public Node ApplyRight(Node n)
	{
		Node child=null;
		return child;
	}
	public Node ApplyLeft(Node n)
	{
		Node child=null;
		return child;
	}
	public Node ApplyCollect(Node n)
	{
		Node child=null;
		return child;
	}
	public Node ApplyKill(Node n)
	{
		Node child=null;
		return child;
	}
	public Node ApplySnap(Node n)
	{
		
		//All stones taken ,whats the damage, inside Thanos's cell?
		Node child=null;
	
		return child;
	}
	
	


}
