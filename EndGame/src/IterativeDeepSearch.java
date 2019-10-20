import java.util.Stack;

public class IterativeDeepSearch extends StrategyQueue {
	 
	private LimitedSearch Nodes;

	    public IterativeDeepSearch(State initialState) {
	        super(initialState);
	    }


	    @Override
	    public Node RemoveFront() {
	        return Nodes.RemoveFront();
	    }


	    @Override
	    public boolean isEmpty() {
	        boolean isDone = Nodes.isEmpty();
	        if (isDone) {
	            System.out.printf("Tried depth %d but failed to find solution, trying depth %d ...\n",
	                    Nodes.depth, Nodes.depth + 1);
	            Nodes.depth++;
	            Nodes.reset();
	        }
	        return false;
	    }

		@Override
		void MakeQueue() {
			// TODO Auto-generated method stub
			Nodes = new LimitedSearch(this.InitialState, 0);
			
		}



		@Override
		public void AddNode(Node n) {
			// TODO Auto-generated method stub
			Nodes.AddNode(n);
		}
}
