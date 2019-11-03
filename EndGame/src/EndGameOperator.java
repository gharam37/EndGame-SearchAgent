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
			if(!State.WarriorsLocations.containsKey(newIronManPos) && !(State.ThanosLocation.toString().equals(newIronManPos)&& State.StonesLocations.size()!=0))
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
	      ||s.ThanosLocation.toString().equals(LeftKey)
	      || (s.ThanosLocation.toString().equals(s.IronManLocation.toString())))
				
				
		{
			Damage+=5;
			//System.out.println(Damage);
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
			if(!State.WarriorsLocations.containsKey(newIronManPos) && !(State.ThanosLocation.toString().equals(newIronManPos)&& State.StonesLocations.size()!=0))
			{
				EndGameState newState=new EndGameState();
				newState.IronManLocation=new CellPosition(newIronManX,IronManPos.CellY);
				newState.ThanosLocation=new CellPosition(State.ThanosLocation.CellX,State.ThanosLocation.CellY);

				newState.GridLimits= new CellPosition(State.GridLimits.CellX,State.GridLimits.CellY);
				newState.StonesLocations=(Hashtable<String, CellPosition>) State.StonesLocations.clone();
				newState.WarriorsLocations=(Hashtable<String, CellPosition>) State.WarriorsLocations.clone();
				newState.CreateKey();
				double Damage=checkAdjecents(newState);
				/*if(Damage>=5) {
					System.out.println("Here");
					System.out.println(newState.UniqueKey);
				     if(newState.IronManLocation.equals(newState.ThanosLocation)){
				    	// System.out.println(newState.UniqueKey);
				     }
				}*/
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
			if(!State.WarriorsLocations.containsKey(newIronManPos) && !(State.ThanosLocation.toString().equals(newIronManPos)&& State.StonesLocations.size()!=0))
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
			if(!State.WarriorsLocations.containsKey(newIronManPos) && !(State.ThanosLocation.toString().equals(newIronManPos)&& State.StonesLocations.size()!=0))
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
			newState.StonesLocations= (Hashtable<String, CellPosition>) State.StonesLocations.clone();
			newState.RemoveElement(newState.StonesLocations,IronManPos.toString());
			newState.WarriorsLocations=(Hashtable<String, CellPosition>) State.WarriorsLocations.clone();
			newState.ThanosLocation=new CellPosition(State.ThanosLocation.CellX,State.ThanosLocation.CellY);
			//System.out.println(State.UniqueKey);
			newState.CreateKey();
			//System.out.println(newState.UniqueKey);

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
		String Up = (IronManPos.CellX+1)+","+IronManPos.CellY;
		String Down = (IronManPos.CellX-1)+","+IronManPos.CellY;
		String Right = IronManPos.CellX+","+(IronManPos.CellY+1);
		String Left = IronManPos.CellX+","+(IronManPos.CellY-1);



		EndGameState newState=new EndGameState();
		newState.IronManLocation= new CellPosition(State.IronManLocation.CellX,State.IronManLocation.CellY);
		newState.GridLimits= new CellPosition(State.GridLimits.CellX,State.GridLimits.CellY);
		newState.StonesLocations=(Hashtable<String, CellPosition>) State.StonesLocations.clone();
		newState.WarriorsLocations=(Hashtable<String, CellPosition>) State.WarriorsLocations.clone();


		newState.ThanosLocation=new CellPosition(State.ThanosLocation.CellX,State.ThanosLocation.CellY);
		double Damage=0;
		if(newState.WarriorsLocations.containsKey(Up))
		{
             //System.out.println("Up");
			newState.RemoveElement(newState.WarriorsLocations,Up);
			newState.CreateKey();

			Damage+=1;

			//String Representation=State.GridLimits+";"+State.IronManLocation+";"
		}
		if(newState.WarriorsLocations.containsKey(Left))
		{

            //System.out.println("Left");
			newState.RemoveElement(newState.WarriorsLocations,Left);
			newState.CreateKey();
			Damage+=1;

			//String Representation=State.GridLimits+";"+State.IronManLocation+";"
		}
		if(newState.WarriorsLocations.containsKey(Down))
		{
			
            //System.out.println("Down");

			newState.RemoveElement(newState.WarriorsLocations,Down);
			newState.CreateKey();
			Damage+=1;


	        //String Representation=State.GridLimits+";"+State.IronManLocation+";"
		}
		if(newState.WarriorsLocations.containsKey(Right))
		{
            //System.out.println("Right");

			newState.RemoveElement(newState.WarriorsLocations,Right);
			newState.CreateKey();
			Damage+=1;



			//String Representation=State.GridLimits+";"+State.IronManLocation+";"
		}
		
		Damage=Damage*2;
		if(Damage>0) {
			///System.out.println("Here");
			//System.out.println(State.WarriorsLocations+"Old");
			//System.out.println(newState.WarriorsLocations);
            //newState.Visualize();
           // State.Visualize();
		child=new Node(n,newState,new EndGameOperator(Damage,this.Type));
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
			newState.IronManLocation=new CellPosition(State.IronManLocation.CellX,State.IronManLocation.CellY);
			newState.GridLimits= new CellPosition(State.GridLimits.CellX,State.GridLimits.CellY);
			newState.StonesLocations=(Hashtable<String, CellPosition>) State.StonesLocations.clone();
			newState.WarriorsLocations=(Hashtable<String, CellPosition>) State.WarriorsLocations.clone();

					
			newState.ThanosLocation=new CellPosition(State.ThanosLocation.CellX,State.ThanosLocation.CellY);
			if(State.StonesLocations.isEmpty()) {
           // System.out.println("Stones are empty");
			child=new Node(n,newState,new EndGameOperator(this.Cost,this.Type));
			
			Node current=n;
			/*while(current!=null) {
				if(current.Parent!=null) {
				System.out.println(current.Operator.Type);
				}
				current=current.Parent;
			}*/
	}
	}


			//String Representation=State.GridLimits+";"+State.IronManLocation+";"
		}
		
		return child;
		
	}
	
	
	


}
