import java.util.ArrayList;

public class Main {

	
	public static String solve(String grid, String strategy, boolean visualize)
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
		
		 return endGame.Search(grid, strategy, visualize);
		//return strategy;
		
	}
	
	public static void main(String[] args)
	{
		String InitializeRepresentation="10,10;5,1;0,4;3,1,6,8,1,2,9,2,1,5,0,8;7,8,7,6,3,3,6,0,3,8";
	//String InitializeRepresentation="5,5;1,2;3,1;0,2,1,1,2,1,2,2,4,0,4,1;0,3,3,0,3,2,3,4,4,3";
		//String InitializeRepresentation="3,3;2,0;2,2;0,2;0,1,0,0,1,0,1,1,2,1";

		
		solve(InitializeRepresentation,"ID",false);
		//solve(InitializeRepresentation,"GR2",false);
		
	}
}
