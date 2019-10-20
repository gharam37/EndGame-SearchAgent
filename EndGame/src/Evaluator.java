import java.util.Comparator;

public class Evaluator implements Comparator{
	MainHeuristic heuristicFunction;
	String type;
	Evaluator(MainHeuristic heuristicFunction, String type) {
        this.heuristicFunction = heuristicFunction;
        this.type=type;
    }
	
	public int applyGreedy(Node node) {
        return heuristicFunction.apply(node);
    }
	
	public int applyAstar(Node node) {
        return (int) (this.heuristicFunction.apply(node) + node.Cost);
    }

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Node n1=(Node) o1;
		Node n2=(Node) o2;
		if(type.equals("Greedy")) {
			return applyGreedy(n1)-applyGreedy(n2);
		}else {
			return applyAstar(n1)-applyAstar(n2);
		}

	}

}
