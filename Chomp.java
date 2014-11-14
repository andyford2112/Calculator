package chomp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Chomp extends JFrame implements ActionListener {
	private int rows;
	private int columns;
	private ChompButton[][] buttons;
	private String currentPlayer;
	private JLabel label;

	public static void main(String[] args) {
		Chomp game = new Chomp(10, 8);
	}
	
	public Chomp(int _rows, int _columns){
		rows = _rows;
		columns = _columns;
		buttons = new ChompButton[rows][columns];
		currentPlayer = "Player 1";
		
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
				buttons[i][j] = new ChompButton(i, j);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(rows, columns));
		buttonPanel.setPreferredSize(new Dimension(50 * columns, 50 * rows));
		
		for(int i = 0; i < buttons.length; i++)
			for(int j = 0; j < buttons[0].length; j++){
				buttonPanel.add(buttons[i][j]);
				buttons[i][j].addActionListener(this);
			}
		
		label = new JLabel();
		label.setText("It is " + currentPlayer + "'s turn.");
		
		setLayout(new BorderLayout());
		add(buttonPanel, BorderLayout.NORTH);
		add(label, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	
	}

	public void actionPerformed(ActionEvent e) {
		ChompButton selected = (ChompButton) e.getSource();
		int r = selected.getRow();
		int c = selected.getColumn();
		for(int i = r; i < buttons.length; i++){
			for(int j = c; j < buttons[0].length; j++){
				buttons[i][j].setEnabled(false);
			}
		}
		
		int count = 0;
		for(int i = 0; i < buttons.length; i++)
			for(int j = 0; j < buttons[0].length; j++)
				if(!buttons[i][j].isEnabled())
					count++;
		if(count == (rows *  columns) - 1){
			JOptionPane.showMessageDialog(null, "Game Over: " + currentPlayer + " wins!");
		}
		
		if(currentPlayer.equals("Player 1"))
			currentPlayer = "Player 2";
		else if( currentPlayer.equals("Player 2"))
			currentPlayer = "Player 1";
		label.setText("It is " + currentPlayer + "'s turn.");
		
	}

}
