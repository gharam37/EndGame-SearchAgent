import java.util.PriorityQueue;

public class AStarSearch extends StrategyQueue{


	 PriorityQueue<Node> Nodes;
	 Evaluator evaluator;

	 public AStarSearch(State initialState, MainHeuristic heuristicFunction) {
	        super(initialState);
	        this.evaluator = new Evaluator(heuristicFunction, "AStar");


	}

		@Override
   void MakeQueue() {
			// TODO Auto-generated method stub
	        Nodes = new PriorityQueue<Node>(evaluator);

   }
		@Override
    public Node RemoveFront() {
			Node node=Nodes.poll();
			
			if(node==null) {
				return node;
			}
			double FrontNodeCost=node.Cost;
			
			if(States.containsKey(node.CurrentState.UniqueKey)) {
				
				State s= States.get(node.CurrentState.UniqueKey);
				//System.out.println(s.UniqueKey);

			
				double CurrentCost=s.Cost;
	            if (FrontNodeCost >= CurrentCost) {
	            	return null;
	            }

				
			}
			States.put(node.CurrentState.UniqueKey,node.CurrentState );
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
