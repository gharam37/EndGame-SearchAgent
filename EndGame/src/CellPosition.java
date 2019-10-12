
public class CellPosition implements Comparable{

	int CellX=0;
	int CellY=0;
	public CellPosition(int x,int y)
	{
		CellX=x;
		CellY=y;
	}
	public String toString()
	{
		return CellX+","+CellY;
	}
	/*@Override
	public int compareTo(Object arg0) {
		CellPosition c=(CellPosition)arg0;
		// TODO Auto-generated method stub
		return 0;
	}*/
	@Override
	public int compareTo(Object o) {
		CellPosition c= (CellPosition) o;
		if (c.CellX == this.CellX) {
            return this.CellY - c.CellY;
        }
        return  this.CellX - c.CellX;
	}

}
