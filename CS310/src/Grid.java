public class Grid {
	int row = 10;								//set initial row size
	int col = 6;								//set initial column size
	Node grid[][] = new Node[50][50];			//initialize the grid
	Node head, rCurrent, dCurrent;
	

	//constructs the default grid
	//ONLY PLACE ALLOWED TO MAINPULATE ARRAYS
	public Grid(){				
		//Set up pointers column by column, row by row
		for(int i = 0;i<row;i++){
			for(int j = 0; j<col; j++){
				grid[i][j] = new Node();				//initializes Nodes in the grid
			}
		}
		for(int k = 0;k<row;k++){
			for(int l = 0; l<col; l++){
				
				if(l+1==col){								//if statement to catch error for columns
					grid[k][l].right = grid[k][0];
				}
				else{
					//grid[k][l+1] = new Node();
					grid[k][l].right = grid[k][l+1];	//set node a to point right to node b
					grid[k][l+1].right = grid[k][0];	//set node b to point right to head of row
				}
				
				
				if(k+1 == row){							//if statement to catch error for rows
					grid[k][l].down = grid[0][l];
				}
				else{
					//grid[k+1][l] = new Node();
					grid[k][l].down = grid[k+1][l];		//set node a to point down to node c
					grid[k+1][l].down = grid[0][l];		//set node c to point down to head of column
				}
			}
			
		}
		head = grid[0][0];						//set head node to (0,0)
		rCurrent = head;
		dCurrent = head;	
		
		
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
			System.out.print(head.toString(head));
			do{
				System.out.print(rCurrent.toString(rCurrent));			
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
		a.display();
		//System.out.println(a.head.toString(a.head));
		
	}
}