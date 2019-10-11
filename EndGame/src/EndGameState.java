import java.util.ArrayList;

public class EndGameState extends State{

	public CellPosition IronManLocation;
	public CellPosition ThanosLocation;
	public ArrayList<CellPosition> WarriorsLocations=new ArrayList<CellPosition>();
	public ArrayList<CellPosition> StonesLocations=new ArrayList<CellPosition>();

	public EndGameState(String StateRepresentation) {
		super(StateRepresentation);
		setIronManLocation();
		setThanosLocation();
		setWarriorsLocations();
		setStonesLocations();
	}


	public void setIronManLocation() {
		int IronManX=Integer.parseInt(StateRepresentation.charAt(4)+"");
		int IronManY=Integer.parseInt(StateRepresentation.charAt(6)+"");
		IronManLocation= new CellPosition(IronManX,IronManY);
	}



	public void setThanosLocation() {
		int ThanosX=Integer.parseInt(StateRepresentation.charAt(8)+"");
		int ThanosY=Integer.parseInt(StateRepresentation.charAt(10)+"");
		ThanosLocation= new CellPosition(ThanosX,ThanosY);
	}



	public void setWarriorsLocations() {
		int initialWarriorX= 36;
		int initialWarriorY=38;
		for(int i=0;i<5;i++)
		{
			if(StateRepresentation.charAt(initialWarriorX)!='k') //k for killed don't add to list
			{
			int WarriorX=Integer.parseInt(StateRepresentation.charAt(initialWarriorX)+"");
			int WarriorY=Integer.parseInt(StateRepresentation.charAt(initialWarriorY)+"");
			CellPosition WarriorPos=new CellPosition(WarriorX,WarriorY);
			WarriorsLocations.add(WarriorPos);

			}
			initialWarriorX+=4;
			initialWarriorY+=4;
		
			
		}
	}



	public void setStonesLocations() {
		int initialStoneX= 12;
		int initialStoneY=14;
		for(int i=0;i<6;i++)
		{
			if(StateRepresentation.charAt(initialStoneX)!='c') //c for collected don't add to list
			{
			int StoneX=Integer.parseInt(StateRepresentation.charAt(initialStoneX)+"");
			int StoneY=Integer.parseInt(StateRepresentation.charAt(initialStoneY)+"");
			CellPosition StonePos=new CellPosition(StoneX,StoneY);
			StonesLocations.add(StonePos);

			}
			initialStoneX+=4;
			initialStoneY+=4;
		
			
		}
	}
	
	public static void main(String[]args)
	{
		EndGameState s= new EndGameState("5,5;1,2;3,1;c,2,1,1,2,1,2,2,4,0,4,1;0,3,3,0,3,2,3,4,4,3");
		System.out.println(s.StonesLocations);
		
	}
	
	

}
