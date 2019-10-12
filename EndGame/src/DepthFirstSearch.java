import java.util.Stack;

public class DepthFirstSearch extends StrategyQueue{
    private Stack<Node> Nodes;


	public DepthFirstSearch(State InitialState) {
		super(InitialState);
	}

	@Override
	void MakeQueue() {
		
		Nodes =new Stack<>();
		
	}

	@Override
	public Node RemoveFront() {
		Node node=Nodes.pop();
		if(States.containsKey(node.CurrentState.UniqueKey)) {
			return null;
		}
		States.put(node.CurrentState.UniqueKey,node.CurrentState );
		return node;
	}

	@Override
	public void AddNode(Node n) {
		Nodes.push(n);
		
	}

	@Override
	public boolean isEmpty() {
		return Nodes.isEmpty();
	}

}
