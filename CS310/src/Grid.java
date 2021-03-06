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
		
		for(int i = 0; i<rows+1;i++){		//set values to sub-grid rows X cols
			for(int j = 0; j<cols+1; j++){
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
	

	public void number(){
		Scanner scan = new Scanner(System.in);
		int frow, fcol, trow, tcol, rows, cols;
		int num = 0;
		String s;
		Value v = new Value();
		
		System.out.print("From row: ");
		frow = scan.nextInt();
		System.out.print("From column: ");
		fcol = scan.nextInt();
		System.out.print("To row: ");
		trow = scan.nextInt();
		System.out.print("To column: ");
		tcol = scan.nextInt();
		
		//determine size of sub-grid
		rows = trow - frow;
		cols = tcol - fcol;
		
		
		//move to initial node
		for(int i = 0; i!=frow; i++)
			rCurrent = rCurrent.down;
		for(int i = 0; i!=fcol;i++)
			rCurrent = rCurrent.right;
		
		//set dCurrent to head of sub-grid
		dCurrent = rCurrent;

		//populate sub-grid with numbers
		for(int i = 0; i<=rows; i++){
			for(int j = 0; j<=cols; j++){
				s = Integer.toString(num);
				v = v.checkInput(s);
				rCurrent.data = v;
				num++;
				
				rCurrent = rCurrent.right;
			}
			dCurrent = dCurrent.down;
			rCurrent = dCurrent;
		}
		num = 0;
	}//end number()
	
		/********************
		 ********Menu********
		 ********************/
	
	public static void menu(Grid a){
		rCurrent = head;
		dCurrent = head;
		topLine = head;
		leftLine = head;
			
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
					a.number();
					break;
				}
				case "a": {
					a.addNodes();
					break;
				}
				case "s": {
					a.subNodes();
					break;
				}
				case "m": {
					a.mulNodes();
					break;
				}
				case "d": {
					a.divNodes();
					break;
				}
				case "ar": {
					a.addRows();
					break;
				}
				case "sr": {
					a.subRows();
					break;
				}
				case "mr": {
					a.mulRows();
					break;
				}
				case "dr": {
					a.divRows();
					break;
				}
				case "ac": {
					a.addColumns();
					break;
				}
				case "sc": {
					a.subColumns();
					break;
				}
				case "mc": {
					a.mulColumns();
					break;
				}
				case "dc": {
					a.deleteColumn();
					break;
				}
				case "ir": {
					a.insertRow();
					break;
				}
				case "ic": {
					a.insertColumn();
					break;
				}
				case "delr": {
					a.deleteRow();
					break;
				}
				case "delc": {
					a.deleteColumn();
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
	
	public void addNodes(){
		int fr, fc, sr, sc, tr, tc;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("first row: ");
		fr = scan.nextInt();
		System.out.print("first column: ");
		fc = scan.nextInt();
		System.out.print("second row: ");
		sr = scan.nextInt();
		System.out.print("second column: ");
		sc = scan.nextInt();
		System.out.print("target row: ");
		tr = scan.nextInt();
		System.out.print("target column: ");
		tc = scan.nextInt();
		
		//point rCurrent to first target
		for(int i = 0; i != fr; i++){
			rCurrent = rCurrent.down;
		}
		for(int i = 0; i != fc; i++){
			rCurrent = rCurrent.right;
		}
		
		//point dCurrent to second target
		for(int i = 0; i != sr; i++){
			dCurrent = dCurrent.down;
		}
		for(int i = 0; i != sc; i++){
			dCurrent = dCurrent.right;
		}
		
		//point to target
		for(int i = 0; i != tr; i++){
			topLine = topLine.down;
		}
		for(int i = 0; i != tc; i++){
			topLine = topLine.right;
		}
		topLine.data = topLine.data.plus(rCurrent.data, dCurrent.data);
	}
	public void subNodes(){
		int fr, fc, sr, sc, tr, tc;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("first row: ");
		fr = scan.nextInt();
		System.out.print("first column: ");
		fc = scan.nextInt();
		System.out.print("second row: ");
		sr = scan.nextInt();
		System.out.print("second column: ");
		sc = scan.nextInt();
		System.out.print("target row: ");
		tr = scan.nextInt();
		System.out.print("target column: ");
		tc = scan.nextInt();
		
		//point rCurrent to first target
		for(int i = 0; i != fr; i++){
			rCurrent = rCurrent.down;
		}
		for(int i = 0; i != fc; i++){
			rCurrent = rCurrent.right;
		}
		
		//point dCurrent to second target
		for(int i = 0; i != sr; i++){
			dCurrent = dCurrent.down;
		}
		for(int i = 0; i != sc; i++){
			dCurrent = dCurrent.right;
		}
		
		//point to target
		for(int i = 0; i != tr; i++){
			topLine = topLine.down;
		}
		for(int i = 0; i != tc; i++){
			topLine = topLine.right;
		}
		topLine.data = topLine.data.minus(rCurrent.data, dCurrent.data);
	}
	
	public void mulNodes(){
		int fr, fc, sr, sc, tr, tc;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("first row: ");
		fr = scan.nextInt();
		System.out.print("first column: ");
		fc = scan.nextInt();
		System.out.print("second row: ");
		sr = scan.nextInt();
		System.out.print("second column: ");
		sc = scan.nextInt();
		System.out.print("target row: ");
		tr = scan.nextInt();
		System.out.print("target column: ");
		tc = scan.nextInt();
		
		//point rCurrent to first target
		for(int i = 0; i != fr; i++){
			rCurrent = rCurrent.down;
		}
		for(int i = 0; i != fc; i++){
			rCurrent = rCurrent.right;
		}
		
		//point dCurrent to second target
		for(int i = 0; i != sr; i++){
			dCurrent = dCurrent.down;
		}
		for(int i = 0; i != sc; i++){
			dCurrent = dCurrent.right;
		}
		
		//point to target
		for(int i = 0; i != tr; i++){
			topLine = topLine.down;
		}
		for(int i = 0; i != tc; i++){
			topLine = topLine.right;
		}
		topLine.data = topLine.data.star(rCurrent.data, dCurrent.data);
	}
	public void divNodes(){
		int fr, fc, sr, sc, tr, tc;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("first row: ");
		fr = scan.nextInt();
		System.out.print("first column: ");
		fc = scan.nextInt();
		System.out.print("second row: ");
		sr = scan.nextInt();
		System.out.print("second column: ");
		sc = scan.nextInt();
		System.out.print("target row: ");
		tr = scan.nextInt();
		System.out.print("target column: ");
		tc = scan.nextInt();
		
		//point rCurrent to first target
		for(int i = 0; i != fr; i++){
			rCurrent = rCurrent.down;
		}
		for(int i = 0; i != fc; i++){
			rCurrent = rCurrent.right;
		}
		
		//point dCurrent to second target
		for(int i = 0; i != sr; i++){
			dCurrent = dCurrent.down;
		}
		for(int i = 0; i != sc; i++){
			dCurrent = dCurrent.right;
		}
		
		//point to target
		for(int i = 0; i != tr; i++){
			topLine = topLine.down;
		}
		for(int i = 0; i != tc; i++){
			topLine = topLine.right;
		}
		topLine.data = topLine.data.slash(rCurrent.data, dCurrent.data);
	}
	
	/********************
	 ***Row Arithmetic*** 
	 ********************/
	
	public void addRows(){
		int fr, sr, tr;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("first row: ");
		fr = scan.nextInt();
		System.out.print("second row: ");
		sr = scan.nextInt();
		System.out.print("target row: ");
		tr = scan.nextInt();
		
		//point rCurrent to first row
		for(int i = 0; i != fr; i++){
			rCurrent = rCurrent.down;
		}
		//point dCurrent to second row
		for(int i = 0; i != sr; i++){
			dCurrent = dCurrent.down;
		}
		//point topLine to target row
		for(int i = 0; i != tr; i++){
			topLine = topLine.down;
		}
		
		for(int i = 0; i<=col; i++){
			topLine.data = topLine.data.plus(rCurrent.data, dCurrent.data);
			rCurrent = rCurrent.right;
			dCurrent = dCurrent.right;
			topLine = topLine.right;
			
		}
	}
	public void subRows(){
		int fr, sr, tr;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("first row: ");
		fr = scan.nextInt();
		System.out.print("second row: ");
		sr = scan.nextInt();
		System.out.print("target row: ");
		tr = scan.nextInt();
		
		//point rCurrent to first row
		for(int i = 0; i != fr; i++){
			rCurrent = rCurrent.down;
		}
		//point dCurrent to second row
		for(int i = 0; i != sr; i++){
			dCurrent = dCurrent.down;
		}
		//point topLine to target row
		for(int i = 0; i != tr; i++){
			topLine = topLine.down;
		}
		
		for(int i = 0; i<=col; i++){
			topLine.data = topLine.data.minus(rCurrent.data, dCurrent.data);
			rCurrent = rCurrent.right;
			dCurrent = dCurrent.right;
			topLine = topLine.right;
			
		}
	}
	public void mulRows(){
		int fr, sr, tr;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("first row: ");
		fr = scan.nextInt();
		System.out.print("second row: ");
		sr = scan.nextInt();
		System.out.print("target row: ");
		tr = scan.nextInt();
		
		//point rCurrent to first row
		for(int i = 0; i != fr; i++){
			rCurrent = rCurrent.down;
		}
		//point dCurrent to second row
		for(int i = 0; i != sr; i++){
			dCurrent = dCurrent.down;
		}
		//point topLine to target row
		for(int i = 0; i != tr; i++){
			topLine = topLine.down;
		}
		
		for(int i = 0; i<=col; i++){
			topLine.data = topLine.data.star(rCurrent.data, dCurrent.data);
			rCurrent = rCurrent.right;
			dCurrent = dCurrent.right;
			topLine = topLine.right;
			
		}
	}
	public void divRows(){
		int fr, sr, tr;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("first row: ");
		fr = scan.nextInt();
		System.out.print("second row: ");
		sr = scan.nextInt();
		System.out.print("target row: ");
		tr = scan.nextInt();
		
		//point rCurrent to first row
		for(int i = 0; i != fr; i++){
			rCurrent = rCurrent.down;
		}
		//point dCurrent to second row
		for(int i = 0; i != sr; i++){
			dCurrent = dCurrent.down;
		}
		//point topLine to target row
		for(int i = 0; i != tr; i++){
			topLine = topLine.down;
		}
		
		for(int i = 0; i<=col; i++){
			topLine.data = topLine.data.slash(rCurrent.data, dCurrent.data);
			rCurrent = rCurrent.right;
			dCurrent = dCurrent.right;
			topLine = topLine.right;
			
		}
	}
	
	/***********************
	 ***Column Arithmetic*** 
	 ***********************/
	
	public void addColumns(){
		int fc, sc, tc;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("first column: ");
		fc = scan.nextInt();
		System.out.print("second column: ");
		sc = scan.nextInt();
		System.out.print("target column: ");
		tc = scan.nextInt();
		
		//point rCurrent to first column
		for(int i = 0; i != fc; i++){
			rCurrent = rCurrent.right;
		}
		//point dCurrent to second row
		for(int i = 0; i != sc; i++){
			dCurrent = dCurrent.right;
		}
		//point topLine to target row
		for(int i = 0; i != tc; i++){
			topLine = topLine.right;
		}
		
		for(int i = 0; i<=col; i++){
			topLine.data = topLine.data.plus(rCurrent.data, dCurrent.data);
			rCurrent = rCurrent.down;
			dCurrent = dCurrent.down;
			topLine = topLine.down;
			
		}
	}
	public void subColumns(){
		int fc, sc, tc;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("first column: ");
		fc = scan.nextInt();
		System.out.print("second column: ");
		sc = scan.nextInt();
		System.out.print("target column: ");
		tc = scan.nextInt();
		
		//point rCurrent to first column
		for(int i = 0; i != fc; i++){
			rCurrent = rCurrent.right;
		}
		//point dCurrent to second row
		for(int i = 0; i != sc; i++){
			dCurrent = dCurrent.right;
		}
		//point topLine to target row
		for(int i = 0; i != tc; i++){
			topLine = topLine.right;
		}
		
		for(int i = 0; i<=col; i++){
			topLine.data = topLine.data.minus(rCurrent.data, dCurrent.data);
			rCurrent = rCurrent.down;
			dCurrent = dCurrent.down;
			topLine = topLine.down;
			
		}
	}
	public void mulColumns(){
		int fc, sc, tc;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("first column: ");
		fc = scan.nextInt();
		System.out.print("second column: ");
		sc = scan.nextInt();
		System.out.print("target column: ");
		tc = scan.nextInt();
		
		//point rCurrent to first column
		for(int i = 0; i != fc; i++){
			rCurrent = rCurrent.right;
		}
		//point dCurrent to second row
		for(int i = 0; i != sc; i++){
			dCurrent = dCurrent.right;
		}
		//point topLine to target row
		for(int i = 0; i != tc; i++){
			topLine = topLine.right;
		}
		
		for(int i = 0; i<=col; i++){
			topLine.data = topLine.data.star(rCurrent.data, dCurrent.data);
			rCurrent = rCurrent.down;
			dCurrent = dCurrent.down;
			topLine = topLine.down;
			
		}
	}
	public void divColumns(){
		int fc, sc, tc;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("first column: ");
		fc = scan.nextInt();
		System.out.print("second column: ");
		sc = scan.nextInt();
		System.out.print("target column: ");
		tc = scan.nextInt();
		
		//point rCurrent to first column
		for(int i = 0; i != fc; i++){
			rCurrent = rCurrent.right;
		}
		//point dCurrent to second row
		for(int i = 0; i != sc; i++){
			dCurrent = dCurrent.right;
		}
		//point topLine to target row
		for(int i = 0; i != tc; i++){
			topLine = topLine.right;
		}
		
		for(int i = 0; i<=col; i++){
			topLine.data = topLine.data.slash(rCurrent.data, dCurrent.data);
			rCurrent = rCurrent.down;
			dCurrent = dCurrent.down;
			topLine = topLine.down;
			
		}
	}
	
	/*********************
	 ****Insert/Delete**** 
	 *********************/
	
	public void insertRow(){
		int tempRow;
		Scanner scan = new Scanner(System.in);
		System.out.print("row: ");
		
		tempRow = scan.nextInt();
		
		//move rCurrent to row before inserted row
		for(int i =0; i<tempRow-1; i++){
			rCurrent = rCurrent.down;
		}
		//move dCurrent to row to be inserted
		for(int i = 0; i<=tempRow-1; i++){
			dCurrent = dCurrent.down;
		}
		
		topLine = rCurrent;				//set top line to above insert
		topLine.down = new Node();		//create start of new row
		topLine.down.down = dCurrent;	//point start of new row down
		
		rCurrent = topLine.down;		//point rCurrent to iterate
		leftLine = topLine.down;		//point leftLine for row head
		
		//create linked list with rcurrent above and dcurrent below
		for(int i = 0; i<=col;i++){
			rCurrent.right = new Node();		//create new node
			rCurrent = rCurrent.right;			//point rCurrent to new node
			topLine = topLine.right;			//point topLine above
			dCurrent = dCurrent.right;			//point dCurrent below
			
			topLine.down = rCurrent;			//point topLine down to rCurrent
			rCurrent.down = dCurrent;			//point rcurrent down to dCurrent
			if(i == col){
				rCurrent.right = leftLine;
			}	
		}
		row++;
	}
	public void insertColumn(){
		int tempCol;
		Scanner scan = new Scanner(System.in);
		System.out.print("row: ");
		
		tempCol = scan.nextInt();
		
		//move rCurrent to row before inserted row
		for(int i =0; i<tempCol-1; i++){
			rCurrent = rCurrent.right;
		}
		//move dCurrent to row to be inserted
		for(int i = 0; i<=tempCol-1; i++){
			dCurrent = dCurrent.right;
		}
		
		topLine = rCurrent;				//set top line to above insert
		topLine.right = new Node();		//create start of new row
		topLine.right.right = dCurrent;	//point start of new row down
		
		rCurrent = topLine.right;		//point rCurrent to iterate
		leftLine = topLine.right;		//point leftLine for row head
		
		//create linked list with rcurrent above and dcurrent below
		for(int i = 0; i<=col;i++){
			rCurrent.down = new Node();		//create new node
			rCurrent = rCurrent.down;			//point rCurrent to new node
			topLine = topLine.down;			//point topLine above
			dCurrent = dCurrent.down;			//point dCurrent below
			
			topLine.right = rCurrent;			//point topLine down to rCurrent
			rCurrent.right = dCurrent;			//point rcurrent down to dCurrent
			if(i == col){
				rCurrent.down = leftLine;
			}	
		}
		col++;
		
		
		
		
		
		
		
		
		/*int tempCol;
		Scanner scan = new Scanner(System.in);
		System.out.print("column: ");
		
		tempCol = scan.nextInt();
		
		//move rCurrent to column before inserted column
		for(int i =0; i<tempCol; i++){
			rCurrent = rCurrent.right;
		}
		//move dCurrent to column to be inserted
		for(int i = 0; i<=tempCol; i++){
			dCurrent = dCurrent.right;
		}
		
		leftLine = rCurrent;
		leftLine.right = new Node();
		leftLine.right.right = dCurrent;
		
		rCurrent = leftLine.right;
		topLine = leftLine.right;
		
		for(int i = 0; i<row;i++){
			if(i == row){
				rCurrent.down = topLine;
			}
			else{
				rCurrent.down = new Node();		//create new node below
				rCurrent = rCurrent.down;		//point rCurrent to new node
				leftLine = leftLine.down;		//point left line to next down
				dCurrent = dCurrent.down;		//point dCurrent to next down
				
				leftLine.right = rCurrent;		//
				rCurrent.right = dCurrent;
				System.out.println("worked");
			}
		}
		col++;*/
	}
	public void deleteRow(){
		int tempRow;
		Scanner scan = new Scanner(System.in);
		System.out.print("row: ");
		
		tempRow = scan.nextInt();
		
		//move rCurrent to row before inserted row
		for(int i =0; i<tempRow; i++){
			rCurrent = rCurrent.down;
		}
		//move dCurrent to row to be inserted
		for(int i = 0; i<=tempRow+1; i++){
			dCurrent = dCurrent.down;
		}
		for(int i = 0; i!=tempRow; i++){
			rCurrent.down = dCurrent;
		}
		row--;
	}
	
	public void deleteColumn(){
		int tempCol;
		Scanner scan = new Scanner(System.in);
		System.out.print("column: ");
		
		tempCol = scan.nextInt();
		
		//move rCurrent to row before inserted row
		for(int i =0; i<tempCol; i++){
			rCurrent = rCurrent.right;
		}
		//move dCurrent to row to be inserted
		for(int i = 0; i<=tempCol+1; i++){
			dCurrent = dCurrent.right;
		}
		for(int i = 0; i!=tempCol; i++){
			rCurrent.right = dCurrent;
		}
		col--;
	}
	
		

	public static void main(String[] args){
		Grid a = new Grid();
		while(SENTINAL == true){
			menu(a);
		}
		System.out.println("\nPROCESS ENDED");
	}
}