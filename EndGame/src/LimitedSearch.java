
import java.util.Stack;
public class LimitedSearch  extends StrategyQueue {
	 private Stack<Node> Nodes;
	    int depth;

	    LimitedSearch(State initialState, int depth) {
	        super(initialState);
	        this.depth = depth;
	    }



	    @Override
	    public Node RemoveFront() {
	        if (isEmpty()) {
	            return null;
	        }
	        Node n = Nodes.pop();

	        boolean exploredBefore = States.containsKey(n.CurrentState.UniqueKey)
	                && States.get(n.CurrentState.UniqueKey).depth <= n.Depth;
	        boolean depthCrossed = n.Depth > this.depth;
	        if (exploredBefore || depthCrossed) return null;

	        States.put(n.CurrentState.UniqueKey, n.CurrentState);
	        return n;
	    }

	    @Override
	    public boolean isEmpty() {
	        return Nodes.isEmpty();
	    }

		@Override
		void MakeQueue() {
			// TODO Auto-generated method stub
			Nodes = new Stack<>();
			
		}


		@Override
		public void AddNode(Node n) {
			// TODO Auto-generated method stub
			Nodes.push(n);
		}
}
