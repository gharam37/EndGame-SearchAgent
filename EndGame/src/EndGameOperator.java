import java.util.Hashtable;

public class EndGameOperator extends Operator{
	

	public EndGameOperator(double Cost, String type) {
		super(Cost, type);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node ApplyOnNode(Node node) {
		Node Child=null;
		

		if(this.Type.equals("UP"))
		{
			Child=ApplyUp(node);
		}
		else if(this.Type.equals("DOWN"))
		{
			Child=ApplyDown(node);

			
		}
		else if(this.Type.equals("RIGHT"))
		{
			Child=ApplyRight(node);

		}
		else if(this.Type.equals("LEFT"))
		{
			Child=ApplyLeft(node);
		}
		else if(this.Type.equals("COLLECT"))
		{
			Child=ApplyCollect(node);

		}
		else if(this.Type.equals("KILL"))
		{
			Child=ApplyKill(node);

		}
		else if(this.Type.equals("SNAP"))
		{
			
			Child=ApplySnap(node);

		}
		return Child;
	}
	
	public Node ApplyUp(Node n)
	{
		
		Node child=null;
		EndGameState State=(EndGameState) n.CurrentState;
		CellPosition IronManPos=State.IronManLocation;
		int newIronManX=IronManPos.CellX-1;
		if(newIronManX>=0)
		{
			String newIronManPos=""+newIronManX+","+IronManPos.CellY;
			//No warrior in Cell
			if(!State.WarriorsLocations.containsKey(newIronManPos))
			{
				//Create the state
				EndGameState newState=new EndGameState();
				newState.IronManLocation=new CellPosition(newIronManX,IronManPos.CellY);
				newState.GridLimits= new CellPosition(State.GridLimits.CellX,State.GridLimits.CellY);
				newState.StonesLocations=(Hashtable<String, CellPosition>) State.StonesLocations.clone();
				newState.WarriorsLocations=(Hashtable<String, CellPosition>) State.WarriorsLocations.clone();

						
				newState.ThanosLocation=new CellPosition(State.ThanosLocation.CellX,State.ThanosLocation.CellY);
				newState.CreateKey();

				//Check adjacent cells for warriors to increase damage
				double Damage=checkAdjecents(newState);

				child=new Node(n,newState,new EndGameOperator(Damage,this.Type));

				

				
			}
		}
		
		return child;
	}
	public double checkAdjecents(EndGameState s)
	{
		double Damage=0;
		//System.out.println(s);
		CellPosition newIronManPos=s.IronManLocation;
		String UpKey=(newIronManPos.CellX-1)+","+newIronManPos.CellY;
		String DownKey=(newIronManPos.CellX+1)+","+newIronManPos.CellY;
		String RightKey=(newIronManPos.CellX)+","+(newIronManPos.CellY+1);
		String LeftKey=(newIronManPos.CellX)+","+(newIronManPos.CellY-1);
		/*if(UpKey.equals("0,1"))
		{
			System.out.println("Here");
		}

		System.out.println(s.WarriorsLocations.containsKey("0,1"));*/
		

		
		if(s.WarriorsLocations.containsKey(UpKey))
		{
			Damage+=1;
		}
		if(s.WarriorsLocations.containsKey(DownKey))
		{
			Damage+=1;

		}
		if(s.WarriorsLocations.containsKey(RightKey))
		{
			Damage+=1;

		}
		if(s.WarriorsLocations.containsKey(LeftKey))
		{
			//System.out.println("Here");
			Damage+=1;

		}
		if(s.ThanosLocation.toString().equals(UpKey)
		  || s.ThanosLocation.toString().equals(DownKey)
	      ||  s.ThanosLocation.toString().equals(RightKey)
	      ||s.ThanosLocation.toString().equals(LeftKey))
		{
			Damage+=5;
		}
		
		/*if(newIronManPos.toString().equals("0,2")){
			
		System.out.println(UpKey);
		System.out.println(DownKey);
		System.out.println(RightKey);
		System.out.println(LeftKey);

		}*/
		return Damage;
			
		
		
		
	}
	public Node ApplyDown(Node n)
	{
		Node child=null;
		EndGameState State=(EndGameState) n.CurrentState;
		CellPosition IronManPos=State.IronManLocation;
		int gridX=State.GridLimits.CellX;
		int newIronManX=IronManPos.CellX+1;
		if(newIronManX<gridX)
		{
			String newIronManPos=""+newIronManX+","+IronManPos.CellY;
			//No warrior in Cell
			if(!State.WarriorsLocations.containsKey(newIronManPos))
			{
				EndGameState newState=new EndGameState();
				newState.IronManLocation=new CellPosition(newIronManX,IronManPos.CellY);
				newState.ThanosLocation=new CellPosition(State.ThanosLocation.CellX,State.ThanosLocation.CellY);

				newState.GridLimits= new CellPosition(State.GridLimits.CellX,State.GridLimits.CellY);
				newState.StonesLocations=(Hashtable<String, CellPosition>) State.StonesLocations.clone();
				newState.WarriorsLocations=(Hashtable<String, CellPosition>) State.WarriorsLocations.clone();
				newState.CreateKey();
				double Damage=checkAdjecents(newState);
				child=new Node(n,newState,new EndGameOperator(Damage,this.Type));

				
			}
		}
		
		return child;
	}
	public Node ApplyRight(Node n)
	{
		Node child=null;
		EndGameState State=(EndGameState) n.CurrentState;
		CellPosition IronManPos=State.IronManLocation;
		int gridY=State.GridLimits.CellY;
		int newIronManY=IronManPos.CellY+1;
		if(newIronManY<gridY)
		{
			String newIronManPos=""+State.IronManLocation.CellX+","+newIronManY;
			//No warrior in Cell
			if(!State.WarriorsLocations.containsKey(newIronManPos))
			{
				EndGameState newState=new EndGameState();
				newState.IronManLocation=new CellPosition(State.IronManLocation.CellX,newIronManY);
				newState.ThanosLocation=new CellPosition(State.ThanosLocation.CellX,State.ThanosLocation.CellY);

				newState.GridLimits= new CellPosition(State.GridLimits.CellX,State.GridLimits.CellY);
				newState.StonesLocations=(Hashtable<String, CellPosition>) State.StonesLocations.clone();
				newState.WarriorsLocations=(Hashtable<String, CellPosition>) State.WarriorsLocations.clone();

				
				newState.CreateKey();
				double Damage=checkAdjecents(newState);
				child=new Node(n,newState,new EndGameOperator(Damage,this.Type));

				
			}
		}
		
		return child;
	
	}
	public Node ApplyLeft(Node n)
	{
		Node child=null;
		EndGameState State=(EndGameState) n.CurrentState;
		CellPosition IronManPos=State.IronManLocation;
		int newIronManY=IronManPos.CellY-1;
		if(newIronManY>=0)
		{
			String newIronManPos=""+State.IronManLocation.CellX+","+newIronManY;
			//No warrior in Cell
			if(!State.WarriorsLocations.containsKey(newIronManPos))
			{
				EndGameState newState=new EndGameState();
				newState.IronManLocation=new CellPosition(State.IronManLocation.CellX,newIronManY);
				newState.GridLimits= new CellPosition(State.GridLimits.CellX,State.GridLimits.CellY);
				newState.StonesLocations=(Hashtable<String, CellPosition>) State.StonesLocations.clone();
				newState.WarriorsLocations=(Hashtable<String, CellPosition>) State.WarriorsLocations.clone();
				newState.ThanosLocation=new CellPosition(State.ThanosLocation.CellX,State.ThanosLocation.CellY);
				newState.CreateKey();
				double Damage=checkAdjecents(newState);
				child=new Node(n,newState,new EndGameOperator(Damage,this.Type));

				

				
			}
		}
		
		return child;
	}
	public Node ApplyCollect(Node n)
	{
		Node child=null;
		EndGameState State=(EndGameState) n.CurrentState;
		CellPosition IronManPos=State.IronManLocation;

		if(State.StonesLocations.containsKey(IronManPos.toString()))
		{

			EndGameState newState=new EndGameState();
			newState.IronManLocation= new CellPosition(State.IronManLocation.CellX,State.IronManLocation.CellY);
			newState.GridLimits= new CellPosition(State.GridLimits.CellX,State.GridLimits.CellY);
			newState.RemoveElement(State.StonesLocations,IronManPos.toString());
			newState.WarriorsLocations=(Hashtable<String, CellPosition>) State.WarriorsLocations.clone();
			newState.ThanosLocation=new CellPosition(State.ThanosLocation.CellX,State.ThanosLocation.CellY);
			newState.CreateKey();
			double Damage=checkAdjecents(newState);

			child=new Node(n,newState,new EndGameOperator(Damage+3,this.Type));

			

			//String Representation=State.GridLimits+";"+State.IronManLocation+";"
		}
		
		return child;
	}
	public Node ApplyKill(Node n)
	{
		Node child=null;
		EndGameState State=(EndGameState) n.CurrentState;
		CellPosition IronManPos=State.IronManLocation;

		if(State.WarriorsLocations.containsKey(IronManPos.toString()))
		{

			EndGameState newState=new EndGameState();
			newState.IronManLocation= new CellPosition(State.IronManLocation.CellX,State.IronManLocation.CellY);
			newState.GridLimits= new CellPosition(State.GridLimits.CellX,State.GridLimits.CellY);
			newState.RemoveElement(State.WarriorsLocations,State.WarriorsLocations.toString());
			newState.StonesLocations=(Hashtable<String, CellPosition>) State.StonesLocations.clone();

			newState.ThanosLocation=new CellPosition(State.ThanosLocation.CellX,State.ThanosLocation.CellY);
			newState.CreateKey();
			double Damage=checkAdjecents(newState);

			child=new Node(n,newState,new EndGameOperator(Damage+2,this.Type));
			child=new Node(n,newState,new EndGameOperator(this.Cost,this.Type));


			//String Representation=State.GridLimits+";"+State.IronManLocation+";"
		}
		
		return child;
	}
	public Node ApplySnap(Node n)
	{
		Node child=null;
		EndGameState State=(EndGameState) n.CurrentState;

		if(State.IronManLocation.toString().equals(State.ThanosLocation.toString()))
		{
			
			if(n.Cost<100) {
			EndGameState newState=new EndGameState();
			if(State.StonesLocations.isEmpty()) {

			
			child=new Node(n,newState,new EndGameOperator(this.Cost,this.Type));
			}
	}


			//String Representation=State.GridLimits+";"+State.IronManLocation+";"
		}
		
		return child;
		
	}
	
	
	


}
