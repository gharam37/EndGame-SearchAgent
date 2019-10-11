
public abstract class State  {

	
	public String StateRepresentation;
	//Don't allow repeated states
	
	public State(String StateRepresentation)
	{
		this.StateRepresentation=StateRepresentation;
	}
	public Boolean equals(State s) {
		
		return(this.StateRepresentation.equals(s.StateRepresentation));
	}
	
	//public abstract void Represent();
	
    public String  toString() {
    	
    	return StateRepresentation;
		
		
	}
    
    public abstract void Visualize();
	

	
	
}
