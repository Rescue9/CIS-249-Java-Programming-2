/**
 * Program: Ch38Lab3.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Apr 1, 2013
 * Purpose: To create a tic-tac-toe game against the computer.
 */

package Ch38.Lab3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Ch38Lab3 extends JApplet implements ActionListener {

	private static final long serialVersionUID = 1L;  // eclipse complains
	
	// declare and/or construct variables and objects
	public JLabel jlblStatus = new JLabel("X's turn");
	public char turn = 'X';
	public Cell[][] c = new Cell[3][3];
	public char com = ' ';
	public char hum = ' ';

	@Override
	public void init() {
		JPanel p = new JPanel(new GridLayout(3, 3));
		p.setBorder(new LineBorder(Color.red));

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++){
				p.add(c[row][col] = new Cell());
			}
		}

		JMenuBar mb = new JMenuBar();
		this.setJMenuBar(mb);

		JMenu file = new JMenu("File");
		file.setMnemonic('f');
		mb.add(file);

		JMenuItem newM = new JMenuItem("New Game");
		newM.setMnemonic('n');
		newM.addActionListener(this);
		file.add(newM);

		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic('x');
		exit.addActionListener(this);
		file.add(exit);

		add(p, BorderLayout.CENTER);
		add(jlblStatus, BorderLayout.SOUTH);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				c[i][j].token = ' ';
				c[i][j].repaint();
				c[i][j].removeMouseListener(c[i][j]);
				c[i][j].addMouseListener(c[i][j]);
			}
		}

		jlblStatus.setText("X's turn");
		turn = 'X';
		com = 'O';
		hum = 'X';
	}

	public static void main(String[] args) {
		Ch38Lab3 applet = new Ch38Lab3();
		JFrame frame = new JFrame();
		frame.setTitle("Chapter 38 Lab 3: Play against the computer");
		frame.add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(400, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			if (e.getActionCommand() == "New Game") {
				JOptionPane pane = new JOptionPane("Do you wish to go first?",
						JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
				JDialog dialog = pane.createDialog(this, "2P");
				dialog.show();

				Object selectedValue = pane.getValue();
				if (selectedValue.equals(new Integer(JOptionPane.YES_OPTION))) {
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							c[i][j].token = ' ';
							c[i][j].repaint();
							c[i][j].removeMouseListener(c[i][j]);
							c[i][j].addMouseListener(c[i][j]);
						}
					}

					jlblStatus.setText("X's turn");
					turn = 'X';
					com = 'O';
					hum = 'X';
				} else {
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							c[i][j].token = ' ';
							c[i][j].repaint();
							c[i][j].addMouseListener(c[i][j]);
						}
					}

					jlblStatus.setText("X's turn");
					turn = 'X';
					com = 'O';
					hum = 'X';

					int r = (int) (3 * Math.random());
					int col = (int) (3 * Math.random());
					c[r][col].token = com;
					c[r][col].repaint();
					turn = hum;
					jlblStatus.setText(turn + "'s turn");

				}
			} else if (e.getActionCommand() == "Exit") {
				System.exit(1);
			}
		}
	}

	public void comTurn() {
		boolean found = false;
		if (!found) {
			for (int row = 0; row < 3; row++) {
				if (found)
					break;
				if ((c[row][0].token == com) && (c[row][1].token == com)) {
					if (c[row][2].token == ' ') {
						c[row][2].token = com;
						c[row][2].repaint();
						found = true;
					}// close last if
				}// close 2nd to last if
			}// close for loop
		}// close other if

		if (!found) {
			for (int row = 0; row < 3; row++) {
				if (found)
					break;
				if ((c[row][1].token == com) && (c[row][2].token == com)) {
					if (c[row][0].token == ' ') {
						c[row][0].token = com;
						c[row][0].repaint();
						found = true;
					}// close last if
				}// close 2nd to last if
			}// close for
		}// close outer if

		if (!found) {
			for (int row = 0; row < 3; row++) {
				if (found)
					break;
				if ((c[row][1].token == com) && (c[row][2].token == com)) {
					if (c[row][1].token == ' ') {
						c[row][1].token = com;
						c[row][1].repaint();
						found = true;
					}// close last if
				}// close 2nd to last if
			}// close for
		}// close outer if

		if (!found) {
			for (int col = 0; col < 3; col++) {
				if (found)
					break;
				if ((c[0][col].token == turn) && (c[1][col].token == turn)) {
					if (c[2][col].token == ' ') {
						c[2][col].token = com;
						c[2][col].repaint();
						found = true;
					}// closes last if statement
				}// closes first inner if statement
			}// closes for loop
		}// closes outer if statement

		if (!found) {
			for (int col = 0; col < 3; col++) {
				if (found)
					break;
				if ((c[1][col].token == turn) && (c[2][col].token == turn)) {
					if (c[0][col].token == ' ') {
						c[0][col].token = com;
						c[0][col].repaint();
						found = true;
					}// closes last if statement
				}// closes first inner if statement
			}// closes for loop
		}// closes outer if statement

		if (!found) {
			for (int col = 0; col < 3; col++) {
				if (found)
					break;
				if ((c[0][col].token == turn) && (c[2][col].token == turn)) {
					if (c[1][col].token == ' ') {
						c[1][col].token = com;
						c[1][col].repaint();
						found = true;
					}// closes last if statement
				}// closes first inner if statement
			}// closes for loop
		}// closes outer if statement

		if (!found) {
			if ((c[0][0].token == com) && (c[1][1].token == com)) {
				if (c[2][2].token == ' ') {
					c[2][2].token = com;
					c[2][2].repaint();
					found = true;
				}// closes inner if statement
			}// closes second if statement
		}// closes outer if statement

		if (!found) {
			if ((c[2][2].token == com) && (c[1][1].token == com)) {
				if (c[0][0].token == ' ') {
					c[0][0].token = com;
					c[0][0].repaint();
					found = true;
				}// closes inner if statement
			}// closes second if statement
		}// closes outer if statement

		if (!found) {
			if ((c[0][0].token == com) && (c[2][2].token == com)) {
				if (c[1][1].token == ' ') {
					c[1][1].token = com;
					c[1][1].repaint();
					found = true;
				}// closes inner if statement
			}// closes second if statement
		}// closes outer if statement

		if (!found) {
			if ((c[0][2].token == com) && (c[2][0].token == com)) {
				if (c[1][1].token == ' ') {
					c[1][1].token = com;
					c[1][1].repaint();
					found = true;
				}// closes inner if statement
			}// closes second if statement
		}// closes outer if statement

		if (!found) {
			if ((c[2][0].token == com) && (c[1][1].token == com)) {
				if (c[0][2].token == ' ') {
					c[0][2].token = com;
					c[0][2].repaint();
					found = true;
				}// closes inner if statement
			}// closes second if statement
		}// closes outer if statement

		if (!found) {
			if ((c[0][2].token == com) && (c[1][1].token == com)) {
				if (c[2][0].token == ' ') {
					c[2][0].token = com;
					c[2][0].repaint();
					found = true;
				}// closes inner if statement
			}// closes second if statement
		}// closes outer if statement

		if (!found) {
			for (int row = 0; row < 3; row++) {
				if (found)
					break;
				if ((c[row][0].token == hum) && (c[row][1].token == hum)) {
					if (c[row][2].token == ' ') {
						c[row][2].token = com;
						c[row][2].repaint();
						found = true;
					}// last if
				}// 2nd if
			}// for loop
		}// outer if

		if(!found)
		{
		for(int row=0;row<3;row++)
		{
		if(found)
		break;
		if((c[row][1].token == hum) && (c[row][2].token == hum))
		{
		if(c[row][0].token == ' ');
		{
		c[row][0].token = com;
		c[row][0].repaint();
		found = true;
		}//last if
		}//2nd if
		}//for loop

		if(!found)
		{
		for(int row=0;row<3;row++)
		{
		if(found)
		break;
		if((c[row][0].token == hum) && (c[row][2].token == hum))
		{
		if(c[row][1].token == ' ') {
		c[row][1].token = com;
		c[row][1].repaint();
		found = true;
		}//last if
		}//2nd if
		}//for loop
		}//outer if

		if(!found)
		{
		for(int col=0;col<3;col++)
		{
		if((c[0][col].token == hum) && (c[1][col].token == hum))
		{
		if(c[2][col].token == ' ')
		{
		c[2][col].token = com;
		c[2][col].repaint();
		found = true;
		}//last if
		}//2nd if
		}//for
		}//outer if

		if(!found)
		{
		for(int col=0;col<3;col++)
		{
		if((c[1][col].token == hum) && (c[2][col].token == hum))
		{
		if(c[0][col].token == ' ')
		{
		c[0][col].token = com;
		c[0][col].repaint();
		found = true;
		}//last if
		}//2nd if
		}//for
		}//outer if

		if(!found)
		{
		for(int col=0;col<3;col++)
		{
		if((c[0][col].token == hum) && (c[2][col].token == hum))
		{
		if(c[1][col].token == ' ')
		{
		c[1][col].token = com;
		c[1][col].repaint();
		found = true;
		}//last if
		}//2nd if
		}//for
		}//outer if

		if (!found) {
			if ((c[0][0].token == com) && (c[1][1].token == com)) {
				if (c[2][2].token == ' ') {
					c[2][2].token = com;
					c[2][2].repaint();
					found = true;
				}// closes inner if statement
			}// closes second if statement
		}// closes outer if statement

		if (!found) {
			if ((c[0][0].token == com) && (c[2][2].token == com)) {
				if (c[1][1].token == ' ') {
					c[1][1].token = com;
					c[1][1].repaint();
					found = true;
				}// closes inner if statement
			}// closes second if statement
		}// closes outer if statement

		if (!found) {
			if ((c[0][2].token == com) && (c[2][0].token == com)) {
				if (c[1][1].token == ' ') {
					c[1][1].token = com;
					c[1][1].repaint();
					found = true;
				}// closes inner if statement
			}// closes second if statement
		}// closes outer if statement

		if (!found) {
			if ((c[2][0].token == com) && (c[1][1].token == com)) {
				if (c[0][2].token == ' ') {
					c[0][2].token = com;
					c[0][2].repaint();
					found = true;
				}// closes inner if statement
			}// closes second if statement
		}// closes outer if statement

		if (!found) {
			if ((c[0][2].token == com) && (c[1][2].token == com)) {
				if (c[2][0].token == ' ') {
					c[2][0].token = com;
					c[2][0].repaint();
					found = true;
				}// closes inner if statement
			}// closes second if statement
		}// closes outer if statement

		if (!found) {
			if ((c[0][2].token == com) && (c[1][1].token == com)) {
				if (c[2][0].token == ' ') {
					c[2][0].token = com;
					c[2][0].repaint();
					found = true;
				}// closes inner if statement
			}// closes second if statement
		}// closes outer if statement

		if (found) {
			if (c[1][1].token == ' ') {
				c[1][1].token = com;
				c[1][1].repaint();
				found = true;
			} // close inner if
		} // close outer if

		if (!found) {
			for (int i = 0; i < 3; i++) {
				if (found)
					break;
				for (int j = 0; j < 3; j++) {
					if (found)
						break;
					if (c[i][j].token == ' ') {
						c[i][j].token = com;
						c[i][j].repaint();
						found = true;
					}// close last if
				}// close inner for
			}// close outer for
		}// close outer if

		if (winGame()) {
			jlblStatus.setText(turn + "wins the game.");
			removeListeners();
		} else if (drawGame()) {
			jlblStatus.setText("Draw game, reset to play again.");
		} else {
			if (com == 'X') {
				turn = 'O';
			} else {
				turn = 'X';
			}
			jlblStatus.setText(turn + "'s turn");
			}// close else if
		}// close outer if
	}
	public boolean winGame() {
		for (int row = 0; row < 3; row++) {
			if ((c[row][0].token == turn) && (c[row][1].token == turn)
					&& (c[row][2].token == turn))
				return true;
		}
		for (int col = 0; col < 3; col++) {
			if ((c[0][col].token == turn) && (c[1][col].token == turn)
					&& (c[2][col].token == turn))
				return true;
		}
		if ((c[0][0].token == turn) && (c[1][1].token == turn)
				&& (c[2][2].token == turn))
			return true;
		if ((c[0][2].token == turn) && (c[1][1].token == turn)
				&& (c[2][0].token == turn))
			return true;
		return false;
	}

	public void removeListeners() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				c[i][j].removeMouseListener(c[i][j]);
			}
		}
	}

	public boolean drawGame() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (c[i][j].token == ' ')
					return false;
			}
		}
		return true;
	}

	class Cell extends JPanel implements MouseListener {
		
		private static final long serialVersionUID = 1L; // eclipse complains
		
		char token = ' ';

		public Cell() {
			this.setBorder(new LineBorder(Color.black, 1));
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (token == 'X') {
				g.setColor(Color.black);
				g.drawLine(5, 5, getWidth() - 5, getHeight() - 5);
				g.drawLine(5, getHeight() - 5, getWidth() - 5, 5);
			} else if (token == 'O') {
				g.setColor(Color.black);
				g.drawOval(5, 5, getWidth() - 10, getHeight() - 10);
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (token == ' ') {
				this.token = turn;
				this.repaint();
				if (winGame()) {
					jlblStatus.setText(turn + " wins the game.");
					removeListeners();
				} else if (drawGame()) {
					jlblStatus.setText("Draw game, reset to play again.");
				} else {
					if (turn == 'X') {
						turn = 'O';
						jlblStatus.setText(turn + "'s turn");
					} else if (turn == 'O') {
						turn = 'X';
						jlblStatus.setText(turn + "'s turn");
					}
					if (turn == com) {
						comTurn();
					}
				}
			}
		}

		// the following methods are required eve if not used when using
		// MouseEvent
		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}
	}
}
