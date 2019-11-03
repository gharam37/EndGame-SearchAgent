import java.util.PriorityQueue;

public class GreedySearch extends StrategyQueue{
	 PriorityQueue<Node> Nodes;

	 public GreedySearch(State initialState, MainHeuristic heuristicFunction) {
	        super(initialState,heuristicFunction);

	}

		@Override
		void MakeQueue() {
			// TODO Auto-generated method stub
	        Nodes = new PriorityQueue<Node>(new Evaluator(PossibleHeuristic, "Greedy"));

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
			States.add(node.CurrentState.UniqueKey );
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
