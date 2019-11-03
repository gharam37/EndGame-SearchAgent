import java.util.PriorityQueue;

public class AStarSearch extends StrategyQueue{


	 PriorityQueue<Node> Nodes;
	 //public MainHeuristic heuristicFunction;

	 public AStarSearch(State initialState, MainHeuristic heuristicFunction) {
	        super(initialState,heuristicFunction);

	       


	}

		@Override
   void MakeQueue() {
			//System.out.println(this.heuristicFunction);
			// TODO Auto-generated method stub
	        Nodes = new PriorityQueue<Node>(new Evaluator(PossibleHeuristic, "AStar"));

   }
		@Override
    public Node RemoveFront() {
			Node node=Nodes.poll();
			
			if(node==null) {
				return node;
			}
			double FrontNodeCost=node.Cost;
			
			if(States.contains(node.CurrentState.UniqueKey)) {
				
				State s= node.CurrentState;
				//System.out.println(s.UniqueKey);

			
				double CurrentCost=s.Cost;
	            if (FrontNodeCost >= CurrentCost) {
	            	return null;
	            }

				
			}
			States.add(node.CurrentState.UniqueKey);
			return node;
			
		}

		@Override
		public void AddNode(Node n) {
			Nodes.add(n);
			
		}

		@Override
		public boolean isEmpty() {
			return Nodes.isEmpty();
		}


}
