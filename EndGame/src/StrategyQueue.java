import java.util.*;
public abstract class StrategyQueue {
	State InitialState;
	HashMap<State,Integer> States=new HashMap<State,Integer> ();
	
	public StrategyQueue(State InitialState)
	{
		this.InitialState=InitialState;
		
	}
	
	abstract void MakeQueue();

    public abstract Node RemoveFront();

	public abstract void AddNode(Node n);

	public abstract boolean isEmpty();
	

	
	public void EnqueueNodes(ArrayList<Node> newNodes)
	{
		for(int i=0;i<newNodes.size();i++)
		{
			AddNode(newNodes.get(i));
		}
	}
			
	
	

}
