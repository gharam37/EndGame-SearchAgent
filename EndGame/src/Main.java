import java.util.ArrayList;

public class Main {

	
	public static String solve(String grid, String strategy, boolean visualize)
	{
		 ArrayList<Operator> Operators= new ArrayList<Operator>();

			Operators.add(new EndGameOperator(0,"SNAP")); 

			Operators.add(new EndGameOperator(0,"KILL")); 

			Operators.add(new EndGameOperator(0,"UP")); // Can Increase if next to warrior, Thanos
			Operators.add(new EndGameOperator(0,"DOWN"));

			Operators.add(new EndGameOperator(0,"RIGHT"));
			Operators.add(new EndGameOperator(0,"LEFT"));



			Operators.add(new EndGameOperator(0,"COLLECT")); 
			Operators.add(new EndGameOperator(0,"SNAP")); 



			

			ReachingThanosHeuristic FirstHeuristic= new ReachingThanosHeuristic();
			NearestStoneHeuristic SecondHeuristic= new NearestStoneHeuristic();
		
		EndGame endGame=new EndGame(Operators,FirstHeuristic,SecondHeuristic);
		
		 return endGame.Search(grid, strategy, visualize);
		//return strategy;
		
	}
	
	public static void main(String[] args)
	{
		String InitializeRepresentation="15,15;12,13;5,7;7,0,9,0,10,0,11,8,8,9,8,4;6,6,4,3,10,2,7,4,3,11";
	    String InitializeRepresentation2="5,5;1,2;3,1;0,2,1,1,2,1,2,2,4,0,4,1;0,3,3,0,3,2,3,4,4,3";


	    // Examples
		/*System.out.println("15*15 Grid Example");
		System.out.println("Breadth First Search");
		solve(InitializeRepresentation,"BF",true);
		System.out.println("Depth First Search");

		solve(InitializeRepresentation,"DF",false);
		System.out.println("Uniform Cost Search");

		solve(InitializeRepresentation,"UC",false);
		System.out.println("A* First Heuristic");

		solve(InitializeRepresentation,"AS1",false);
		System.out.println("A* Second Heuristic");

		solve(InitializeRepresentation,"AS2",false);
		System.out.println("Greedy First Heuristic");

		solve(InitializeRepresentation,"GR1",false);
		System.out.println("Greedy Second Heuristic");

		solve(InitializeRepresentation,"GR2",false);
		System.out.println("Iterative Deep Search");

		solve(InitializeRepresentation,"ID",false);*/

		
		//////////
		System.out.println("5*5 Grid Example");
		
		System.out.println("Breadth First Search");
		solve(InitializeRepresentation2,"BF",true);
		
		System.out.println("Depth First Search");
		solve(InitializeRepresentation2,"DF",false);
		
		System.out.println("Uniform Cost Search");
		solve(InitializeRepresentation2,"UC",false);
		
		System.out.println("A* First Heuristic");
		solve(InitializeRepresentation2,"AS1",false);
		
		System.out.println("A* Second Heuristic");
		solve(InitializeRepresentation2,"AS2",false);
		
		System.out.println("Greedy First Heuristic");
		solve(InitializeRepresentation2,"GR1",false);
		
		System.out.println("Greedy Second Heuristic");
		solve(InitializeRepresentation2,"GR2",false);
		
		System.out.println("Iterative Deep Search");
		solve(InitializeRepresentation2,"ID",false);
		
	}
}
