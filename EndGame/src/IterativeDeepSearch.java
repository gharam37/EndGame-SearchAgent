import java.util.Stack;

public class IterativeDeepSearch extends StrategyQueue {
	 
	private LimitedSearch queue;

	    public IterativeDeepSearch(State initialState) {
	        super(initialState);
	    }


	    @Override
	    public Node RemoveFront() {
	        return queue.RemoveFront();
	    }


	    @Override
	    public boolean isEmpty() {
	        boolean isDone = queue.isEmpty();
	        if (isDone) {
	            System.out.printf("Tried depth %d but failed to find solution, trying depth %d ...\n",
	                    queue.depth, queue.depth + 1);
	            queue.depth++;
	            queue.reset();
	        }
	        return false;
	    }

		@Override
		void MakeQueue() {
			// TODO Auto-generated method stub
			queue = new LimitedSearch(this.InitialState, 0);
			
		}



		@Override
		public void AddNode(Node n) {
			// TODO Auto-generated method stub
			queue.AddNode(n);
		}
}
