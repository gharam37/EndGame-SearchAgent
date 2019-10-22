import java.util.Stack;

public class IterativeDeepSearch extends StrategyQueue {
	 
	//private LimitedSearch Nodes;
	 private Stack<Node> Nodes;
	    int depth=0;

	    public IterativeDeepSearch(State initialState) {
	        super(initialState);
	    }


	    @Override
	    public Node RemoveFront() {
	    	
	    	Node node=null;
	    	 if (isEmpty() ) {
		            return node;
		        }
	    	 if(Nodes!=null) {
		         node = Nodes.pop();

	    	 
		        boolean BeenHere = States.containsKey(node.CurrentState.UniqueKey)
		                && States.get(node.CurrentState.UniqueKey).depth <= node.Depth;
		        if( States.get(node.CurrentState.UniqueKey)!=null) {
		        	//System.out.println(States.get(node.CurrentState.UniqueKey).depth);
		        	//System.out.println(this.depth);

		        	
		        	
		        }
		        boolean CrossedDepth = node.Depth > this.depth;
		        boolean result= CrossedDepth||BeenHere;
		        
		        if (result) {
		        	return null;

		        }

		        States.put(node.CurrentState.UniqueKey, node.CurrentState);
		        return node;
		    }
	    	 return null;

	    }
	    


	    @Override
	    public boolean isEmpty() {
	        if (Nodes.isEmpty()) {
	            System.out.println("failed at depth "+this.depth+" going to depth "+(this.depth+1));
	            depth++;
	            ReMakeQueue();
	        }
	        return false;
	    }
	    
	    public boolean FinishedDepth() {
	    	return false;
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
