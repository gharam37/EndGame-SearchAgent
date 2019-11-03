import java.util.*;
public abstract class StrategyQueue {
	State InitialState;
	HashSet<String> States=new HashSet<String>  ();
	MainHeuristic PossibleHeuristic;
	
	public StrategyQueue(State InitialState)
	{
		this.InitialState=InitialState;
		 this.States = new HashSet<String> ();
	     Node FirstNode = new Node(this.InitialState);
	     MakeQueue();
	     AddNode(FirstNode);
		
	}
	public StrategyQueue(State InitialState,MainHeuristic PossibleHeuristic)
	{
		this.InitialState=InitialState;
		this.PossibleHeuristic=PossibleHeuristic;
		 this.States = new HashSet<String> ();
	     Node FirstNode = new Node(this.InitialState);
	    // System.out.println(FirstNode);
	     MakeQueue();
	     AddNode(FirstNode);
	}
	
	
	abstract void MakeQueue();

    public abstract Node RemoveFront();


	
	public void EnqueueNodes(ArrayList<Node> newNodes)
	{
		for(int i=0;i<newNodes.size();i++)
		{
			AddNode(newNodes.get(i));
		}
	}

	public abstract void AddNode(Node n);

	public abstract boolean isEmpty();
	
	 void ReMakeQueue() {
		 this.States = new HashSet<String> ();
	     Node FirstNode = new Node(this.InitialState);
	     MakeQueue();
	     AddNode(FirstNode);
	}		
	
	

}
