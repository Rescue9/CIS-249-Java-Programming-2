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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Ch38Prog1 extends JFrame implements ActionListener {
	
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

	public Ch38Prog1() {
		
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
		
	}
	
	public double runCalculation(double invAmount, double years, double annIntRate){
		double futureValue;
		double monIntRate = annIntRate / 12;
		futureValue = invAmount * Math.pow((1 + monIntRate), (years *12));
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
		if(e.getSource() == calcButton){
			if((jtfInvAmount !=null) && (jtfYears != null) && (jtfAnnIntRate != null)){
				double invAmount = Double.parseDouble(jtfInvAmount.getText().trim());
				double years = Double.parseDouble(jtfYears.getText().trim());
				double anIntRate = Double.parseDouble(jtfAnnIntRate.getText().trim());
				
				runCalculation(invAmount, years, anIntRate);
			} else {
				JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	

}
