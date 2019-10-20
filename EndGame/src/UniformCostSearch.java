import java.util.PriorityQueue;

public class UniformCostSearch extends StrategyQueue{
	
	 PriorityQueue<Node> Nodes;

	public UniformCostSearch(State InitialState) {
		super(InitialState);
	}

	@Override
	void MakeQueue() {
		// TODO Auto-generated method stub
        Nodes = new PriorityQueue<Node>(new BasicNodeComparator());

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
    			/*System.out.println(s.UniqueKey);
    			System.out.println(CurrentCost);
    			System.out.println(FrontNodeCost);*/
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
