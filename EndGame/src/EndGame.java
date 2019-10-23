import java.util.ArrayList;

public class EndGame extends GenericProblem{

	public EndGame(ArrayList<Operator> Operators) {
		super(Operators);
	
		this.FirstHeuristic= new ReachingThanosHeuristic();
		this.SecondHeuristic= new NearestStoneHeuristic();

		


	}

	// A goal state when the previous action is Snap , stone positions empty , conditioned are checked in EndGameOperator
	@Override
	public Boolean goalTest(Node N) {
		//System.out.println(N.Operator);
		if(N.Parent!=null) {
		return N.Operator.Type.equals("SNAP");
		}
		return false;
	}


	@Override
	public ArrayList<Node> ExpandNodes(Node parent) {
		 ArrayList<Node> ExpandedNodes=new ArrayList<Node>();
		 for(int i=0;i<Operators.size();i++)
		 {
			Node n= Operators.get(i).ApplyOnNode(parent);
			if(n!=null) //Operators return null sometimes if move isn't allowed
			{
				ExpandedNodes.add(n);
				
			}
		 }
		// System.out.println(ExpandedNodes.size());
		 return ExpandedNodes;
		 
	}

	@Override
	// 5,5;1,2;3,1;0,2,1,1,2,1,2,2,4,0,4,1;0,3,3,0,3,2,3,4,4,3 Example Input
	public State InitialState(String InitialRepresentation) {
		
		return new EndGameState(InitialRepresentation);
	}
	


	@Override
	// Perform an operator on Node , get new cost and state
	public Node NextState(Node N, Operator o) {
		return o.ApplyOnNode(N);
	}
	
	
	
	public static void main(String[] args)
	{
		
	}
	

	
	
	
}
		
		
	


