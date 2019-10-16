import java.util.Stack;

public class IterativeDeepSearch extends StrategyQueue {
	Stack<Node> queue;
    int depth;
	public IterativeDeepSearch(State InitialState, int depth) {
		super(InitialState);
		this.depth=depth;

	}

	@Override
	void MakeQueue() {
		queue = new Stack<>();
		
	}

	@Override
	public Node RemoveFront() {
		if (queue.isEmpty()) {
            return null;
        }
		else {
			   Node n = queue.pop();
			   State last_node=States.get(n.CurrentState.UniqueKey);
		        boolean exploredBefore = States.containsKey(n.CurrentState.UniqueKey)
		        		&& last_node.depth <= n.Depth;
		        System.out.println(exploredBefore);
		        boolean depthCrossed = n.Depth > this.depth;
		        System.out.println(depthCrossed);
		        if (exploredBefore || depthCrossed) return null;
		        n.CurrentState.depth=this.depth;
		        States.put(n.CurrentState.UniqueKey, n.CurrentState);
		        return n;
		}
     
	}

	@Override
	public void AddNode(Node n) {
		queue.push(n);
		
	}

	@Override
	public boolean isEmpty() {
		boolean isDone = queue.isEmpty();
        if (isDone) {
//            System.out.printf("Tried depth %d but failed to find solution, trying depth %d ...\n",
//            		depth, depth + 1);
            depth++;
            System.out.println(depth);
            queue.clear();
        }
        return false;
	}

}
