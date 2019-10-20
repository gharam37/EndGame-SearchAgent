
public class costFunction extends MainHeuristic{
	 public int apply(Node node) {
		 	EndGameState state =  (EndGameState) node.CurrentState;
	        int warriorNum = state.WarriorsLocations.size();
	        CellPosition GridLimits=state.GridLimits;
	        int costToKill = 2 * (GridLimits.CellX + GridLimits.CellY);
	        return (int) (Math.ceil(warriorNum / 2.0) * costToKill);
	    }
}
