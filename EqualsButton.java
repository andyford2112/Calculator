package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JButton;

public class EqualsButton extends JButton implements ActionListener{
	private Calculator calc;
	
	public EqualsButton(Calculator _calc){
		calc = _calc;
		setText("=");
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Scanner scan = new Scanner(calc.getTextField().getText());
		calc.setA(scan.nextDouble());
		scan.next();
		calc.setB(scan.nextDouble());
		calc.getTextField().setText(Double.toString(calc.operation(calc.getA(), calc.getB(), calc.getOper())));
		
	}

}
