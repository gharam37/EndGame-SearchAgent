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
	public abstract ArrayList<Node> ExpandNodes(Node parent);
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
			queue = new DepthFirstSearch(InitialState(InitialRepresentation));
		}
		else if(Strategy.contentEquals("ID"))
		{
			queue = new IterativeDeepSearch(InitialState(InitialRepresentation));
		}
		else if(Strategy.contentEquals("UC"))
		{
			queue = new UniformCostSearch(InitialState(InitialRepresentation));
		}
		int totalNodes=0;
		long startTime = System.nanoTime();

		while(!queue.isEmpty())
		{
			
			Node currentNode=queue.RemoveFront();
			if(currentNode==null) continue;
			//totalNodes++;
			//System.out.println("GOT HERE");
			if(goalTest(currentNode))
			{
				//currentNode.Operator.Type.equals("SNAP");
				System.out.println("Found solution");
				DisplaySolution(currentNode,totalNodes);
				long endTime = System.nanoTime();
				long timeElapsed = endTime - startTime;
				System.out.println("Execution time in milliseconds : " + 
						timeElapsed / 1000000);
				System.out.println(totalNodes);
				return;
			}
			if(Visualize)
			{
				currentNode.CurrentState.Visualize();
			}
			ArrayList<Node> ExpandedNodes=ExpandNodes(currentNode);
			totalNodes+=ExpandedNodes.size();
			//System.out.println("Expanding");
			queue.EnqueueNodes(ExpandedNodes);
		}
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in milliseconds : " + 
				timeElapsed / 1000000);
        System.out.println("No Solution was Found");
	}
	
	void DisplaySolution(Node n,int totalNodes)
	{
		Node current=n;
		while(current.Parent!=null)
		{
			System.out.print(" "+current.Cost+" "+current.Operator.Type);
			//System.out.println(current.CurrentState.UniqueKey);
			current=current.Parent;
		}
		//System.out.println(totalNodes);
		//TODO loop over n get parents until null, add costs , print totalNodes
	}
	
	
}


