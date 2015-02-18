import java.util.Scanner;

public class Grid {
	static final Node head = new Node();
	static Value tempVal;
	static Node rCurrent, dCurrent, topLine, leftLine;
	static Grid b;
	static boolean SENTINAL = true;
	int row = 10;								//set initial row size
	int col = 6;								//set initial column size
	
	/***************
	 **Constructor**
	 ***************/
	
	public Grid(){	
		//head = new Node();				//make new node at head
		rCurrent = head;				//point rCurrent to head
		dCurrent = head;				//point dCurrnet to head
		for(int i=0; i<row;i++){
				for(int j=0;j<col;j++){
					if(j+1==col){
						rCurrent.right = dCurrent;		//point last node or row to head of row
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
		rCurrent = head;						//set rCurrent to head.right
		dCurrent = head.down;						//set dCurrent to head.down.right
		topLine = head;
		leftLine = head;
		
		for(int i = 0; i<row; i++){
			for(int j = 0; j<col;j++){				//setting down pointers
				if(i+2 == row)	{
					dCurrent.down = topLine;		//set bottom node to head of column
					topLine = topLine.right;		//moves topLine to the right
					dCurrent = dCurrent.right;		//moves dCurrent right
				}
				else{
					rCurrent.down = dCurrent;		//link rCurrent to dCurrent
					rCurrent = rCurrent.right;		//move rCurrent right
					dCurrent = dCurrent.right;		//move dCurrent right
				}
			}
			leftLine = leftLine.down;				//move left line pointer down
			rCurrent = leftLine;					//set rCurrent to beginning of next row
			dCurrent = leftLine.down;				//set dCurrent to beginning of next row + 1
		}
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

	public void fill(){
		Scanner scan = new Scanner(System.in);
		int frow, fcol, trow, tcol, rows, cols;
		String temp;
		Value v = new Value();
		
		System.out.print("from row: ");
		frow = scan.nextInt();
		System.out.print("from column: ");
		fcol = scan.nextInt();
		System.out.print("to row: ");
		trow = scan.nextInt();
		System.out.print("to column: ");
		tcol = scan.nextInt();
		System.out.print("with value: ");
		temp = scan.next();
		v = v.checkInput(temp);
		
		rows = trow - frow;
		cols = tcol - fcol;
		
		//move down then right to start Node
		for(int i = 0; i!=frow; i++)
			rCurrent = rCurrent.down;
		for(int i = 0; i!=fcol;i++)
			rCurrent = rCurrent.right;
		
		dCurrent = rCurrent;				//set dCurrent to start of sub-grid
		
		for(int i = 0; i<=rows;i++){		//set values to sub-grid rows X cols
			for(int j = 0; j<=cols; j++){
				rCurrent.data = v;			//add value to current node
				rCurrent = rCurrent.right;	//move right
			}
			dCurrent = dCurrent.down;		//move down a row
			rCurrent = dCurrent;			//point rCurrent to next row
		}
		
	}//end fill()
	
	
	public void assignCell(){
		Scanner scan = new Scanner(System.in);
		int rowNum, columnNum;
		String temp;
		Value v = new Value();
		
		System.out.print("row: ");
		rowNum = scan.nextInt();
		System.out.print("column: ");
		columnNum = scan.nextInt();
		System.out.print("value: ");
		temp = scan.next();
		v = v.checkInput(temp);
		
		//move down then right to indicated Node
		for(int i = 0; i!=rowNum; i++)
			rCurrent = rCurrent.down;
		for(int i = 0; i!=columnNum;i++)
			rCurrent = rCurrent.right;

		//set current.data to input
		rCurrent.data = v;		
	}//end assignCell()
	

	public Grid number(Grid a){
		Scanner scan = new Scanner(System.in);
		int frow, fcol, trow, tcol;
		int num = 0;
		
		System.out.print("From row: ");
		frow = scan.nextInt();
		System.out.print("From column: ");
		fcol = scan.nextInt();
		System.out.print("To column: ");
		trow = scan.nextInt();
		System.out.print("To column: ");
		tcol = scan.nextInt();
		
		//move to initial node
		for(int i = 0; i!=frow; i++)
			rCurrent = rCurrent.down;
		for(int i = 0; i!=fcol;i++)
			rCurrent = rCurrent.right;
		
		dCurrent = rCurrent;
		
		//determine size of subgrid
		int rows = trow - frow;
		int cols = tcol - fcol;

		for(int i = 0; i!=rows; i++){
			for(int j = 0; j!=cols; j++){
				//put number into dval value
				Value v = new Value();
				rCurrent.data = v;
				num++;
			}
		}
		
		
		
		
		return(b);
		
		
	}//end number()
	
		/********************
		 ********Menu********
		 ********************/
	
	public static void menu(Grid a){
		rCurrent = head;
		dCurrent = head;
			
			System.out.print("\n");
			System.out.println("Operations");
			System.out.println("  display          dis	        assign cell      as");
			System.out.println("  fill		   f		number           n");
			System.out.println("  add cells	   a		subtract cells	 s");
			System.out.println("  multiply cells   m		divide cells	 d");
			System.out.println("  add rows	   ar		subtract rows	 sr");
			System.out.println("  multiply rows	   mr		divide rows	 dr");
			System.out.println("  add columns	   ac		subtract columns sc");
			System.out.println("  multiply columns mc		divide columns	 dc");
			System.out.println("  insert row	   ir		insert column	 ic");
			System.out.println("  delete row	   delr         delete column	 delc");
			System.out.println("  quit	           q");
			
			Scanner input = new Scanner(System.in);
			System.out.print("->");
			String read = input.nextLine();
			switch(read){
				case "dis": {
					a.display();
					break;
				}
				case "f": {
					a.fill();
					break;
				}
				case "as":{
					a.assignCell();
					break;
				}
				case "n": {
					a.number(a);
					break;
				}
				case "a": {
					break;
				}
				case "s": {
					break;
				}
				case "m": {
					break;
				}
				case "d": {
					break;
				}
				case "ar": {
					break;
				}
				case "sr": {
					break;
				}
				case "mr": {
					break;
				}
				case "dr": {
					break;
				}
				case "ac": {
					break;
				}
				case "sc": {
					break;
				}
				case "mc": {
					break;
				}
				case "dc": {
					break;
				}
				case "ir": {
					break;
				}
				case "ic": {
					break;
				}
				case "delr": {
					break;
				}
				case "delc": {
					break;
				}
				case "q":{
					SENTINAL = false;
					break ;
				}
				default:{
					System.out.println("That is not valid option.");
					break;
				}
			}//end switch
	}//end menu()
	
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
		while(SENTINAL == true){
			menu(a);
		}
		System.out.println("\nPROCESS ENDED");
	}
}