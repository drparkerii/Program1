import java.util.Scanner;

public class Grid {
	static Value tempVal;
	int row = 10;								//set initial row size
	int col = 6;								//set initial column size
	static Node head, rCurrent, dCurrent;
	
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
		
		rCurrent = head;
		dCurrent = head;
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
	

	

	public static void fill(){
		Scanner scan = new Scanner(System.in);
		int frow, fcol, trow, tcol;
		String temp;
		Value tempVal = new Value();
		
		System.out.print("from row: ");
		frow = scan.nextInt();
		System.out.print("from column: ");
		fcol = scan.nextInt();
		System.out.print("to row: ");
		trow = scan.nextInt();
		System.out.print("to column: ");
		tcol = scan.nextInt();
		System.out.print("prefix strings with \"\n");
		System.out.print("with value: ");
		temp = scan.next();
		tempVal = tempVal.checkInput(temp);
		
		

		
		
	}//end fill()
	public static void assignCell(){
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
		
		rCurrent = head;
		dCurrent = head;
		//moves right until at desired column then down the column
		for(int i = 0;i!=rowNum;i++){
			for(int j = 0; j!=columnNum; j++){
				rCurrent = rCurrent.right;
			}
			rCurrent = rCurrent.down;
		}
		Node cell = new Node(rCurrent.right,rCurrent.down,v);
		cell = rCurrent;
		
	}//end assignCell()
	public void number(){
		System.out.print("From row: ");
		System.out.print("From column: ");
		System.out.print("To column: ");
		System.out.print("To column: ");
		
		
	}//end number()
	
		/********************
		 ********Menu********
		 ********************/
	
	public static void menu(Grid a){
		boolean sentinal = true;
		while(sentinal == true){
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
					fill();
					break;
				}
				case "as":{
					assignCell();
					break;
				}
				case "n": {
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
					sentinal = false;
					break ;
				}
				default:{
					System.out.println("That is not valid option.");
					break;
				}
			}//end switch
		}//end while
		System.out.println("\nPROCESS ENDED");
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
		menu(a);
	}
}