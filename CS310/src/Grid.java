import java.util.Scanner;

public class Grid {
	String stringTemp;
	double doubleTemp;
	int row = 10;								//set initial row size
	int col = 6;								//set initial column size
	Node head, rCurrent, dCurrent;
	
	/***************
	 **Constructor**
	 ***************/
	
	public Grid(){	
		head = new Node();				//make new node at head
		rCurrent = head;				//point rCurrent to head
		dCurrent = head;				//point dCurrnet to head
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

	
	/***********************
	 *****Basic methods*****
	 ***********************/
	
	//Display method
	public void display(){
		
		System.out.print(String.format("%10s", ""));	//prints empty cell
		for(int k = 0; k<col;k++){						//prints column numbers
			System.out.print(String.format("%10s", "col "+k));
		}
		System.out.print("\n");							
		
		for(int i = 0; i < row;i++){							
			System.out.print(String.format("%10s", "row "+i));	//prints row numbers
			for(int j = 0; j<col;j++){
				System.out.print(rCurrent.data.toString(rCurrent.data));	//print rCurrent
				rCurrent = rCurrent.right;						//move rCurrent to the right
			}
		dCurrent = dCurrent.down;							//dCurrent moves down
		rCurrent = dCurrent;								//rCurrent moves to dCurrent
			
		System.out.print("\n");
		}
			
	}//end display
	public static void checkInput(String s,Value v){
		
		Scanner input = new Scanner(System.in);		//instantiate scanner object
		String read = input.nextLine();				//read input
		
		boolean checkInput = read.startsWith("\"");		
		
		if(checkInput){								//check if input is string or double
			read = read.substring(1);				//cut out " from string
			v.sval = read;						//store to sval
			v.tag = "STR";						//change tag to string
		}
		else{
			double temp = Double.parseDouble(read);	//parse double from string
			v.dval = temp;					//store to dval
			v.tag = "DBL";					//change tag to double
		}
	}//end checkInput()
	
	public static void menu(){
		Scanner input = new Scanner(System.in);
		String read = input.nextLine();
		switch(read){
		case "dis": ;
		case "f": ;
		case "as": ;
		case "n": ;
		case "a": ;
		case "s": ;
		case "m": ;
		case "d": ;
		case "ar": ;
		case "sr": ;
		case "mr": ;
		case "dr": ;
		case "ac": ;
		case "sc": ;
		case "mc": ;
		case "dc": ;
		case "ir": ;
		case "ic": ;
		case "delr": ;
		case "delc": ;
		case "q": break ;
		default: {System.out.println("That is not valid option.");
			}
		
		}//end switch

		
	}

	public void fill(){
		
	}
	public void assignCell(){
		
	}
	public void number(){
		System.out.print("From row: ");
		
		
	}
	public void quit(){
		
	}
	
	/*********************
	 ***Node Arithmetic*** 
	 *********************/
	
	public double addNodes(){
		return 0;
	}
	public double subNodes(){
		return 0;
	}
	public double mulNodes(){
		return 0;
	}
	public double divNodes(){
		return 0;
	}
	
	/********************
	 ***Row Arithmetic*** 
	 ********************/
	
	public double addRows(){
		return 0;
	}
	public double subRows(){
		return 0;
	}
	public double mulRows(){
		return 0;
	}
	public double divRows(){
		return 0;
	}
	
	/***********************
	 ***Column Arithmetic*** 
	 ***********************/
	
	public double addColumns(){
		return 0;
	}
	public double subColumns(){
		return 0;
	}
	public double mulColumns(){
		return 0;
	}
	public double divColumns(){
		return 0;
	}
	
	/*********************
	 ****Insert/Delete**** 
	 *********************/
	
	public void insertRow(){
		
	}
	public void insertColumn(){
		
	}
	public void deleteRow(){
		
	}
	public void deleteColumn(){
		
	}
	
		

	public static void main(String[] args){
		Grid a = new Grid();
		a.display();
	}
}