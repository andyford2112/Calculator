package calculator;

public enum Operator {
	ADD, SUBTRACT, MULTIPLY, DIVIDE;
	
	public String toString(){
		switch(this){
			case ADD: return "+";
			case SUBTRACT: return "-";
			case MULTIPLY: return "*";
			case DIVIDE: return "/";
			default: return "";
		}
	}

}
