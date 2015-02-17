
public class Value {
	
	public double dval;
	public String sval;
	public String tag;
	
	//initial constructor for value
	public Value(){
		dval = 0;
		sval = null;
		tag = "STR";
	}
	//constructor for value containing a data
	public Value(double d, String s, String t){
		dval = d;
		sval = s;
		tag = t;
	}
	
	/************************
	 * OPERATIONS ON VALUES *
	 ************************/
	
	//plus(Value) Method to add values
	public Value plus(Value a){
		Value netval = new Value();
		if(tag=="DBL" && a.tag=="DBL"){
			netval.dval = dval + a.dval;
			netval.tag = "DBL";
			return(netval);
		}
		else netval.tag = "INV";
			return(netval);
	}
	
	//minus(Value) Method to subtract values
	public Value minus(Value a){
		Value netval = new Value();
		if(tag=="DBL" && a.tag=="DBL"){
			netval.dval = dval - a.dval;
			netval.tag = "DBL";
			return(netval);
		}
		else netval.tag = "INV";
			return(netval);
	}
	
	//star(Value) Method to multiply values
	public Value star(Value a){
		Value netval = new Value();
		if(tag=="DBL" && a.tag=="DBL"){
			netval.dval = dval * a.dval;
			netval.tag = "DBL";
			return(netval);
		}
		else netval.tag = "INV";
			return(netval);
	}
	
	//slash(Value) Method to divide values
	public Value slash(Value a){
		Value netval = new Value();
		if(tag=="DBL" && a.tag=="DBL"){
			netval.dval = dval / a.dval;
			netval.tag = "DBL";
			return(netval);
		}
		else netval.tag = "INV";
			return(netval);
	}


	public void main(String[] args){
		Node n = new Node();
		System.out.println(n.toString(n));
	}

}
