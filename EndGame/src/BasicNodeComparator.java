import java.util.Comparator;

public class BasicNodeComparator implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		Node n1=(Node) arg0;
		Node n2=(Node) arg1;
		return (int) (n1.Cost-n2.Cost);
		
	}

}
