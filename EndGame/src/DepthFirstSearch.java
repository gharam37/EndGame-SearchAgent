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
		if(States.contains(node.CurrentState.UniqueKey)) {
			return null;
		}
		States.add(node.CurrentState.UniqueKey);
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
