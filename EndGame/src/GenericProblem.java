import java.util.ArrayList;

public abstract class GenericProblem {
	
	public ArrayList<Operator> Operators= new ArrayList<Operator>();
	
	public GenericProblem(ArrayList<Operator> Operators)
	{
		this.Operators=Operators;
	}

	

	public static void main(String[]args) {
	}
	public abstract Boolean goalTest(Node N);
	public abstract Node NextState(Node N,Operator o);
	public abstract ArrayList<Node> ExpandNodes(Node parent,ArrayList<Operator> Operators);
	//Take Grid and Represent it based on the type of search problem
	public abstract State InitialState(String InitialRepresentation);
	
	public void Search(String InitialRepresentation,String Strategy,Boolean Visualize)
	{
		StrategyQueue queue = null;
		if(Strategy.contentEquals("BF"))
		{
			queue = new BreadthFirstSearch(InitialState(InitialRepresentation));
		}
		else if(Strategy.contentEquals("DF"))
		{
			//To do Initialize a Depth First class not yet Implemented
		}
		int totalNodes=0;
		while(!queue.isEmpty())
		{
			Node currentNode=queue.RemoveFront();
			if(currentNode==null) continue;
			totalNodes++;
			if(goalTest(currentNode))
			{
				System.out.println("Found solution");
				return;
			}
			ArrayList<Node> ExpandedNodes=ExpandNodes(currentNode,Operators);
			queue.EnqueueNodes(ExpandedNodes);
		}
        System.out.println("No Solution was Found");
	}
	
}


