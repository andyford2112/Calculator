package calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {
	private JTextField textField;
	private NumberButton[] numbers;
	private JPanel numPanel;
	private OperatorButton[] opers;
	private JPanel operPanel;
	private EqualsButton equals;
	private ClearButton clear;
	private JPanel buttonPanel;
	private double a;
	private double b;
	private Operator oper;
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}
	
	public Calculator(){
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(400, 35));
		textField.setFont(new Font("Serif", Font.PLAIN, 30));
		
		numbers = new NumberButton[10];
		
		numPanel = new JPanel();
		numPanel.setLayout(new GridLayout(4, 3));
		for(int i = 0; i < 9; i++){
			numbers[i] = new NumberButton(i+1, this);
			numPanel.add(numbers[i]);
		}
		numbers[9] = new NumberButton(0, this);
		numPanel.add(numbers[9]);
		numPanel.setPreferredSize(new Dimension(200, 300));
		
		opers = new OperatorButton[4];
		opers[0] = new OperatorButton(Operator.ADD, this);
		opers[1] = new OperatorButton(Operator.SUBTRACT, this);
		opers[2] = new OperatorButton(Operator.MULTIPLY, this);
		opers[3] = new OperatorButton(Operator.DIVIDE, this);
		operPanel = new JPanel();
		operPanel.setLayout(new GridLayout(3, 2));
		for(int i = 0; i < opers.length; i++)
			operPanel.add(opers[i]);
		
		equals = new EqualsButton(this);
		
		clear = new ClearButton(this);
		
		operPanel.add(equals);
		operPanel.add(clear);
		operPanel.setPreferredSize(new Dimension(150, 200));
		
		buttonPanel = new JPanel();
		buttonPanel.add(numPanel);
		buttonPanel.add(operPanel);
		
		setLayout(new BorderLayout());
		add(textField, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		setPreferredSize(new Dimension(400, 400));
		pack();
		setVisible(true);
	}
	
	public JTextField getTextField(){
		return textField;
	}
	
	public double getA(){
		return a;
	}
	
	public void setA(double _a){
		a = _a;
	}
	
	public double getB(){
		return b;
	}
	
	public void setB(double _b){
		b = _b;
	}
	
	public Operator getOper(){
		return oper;
	}
	
	public void setOper(Operator _oper){
		oper = _oper;
	}
	
	public double operation(double _a, double _b, Operator _oper){
		switch(_oper){
		case ADD: return _a + _b;
		case SUBTRACT: return _a - _b;
		case MULTIPLY: return _a * _b;
		default: return _a / _b;
		}
	}

}
