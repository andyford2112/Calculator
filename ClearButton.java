package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClearButton extends JButton implements ActionListener{
	private Calculator calc;
	
	public ClearButton(Calculator _calc){
		calc = _calc;
		setText("Clear");
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		calc.getTextField().setText("");
	}

}
