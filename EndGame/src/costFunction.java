
public class costFunction {
	 public int apply(Node node) {
		 	EndGameState state =  (EndGameState) node.CurrentState;
	        int warriorNum = state.WarriorsLocations.size();
	        CellPosition GridLimits=state.GridLimits;
	        int costToKill = 3 * (GridLimits.CellX + GridLimits.CellY);
	        return (int) (Math.ceil(warriorNum / 3.0) * costToKill);
	    }
}
