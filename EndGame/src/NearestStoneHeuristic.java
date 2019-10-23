import java.util.Hashtable;

public class NearestStoneHeuristic extends MainHeuristic{

	@Override
	public int apply(Node node) {
		EndGameState s=(EndGameState) node.CurrentState;
	 Hashtable<String,CellPosition> StonesLocations=s.StonesLocations;
	 CellPosition IronManLocation=s.IronManLocation;
			 
	    //Get distance to the nearest stone
	 CellPosition currentStone=StonesLocations.get(0);
	 
	 double SmallestDistance =Math.sqrt((IronManLocation.CellY-currentStone.CellY) * (IronManLocation.CellY-currentStone.CellY)  + 
			 (IronManLocation.CellX-currentStone.CellX) *(IronManLocation.CellX-currentStone.CellX) );

	    for(int i=0;i<StonesLocations.size();i++) {
		  currentStone=StonesLocations.get(i);
		  double Distance =Math.sqrt((IronManLocation.CellY-currentStone.CellY) * (IronManLocation.CellY-currentStone.CellY)  + 
					 (IronManLocation.CellX-currentStone.CellX) *(IronManLocation.CellX-currentStone.CellX) );
		  if(Distance<SmallestDistance) {
			  SmallestDistance=Distance;
		  }

	 }
	 
	    //To avoid overestimation largest distance is ironman(0,0) nearest stone (15,15) smallest distance/6 = 2.3 < 3 actual cost of collecting stone
	    SmallestDistance = SmallestDistance/(2*3);

		return (int)SmallestDistance;
	}

}
