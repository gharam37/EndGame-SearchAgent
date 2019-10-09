enum EndGameCellType implements CellType

{
	i,t,w,s,e; //goal,blocked,empty,player
	public EndGameCellType AssignI() {
		return i;
	}
	public EndGameCellType AssignT() {
		return t;
	}
	public EndGameCellType AssignW() {
		return w;
	}
	public EndGameCellType AssignS() {
		return s;
	}
	public EndGameCellType AssignE() {
		return e;
	}
}



public class EndGame extends GenericProblem{
	
	
	/*public Node [][] TranslateInputString(String Input){
		Node [][] Nodes ;
		
		
		
		return Nodes;
		
		
		
	}*/

}
