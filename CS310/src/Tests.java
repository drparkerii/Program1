
public class Tests {

	//test for Node class
	/*public static void main(String[] args){
		
		Node aa = new Node();
		aa.right = new Node();
		Node ab = aa.right;
		ab.right = new Node();
		Node bc = ab.right;
		
		//testing calling dval
		aa.data.dval = 1;
		ab.data.dval = 2;
		bc.data.dval = 3;
		
		
		System.out.println(aa.data.dval);
		System.out.println(ab.data.dval);
		System.out.println(bc.data.dval);
		System.out.println("");
		
		//testing calling sval
		aa.data.sval = "a";
		ab.data.sval = "b";
		bc.data.sval = "c";
		
		
		System.out.println(aa.data.sval);
		System.out.println(ab.data.sval);
		System.out.println(bc.data.sval);
		System.out.println("");
		
		//testing right pointer
		aa.right = ab;
		ab.right = bc;
		bc.right = aa;
		
		System.out.println(aa.right.data.dval);
		System.out.println(ab.right.data.dval);
		System.out.println(bc.right.data.dval);
		System.out.println("");
		
		//testing down pointer
		aa.down = ab;
		ab.down = bc;
		bc.down = aa;
		
		System.out.println(aa.down.data.dval);
		System.out.println(ab.down.data.dval);
		System.out.println(bc.down.data.dval);
		System.out.println("");
		
		Node cd = new Node(ab,bc);
		System.out.println(cd.right.data.dval);
		
		//testing toString()
		aa.toString(aa);
		ab.toString(ab);
		bc.toString(bc);
		
	}*/
	
	
	//test for Value class
	
	/*public static void main(String[] args){
		Value v = new Value();
		Value u = new Value();
		//test that basic values work
		u.dval = 10;
		u.sval = "hello";
		u.tag = "DBL";
		
		System.out.println(u.dval);	//10.0
		System.out.println(u.sval);	//hello
		System.out.println(u.tag);	//DBL
		System.out.println("");

		
		v.dval = 15;
		v.sval = "world";
		v.tag = "DBL";
		
		System.out.println(v.dval);	//15.0
		System.out.println(v.sval);	//world
		System.out.println(v.tag);	//DBL
		System.out.println("");

		
		//test arithmetic
		Value add = v.plus(u);		//25  
		Value sub = v.minus(u); 	//5
		Value mult = v.star(u); 	//150
		Value divi = v.slash(u);	//1.5
		
		System.out.println(add.dval);
		System.out.println(sub.dval);
		System.out.println(mult.dval);
		System.out.println(divi.dval);

		

	}*/
	
	//test for grid class
	/*public static void main(String[] args){
	  Grid a = new Grid();
	  System.out.println(a.head.toString(a.head));
	 
	  }*/
	
	//testing linked list to the right
	/*public static void main(String[] args){
		Node head = new Node();
		Node pointer = head;
		pointer.data.sval = "0";
		head.right = pointer;

		for(int i = 0; i<6; i++){
			pointer.right = new Node();
			pointer.data.sval = ""+i;
			pointer = pointer.right;
		}
		pointer.right = head;
		
		for(int j = 0; j<6; j++){
			System.out.print(pointer.toString(pointer));
			pointer = pointer.right;
		}
		
	}*/
	
	//testing linked list down
	public static void main(String[] args){
		
		
		
	}
}
