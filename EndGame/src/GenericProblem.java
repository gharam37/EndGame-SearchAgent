import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class GenericProblem {

	
	public static ArrayList<Node> BFS(Node[][] InitialGrid,CellType goal,int [] playerStart,boolean Visualize) {
		
		 ArrayList<Node> output= new ArrayList<Node>();
		 
		 int GridX = InitialGrid.length;
		 int GridY = InitialGrid[0].length;

		 
		 
		
		Paint(Visualize,InitialGrid);
		/*int [] playerStart= {1,0};
		for(int i=0;i<InitialGrid.length;i++)
		{
			
			for(int j=0;j<InitialGrid[i].length;j++) {
				if(InitialGrid[i][j].type.equals(TestCell.p))
				{
					playerStart[0]=i;
					playerStart[1]=j;
					//System.out.println(InitialInitialGrid[i][j].type);

					
				}
			}
		}*/
		
		
	    Queue <int []> queue = new LinkedList <int[] > ();
	    queue.add(playerStart);
	    
	   // System.out.println(queue.peek());
	    while(queue.peek()!=null)
	    {
	    	int [] array=queue.remove();
	    	System.out.println(array[0]+""+array[1]);
	    	output.add(InitialGrid[array[0]][array[1]]);


            if(array[0]-1 >= 0 && !InitialGrid[array[0]-1][array[1]].visited ){

                if (InitialGrid[array[0]-1][array[1]].type == goal){
                	System.out.println("Found at"+ (array[0]-1) +array[1] );
                	return output;

                }
                else{
                	InitialGrid[array[0]-1][array[1]].visited = true;
                    int [] temp = {array[0]-1, array[1]};
                    queue.add(temp);
                }
            }

            if(array[1]-1 >= 0 && !InitialGrid[array[0]][array[1]-1].visited){

                if (InitialGrid[array[0]][array[1]-1].type ==  goal){
                	
                	System.out.println("Found" + array[0] + (array[1]-1));
                	return output;
                }
                else{
                    InitialGrid[array[0]][array[1]-1].visited =  true;
                    int [] temp = {array[0], array[1]-1};
                    queue.add(temp);
                }
            }

            if(array[1]+1 <GridY && !InitialGrid[array[0]][array[1]+1].visited){

                if (InitialGrid[array[0]][array[1]+1].type == goal){
                   System.out.println("Found at" + array[0] +(array[1]+1));
               	return output;

                }
                else{
                    InitialGrid[array[0]][array[1]+1].visited=true;
                    int [] temp = {array[0], array[1]+1};
                    queue.add(temp);
                }
            }

            if(array[0]+1 < GridY && !InitialGrid[array[0]+1][array[1]].visited){

                if (InitialGrid[array[0]+1][array[1]].type == goal){
                   System.out.println("Found at " +(array[0]+1) + array[1] );
               	return output;

                }
                else{
                    InitialGrid[array[0]+1][array[1]].visited=true;
                    int [] temp = {array[0]+1, array[1]};
                    queue.add(temp);
                }
            }
        } 
	    
	    
	    return output;

	//	System.out.println(playerStart[0]);
	//	System.out.println(playerStart[1]);

		
		//return null;
	}


	
	
	public static void Paint(boolean Do,Node[][] InitialGrid )
	{
		if(Do)
		{
			System.out.println(Arrays.deepToString(InitialGrid).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));


		}
		
	}
	
	
	public static void main(String[]args) {
		TestCell testCell=TestCell.g;
		
		Node n= new Node(testCell,0);
		
		Node[][] testGrid=new Node[][]
				{{new Node(testCell.AssignE(),0),new Node(testCell.AssignE(),0),new Node(testCell.AssignG(),0)},
				
				{new Node(testCell.AssignE(),0),new Node(testCell.AssignE(),0),new Node(testCell.AssignE(),0)},
				
				{new Node(testCell.AssignE(),0),new Node(testCell.AssignP(),0),new Node(testCell.AssignE(),0)}
				
				
				};
				
				
		int [] InitialPos= {2,1};
		System.out.println(BFS(testGrid,testCell.AssignG(),InitialPos, true));

				
		System.out.println("hi");
	}
	
}

enum TestCell implements CellType

{
	g,b,e,p; //goal,blocked,empty,player
	public TestCell AssignG() {
		return g;
	}
	public TestCell AssignB() {
		return b;
	}
	public TestCell AssignE() {
		return e;
	}
	public TestCell AssignP() {
		return p;
	}
}

