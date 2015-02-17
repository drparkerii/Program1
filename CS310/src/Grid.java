public class Grid {
	int row = 10;								//set initial row size
	int col = 6;								//set initial column size
	Node grid[][] = new Node[50][50];			//initialize the grid
	Node head, rCurrent, dCurrent;
	

	//constructs the default grid
	//ONLY PLACE ALLOWED TO MAINPULATE ARRAYS
	public Grid(){	
		
		head = new Node();
		rCurrent = head;
		dCurrent = head;
		for(int i=0; i<row;i++){
			for(int j=0;j<col;j++){
				if(j+1==col){
					rCurrent.right = dCurrent;		//point last node to head
				}
				else{
				rCurrent.right = new Node();		//make new node to the right
				rCurrent = rCurrent.right;			//move to new node right
				}
			}
			dCurrent.down = new Node();			//make new node below
			dCurrent = dCurrent.down;			//move to new node below
			rCurrent = dCurrent;				//move rCurrent to beginning of new row
		}
		rCurrent = head;						//reset rCurrent to head
		dCurrent = head;						//reset dCurrent to head
	}//end grid() constructor
	
	//Display method
	//MUST ONLY USE POINTERS!!!!!!
	public void display(){
		
		System.out.print(String.format("%10s", ""));	//prints empty cell
		for(int k = 0; k<col;k++){						//prints column numbers
			System.out.print(String.format("%10s", "col "+k));
		}
		System.out.print("\n");							
		
		for(int i = 0; i < row;i++){							
			System.out.print(String.format("%10s", "row "+i));	//prints row numbers
			for(int j = 0; j<col;j++){
				System.out.print(rCurrent.toString(rCurrent));	//print rCurrent
				rCurrent = rCurrent.right;						//move rCurrent to the right
			}
		dCurrent = dCurrent.down;							//dCurrent moves down
		rCurrent = dCurrent;								//rCurrent moves to dCurrent
			
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