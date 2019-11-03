import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class EndGameState extends State{

	public CellPosition IronManLocation;
	public CellPosition ThanosLocation;
	public CellPosition GridLimits;
	public Hashtable<String,CellPosition> WarriorsLocations=new Hashtable<String,CellPosition>();
	public Hashtable<String,CellPosition> StonesLocations=new Hashtable<String,CellPosition>();

	//To initialize Initial State
	public EndGameState(String StateRepresentation) {
		String[] parts = StateRepresentation.split(";");

		setgridXandY(parts);
		setIronManLocation(parts);
		setThanosLocation(parts);
		setWarriorsLocations(parts);
		setStonesLocations(parts);
		CreateKey();
	}

	//For other States
	public EndGameState()
	{
		
	}
	
	public void setgridXandY(String [] parts)
	{
		GridLimits=new CellPosition(Integer.parseInt(parts[0].split(",")[0])
				,Integer.parseInt(parts[0].split(",")[1]));
		System.out.println(GridLimits);
		

	}
	public void setIronManLocation(String [] parts) {

		IronManLocation=new CellPosition(Integer.parseInt(parts[1].split(",")[0])
				,Integer.parseInt(parts[1].split(",")[1]));
	}



	public void setThanosLocation(String [] parts) {
		ThanosLocation=new CellPosition(Integer.parseInt(parts[2].split(",")[0])
				,Integer.parseInt(parts[2].split(",")[1]));
	}


    public void setStonesLocations(String [] parts) {
    	String[] StonesStrings = parts[3].split(",");
    	for(int i=0;i+1<StonesStrings.length;i+=2)
    	{
    		CellPosition newStonePos=new CellPosition(Integer.parseInt(StonesStrings[i]),
    				Integer.parseInt(StonesStrings[i+1]));
    		
    		StonesLocations.put(newStonePos.toString(), newStonePos);
    	}
		
	}

	public void setWarriorsLocations(String [] parts) {
		
		String[] WarriorsStrings = parts[4].split(",");
    	for(int i=0;i+1<WarriorsStrings.length;i+=2)
    	{
    		CellPosition newWarriorPos=new CellPosition(Integer.parseInt(WarriorsStrings[i]),
    				Integer.parseInt(WarriorsStrings[i+1]));
    		
    		WarriorsLocations.put(newWarriorPos.toString(), newWarriorPos);
    	}
		
	
	}



	
	
	public static void main(String[]args)
	{
		EndGameState s1= new EndGameState("5,5;1,2;3,1;4,1;0,3,3,2,3,4,4,3");
		
		EndGameState s2= new EndGameState("5,5;1,2;3,1;4,1;0,3,3,2,3,4,4,3");

		System.out.println(s1.UniqueKey.equals(s2.UniqueKey));
		HashMap<State,Integer> States=new HashMap<State,Integer> ();
		if(!States.containsKey(s1)) {
			States.put(s1,-1 );

		}
		if(!States.containsKey(s2)) {
			States.put(s2,-1 );

		}
		System.out.println(States.size());
		

		//System.out.println(java.util.Arrays.toString("0,3,3,2,3,4,4,3".split("(?<=\\G.)")));

		
		//System.out.println(s1.WarriorsLocations);
		
	}
	public void RemoveElement(Hashtable<String,CellPosition> List,String Key) {
		List.remove(Key);
       // StonesLocations=(Hashtable<String, CellPosition>) List.clone();
    }


	@Override
	public void Visualize() {
		//System.out.println(GridLimits);

		for(int x=0;x<GridLimits.CellX;x++) {
			for(int y=0;y<GridLimits.CellY;y++) {
				if(IronManLocation.CellX==x && IronManLocation.CellY==y) {
					System.out.print(" I |");
				}
				else {
					if(ThanosLocation.CellX==x && ThanosLocation.CellY==y) {
						System.out.print(" T |");
						
					}
					else {
						if(WarriorsLocations.containsKey(x+","+y)) {
							System.out.print(" W |");
						}
						else {
							if(StonesLocations.containsKey(x+","+y)) {
								System.out.print(" S |");
							}
							else {
								System.out.print(" 0 |");
							}
						}
					}
				}
				
				
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
	}


	@Override
	public int compareTo(Object arg0) {
		return 0;
	
	}

	@Override
	public void CreateKey() {
		this.UniqueKey=IronManLocation.toString()+ThanosLocation.toString()+StonesLocations+WarriorsLocations+GridLimits;
		
	}
	

}
