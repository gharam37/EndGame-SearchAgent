import java.util.ArrayList;

public class Main {

	
	public static void solve(String grid, String strategy, boolean visualize)
	{
		 ArrayList<Operator> Operators= new ArrayList<Operator>();

		Operators.add(new EndGameOperator(0,"UP")); // Can Increase if next to warrior , Thanos
		Operators.add(new EndGameOperator(0,"DOWN"));
		Operators.add(new EndGameOperator(0,"RIGHT"));
		Operators.add(new EndGameOperator(0,"LEFT"));
		Operators.add(new EndGameOperator(0,"COLLECT")); 
		Operators.add(new EndGameOperator(0,"KILL")); 
		Operators.add(new EndGameOperator(0,"SNAP")); 
		
		EndGame endGame=new EndGame(Operators);
		
		endGame.Search(grid, strategy, visualize);
		//return strategy;
		
	}
	
	public static void main(String[] args)
	{
		String InitializeRepresentation="15,15;1,1;13,2;0,2,1,7,2,1,5,2,4,0,4,6;0,3,14,0,3,2,3,4,13,3";
	//String InitializeRepresentation="5,5;1,2;3,1;0,2,1,1,2,1,2,2,4,0,4,1;0,3,3,0,3,2,3,4,4,3";
		//String InitializeRepresentation="3,3;2,0;2,2;0,2;0,1,0,0,1,0";

		
		//solve(InitializeRepresentation,"ID",false);
		solve(InitializeRepresentation,"GR2",false);
		
	}
}
