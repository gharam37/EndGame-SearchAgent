import java.util.ArrayList;
import java.util.Stack;

public abstract class GenericProblem {
	
	public ArrayList<Operator> Operators= new ArrayList<Operator>();
	public MainHeuristic FirstHeuristic;
	public MainHeuristic SecondHeuristic;

	
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
	
	public String Search(String InitialRepresentation,String Strategy,Boolean Visualize)
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
		else if(Strategy.contentEquals("GR1"))
		{
			queue = new GreedySearch(InitialState(InitialRepresentation), this.FirstHeuristic);
		}
		else if(Strategy.contentEquals("AS1"))
		{
			queue = new AStarSearch(InitialState(InitialRepresentation),this.FirstHeuristic);
		}
		else if(Strategy.contentEquals("GR2"))
		{
			queue = new GreedySearch(InitialState(InitialRepresentation), this.SecondHeuristic);
		}
		else if(Strategy.contentEquals("AS2"))
		{
			queue = new AStarSearch(InitialState(InitialRepresentation),this.SecondHeuristic);
		}
		int totalNodes=0;
		long startTime = System.nanoTime();

		while(!queue.isEmpty())
		{
			Node currentNode=queue.RemoveFront();
			if(currentNode==null) 
			{continue;
				
			}
			//totalNodes++;
			//System.out.println("GOT HERE");
			if(goalTest(currentNode))
			{
				//currentNode.Operator.Type.equals("SNAP");
				System.out.println("Found solution");
				String Solution=DisplaySolution(currentNode,totalNodes,Visualize);
				long endTime = System.nanoTime();
				long timeElapsed = endTime - startTime;
				System.out.println("Execution time in milliseconds : " + 
						timeElapsed / 1000000);
				//System.out.println(totalNodes);
				return Solution;
			}
			
			ArrayList<Node> ExpandedNodes=ExpandNodes(currentNode);
			totalNodes+=1;
			//System.out.println("Expanding");
			queue.EnqueueNodes(ExpandedNodes);
		}
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in milliseconds : " + 
				timeElapsed / 1000000);
        System.out.println("No Solution was Found");
        return null;
	}
	
	String DisplaySolution(Node n,int totalNodes,boolean Visualize)
	{
		//Printing Stack
		Stack<State> States=new Stack<State>();
		Node current=n;
		String Solution="";
		double TotalCost=n.Cost;
		while(current.Parent!=null)
		{
			if(Visualize)
			{
				States.add(current.CurrentState);
			}
			//Solution=current.Operator.Type.toLowerCase()+" ("+current.Cost+") "+Solution;
			Solution=current.Operator.Type.toLowerCase()+","+Solution;
			//System.out.print(" "+current.Cost+" "+current.Operator.Type);
			//System.out.println(current.CurrentState.UniqueKey);
			current=current.Parent;
			
			
		}
		States.add(current.CurrentState);
		
		if(Visualize)
		{
			while(!States.isEmpty()) {
				States.pop().Visualize();
				
			}
		}
		
		Solution=Solution.substring(0,(Solution.length())-1);
		Solution+=";"+TotalCost;

		Solution+=";"+totalNodes;
		System.out.println(Solution);
		return Solution;
		//TODO loop over n get parents until null, add costs , print totalNodes
	}
	
	
}


