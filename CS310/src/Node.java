//ACCEPTS INPUT FOR NEW NODE AS Node(right pointer, down pointer)
public class Node {
	Node right, down;
	Value data;
	//constructor for initial node
	public Node(){

		this.data = new Value();
	}
	
	//constructor for Node with no data
	public Node(Node r, Node d){
		right = r;
		down = d;
		data = new Value();
	}
	
	//constructor for new node with data
	public Node(Node r, Node d, Value v){
		right = r;
		down = d;
		data = v;
	}
}
