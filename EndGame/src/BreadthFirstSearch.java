import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends StrategyQueue {

	
	Queue <Node> Nodes;
	public BreadthFirstSearch(State InitialState) {
		super(InitialState);
	}

	@Override
	void MakeQueue() {
		Nodes=new LinkedList<>();
		
	}

	@Override
	public Node RemoveFront() {
		Node node=Nodes.poll();
		if(States.containsKey(node.CurrentState)) {
			return null;
		}
		States.put(node.CurrentState,-1 );
		return node;
		
	}

	@Override
	public void AddNode(Node node) {
		Nodes.add(node);
		
	}

	@Override
	public boolean isEmpty() {
		return Nodes.isEmpty();
	}
	
	

}
