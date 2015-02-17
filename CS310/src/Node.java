//ACCEPTS INPUT FOR NEW NODE AS Node(right pointer, down pointer)
public class Node {
	
	Node right, down;
	public Value data;
	
	//constructor for initial node
	public Node(){
		this.data = new Value();
	}
	
	//constructor for Node with no data
	public Node(Node r, Node d){
		this.right = r;
		this.down = d;
		this.data = new Value();
	}
	
	//constructor for new node with data
	public Node(Node r, Node d, Value v){
		this.right = r;
		this.down = d;
		this.data = v;
	}

	/** move to value class and make it accept value as parameter instead of node*/
	public String toString(Node v){
		if(v.data.tag == "DBL"){
			return (String.format("%10.4f", v.data.dval));}
		else if(v.data.tag == "STR"){
			return (String.format("%10s", v.data.sval));}
		else
			return(null);
	}

	
	/*public static void main(String[] args){
		Node v = new Node();
		System.out.println(v.toString(v));
	}*/
}
