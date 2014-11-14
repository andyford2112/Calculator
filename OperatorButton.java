package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class OperatorButton extends JButton implements ActionListener {
	private Operator oper;
	private Calculator calc;
	
	public OperatorButton(Operator _oper, Calculator _calc){
		oper = _oper;
		calc = _calc;
		if(oper == Operator.ADD)
			setText("+");
		else if(oper == Operator.SUBTRACT)
			setText("-");
		else if(oper == Operator.MULTIPLY)
			setText("*");
		else
			setText("/");
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		calc.setOper(oper);
		calc.getTextField().setText(calc.getTextField().getText() + " " + oper.toString() + " ");
		
	}

}
