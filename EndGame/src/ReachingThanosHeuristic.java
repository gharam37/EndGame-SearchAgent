
public class ReachingThanosHeuristic extends MainHeuristic{

	
	// Calculate heuristic of a state based on the remaining number of stones and reaching thanos
	@Override
	public int apply(Node node) {
		EndGameState s=(EndGameState)node.CurrentState;
		
		// cost of collecting the rest of stones added with snap cost
		return s.StonesLocations.size()*3+10;
	}

}
