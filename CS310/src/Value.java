public class Value {
	
	public double dval;
	public String sval;
	private String tag;
	private Value tempVal;
	
	//initial constructor for value
	public Value(){
		this.dval = 0;
		this.sval = "";
		this.tag = "STR";
	}
	public Value(double d){
		this.dval = d;
		this.tag = "DBL";
	}
	public Value(String s){
		this.sval = s;
		this.tag = "STR";
	}
	//constructor for value containing a data
	public Value(double d, String s, String t){
		this.dval = d;
		this.sval = s;
		this.tag = t;
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
	public String toString(Value v){
		if(v.tag == "DBL"){
			return (String.format("%10.4f", v.dval));}
		else if(v.tag == "STR"){
			return (String.format("%10s", v.sval));}
		else
			return(String.format("%10s", "null"));
	}
	
	
	public Value checkInput(String s){
		tempVal = new Value();
		boolean checkInput = s.startsWith("\"");		
		if(checkInput){								//check if input is string or double
			s = s.substring(1);				//cut out " from string
			tempVal.sval = s;
			tempVal.tag = "STR";
			return (tempVal);
		}
		else{
			try{
				double d = Double.parseDouble(s);	//parse double from string
				tempVal.dval = d;
				tempVal.tag = "DBL";
				return(tempVal);
			}
			catch(NumberFormatException n){
				tempVal.tag = "INV";
				return(tempVal);
			}
		}
	}//end checkInput()
	
	public static void main(String[] args){
		
	}
	
}
