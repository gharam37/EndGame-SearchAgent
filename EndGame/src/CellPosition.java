
public class CellPosition {

	int CellX=0;
	int CellY=0;
	public CellPosition(int x,int y)
	{
		CellX=x;
		CellY=y;
	}
	public String toString()
	{
		return "x: "+CellX+" y: "+CellY;
	}
	/*@Override
	public int compareTo(Object arg0) {
		CellPosition c=(CellPosition)arg0;
		// TODO Auto-generated method stub
		return 0;
	}*/

}
