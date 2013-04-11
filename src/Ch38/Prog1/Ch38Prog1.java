/**
 * Program: Ch38Prog1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Apr 2, 2013
 * Purpose: Investment calculator
 */

package Ch38.Prog1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Ch38Prog1 extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L; // eclipse complains
	
	// declare items
	JLabel jlblInvAmount = new JLabel("Investment Amount");
	JLabel jlblYears = new JLabel("Years");
	JLabel jlblAnnIntRate = new JLabel("Annual Interest Rate");
	JLabel jlblFutValue = new JLabel("Future Value");
	
	JTextField jtfInvAmount = new JTextField();
	JTextField jtfYears = new JTextField();
	JTextField jtfAnnIntRate = new JTextField();
	JLabel jlblFutValueAns = new JLabel();
	JButton	calcButton = new JButton("Calculate");
	
	DecimalFormat df = new DecimalFormat("$###,###,###.##");

	public Ch38Prog1() {
		
		// set listener of calcButton
		calcButton.addActionListener(this);
		
		// set border of investment area answer label
		jlblFutValueAns.setBorder(new LineBorder(Color.gray, 1));
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,2));
		p.add(jlblInvAmount);
		p.add(jtfInvAmount);
		p.add(jlblYears);
		p.add(jtfYears);
		p.add(jlblAnnIntRate);
		p.add(jtfAnnIntRate);
		p.add(jlblFutValue);
		p.add(jlblFutValueAns);
		
		JPanel pButton = new JPanel();
		pButton.setLayout(new GridLayout(1,1));
		pButton.add(calcButton);
		
		setLayout(new BorderLayout());
		add(p, BorderLayout.CENTER);
		add(pButton, BorderLayout.SOUTH);
		
		addMenuBar();
		
	}
	
	public double runCalculation(double invAmount, double years, double annIntRate){
		double futureValue;
		double monIntRate = annIntRate / 12 / 100;
		futureValue = invAmount * Math.pow((1 + monIntRate), (years * 12));
		return futureValue;
	}
	
	public static void main(String[] args){
		Ch38Prog1 frame = new Ch38Prog1();
		frame.setTitle("Chapter 38 Program 1: Investment Calculator");
		frame.pack();
		//frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// menu section
		if (e.getActionCommand().equals("Calculate")){
			calcMethod();
		}
		if (e.getActionCommand().equals("Exit")){
			System.exit(1);
		}
		if (e.getActionCommand().equals("About")){
			JOptionPane.showMessageDialog(null, "Compute future investment value", "About This Program", JOptionPane.INFORMATION_MESSAGE);
		}
		
		// calculation button
		if(e.getSource() == calcButton){
			calcMethod();
		}
	}
	
	public void calcMethod(){
		if((!"".equals(jtfInvAmount.getText())) && (!"".equals(jtfAnnIntRate.getText())) && (!"".equals(jtfYears.getText()))){
			double invAmount = Double.parseDouble(jtfInvAmount.getText());
			double years = Double.parseDouble(jtfYears.getText());
			double anIntRate = Double.parseDouble(jtfAnnIntRate.getText());
			
			double futureValueAnswer = runCalculation(invAmount, years, anIntRate);
			jlblFutValueAns.setText(""+df.format(futureValueAnswer));
		} else {
				JOptionPane.showMessageDialog(null, "None of the fields can be empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void addMenuBar(){
		JMenuBar mb = new JMenuBar();
		this.setJMenuBar(mb);
		
		JMenu operation = new JMenu("Operation");
		operation.setMnemonic('o');
		mb.add(operation);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic('h');
		mb.add(help);
		
		JMenuItem calculate = new JMenuItem("Calculate");
		calculate.setMnemonic('c');
		calculate.addActionListener(this);
		operation.add(calculate);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic('x');
		exit.addActionListener(this);
		operation.add(exit);
		
		JMenuItem about = new JMenuItem("About");
		about.setMnemonic('a');
		about.addActionListener(this);
		help.add(about);
	}
}
