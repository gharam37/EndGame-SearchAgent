import java.util.ArrayList;

public class EndGame extends GenericProblem{

	public EndGame(ArrayList<Operator> Operators) {
		super(Operators);
		Operators.add(new EndGameOperator(0,"UP")); // Can Increase if next to warrior , Thanos
		Operators.add(new EndGameOperator(0,"DOWN"));
		Operators.add(new EndGameOperator(0,"RIGHT"));
		Operators.add(new EndGameOperator(0,"LEFT"));
		Operators.add(new EndGameOperator(3,"COLLECT")); 
		Operators.add(new EndGameOperator(2,"KILL")); 
		Operators.add(new EndGameOperator(5,"SNAP")); 
		


	}

	// A goal state when the previous action is Snap , stone positions empty , conditioned are checked in EndGameOperator
	@Override
	public Boolean goalTest(Node N) {
		// TODO Auto-generated method stub
		return null;
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
		
		
	


