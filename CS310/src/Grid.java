public class Grid {
	int row = 10;								//set initial row size
	int col = 6;								//set initial column size
	Node grid[][] = new Node[row][col];			//initialize the grid 10 rows i X 6 columns j
	Node head = grid[0][0];						//set head node to (0,0)
	Node rCurrent = head;
	Node dCurrent = head;
	

	//constructs the default grid
	//ONLY PLACE ALLOWED TO MAINPULATE ARRAYS
	public Grid(){				
		//Set up pointers column by column, row by row
		for(int i = 0;i<row;i++){
			for(int j = 0; j<col; j++){
				grid[i][j] = new Node();				//initializes Node
				
				if(j+1==col){								//if statement to catch error for columns
					grid[i][j].right = grid[i][0];
				}
				else{
					grid[i][j+1] = new Node();
					grid[i][j].right = grid[i][j+1];	//set node a to point right to node b
					grid[i][j+1].right = grid[i][0];	//set node b to point right to head of row
				}
				
				
				if(i+1 == row){							//if statement to catch error for rows
					grid[i][j].down = grid[0][j];
				}
				else{

					grid[i+1][j] = new Node();
					grid[i][j].down = grid[i+1][j];		//set node a to point down to node c
					grid[i+1][j].down = grid[0][j];		//set node c to point down to head of column
				}
			}
		}
		
	}//end grid() constructor
	
	//Display method
	//MUST ONLY USE POINTERS!!!!!!
	public void display(){
		
		System.out.print(String.format("%10s", ""));	//prints empty cell
		for(int k = 0; k<col;k++){						//prints column numbers
			System.out.print(String.format("%10s", "col "+k));
		}
		
		System.out.print("\n");							
		
		for(int i = 0; i < row;i++){						//prints row numbers
			System.out.print(String.format("%10s", "row "+i));
			System.out.print(head.toString());
			do{
							
			}
			while(dCurrent!=head);
			
				
				
				
			//displays fine but uses array not pointers starting at head
			/*if(grid[i][j].data.tag == "STR"){
				String s = grid[i][j].data.sval;
				System.out.print(String.format("%10s", s));
				}				}
			else if(grid[i][j].data.tag == "DBL"){
				double s = grid[i][j].data.dval;
				System.out.print(String.format("%10.4f", s));
				}*/
			System.out.print("\n");
			}
			
		}
		
	
	//use String.format("%10.4f", x) to format double output
	//use String.format("%10s", str) to format String output
	public static void main(String[] args){
		Grid a = new Grid();
		a.grid[0][0].data.dval = 15;
		a.display();
		
	}
}