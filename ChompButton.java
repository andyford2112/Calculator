package chomp;

import javax.swing.JButton;

public class ChompButton extends JButton {
	private int row;
	private int column;
	
	public ChompButton(int _row, int _column){
		row = _row;
		column = _column;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getColumn(){
		return column;
	}

}