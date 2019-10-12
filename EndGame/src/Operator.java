
public abstract class Operator {
	
	double Cost;
	String Type;
	
	public Operator(double Cost ,String type)
	{
		this.Cost=Cost;
		this.Type=type;
		
	}
	
	public String toString()
	{
		
		return Type;
	}
	
	public abstract Node ApplyOnNode(Node node);
	
	
	
	

}
