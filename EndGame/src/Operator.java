
public abstract class Operator {
	
	double Cost;
	String Type;
	
	public Operator(double Cost ,String type)
	{
		this.Cost=Cost;
		this.Type=Type;
		
	}
	
	public String toString()
	{
		
		return Type+" "+Cost;
	}
	
	public abstract Node ApplyOnNode(Node node);
	
	
	
	

}
