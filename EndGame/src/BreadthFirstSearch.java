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
		if(States.contains(node.CurrentState.UniqueKey)) {
			return null;
		}
		States.add(node.CurrentState.UniqueKey );
		return node;
		
	}

	@Override
	public void AddNode(Node node) {
		Nodes.add(node);
		//System.out.println(node.Cost);
	}

	@Override
	public boolean isEmpty() {
		return Nodes.isEmpty();
	}
	
	

}
