import java.util.*;
public abstract class StrategyQueue {
	State InitialState;
	HashMap<String,Integer> States=new HashMap<String,Integer> ();
	
	public StrategyQueue(State InitialState)
	{
		this.InitialState=InitialState;
		 this.States = new HashMap<String,Integer> ();
	     Node FirstNode = new Node(this.InitialState);
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
	
			
	
	

}
