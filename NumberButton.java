package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NumberButton extends JButton implements ActionListener {
	private int num;
	private Calculator calc;
	
	public NumberButton(int _num, Calculator _calc){
		num = _num;
		setText("" + num);
		calc = _calc;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		calc.getTextField().setText(calc.getTextField().getText() + Integer.toString(num));
		
	}
	
	public int getValue(){
		return num;
	}
}
