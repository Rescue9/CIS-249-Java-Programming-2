/**
 * Program: Ch37Lab1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Mar 5, 2013
 * Purpose: Create a tabbed pane for operating on integers and rational numbers
 */

package Ch37.Lab1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Ch37Lab1 extends JApplet {

	private static final long serialVersionUID = 1L; // eclipse complains

	// create a tabbed pane to hold figure panels
	private JTabbedPane jtpPanels = new JTabbedPane();

	public Ch37Lab1() {
		// create intPanel for integers arithmetic
		JPanel intPanel = new IntPanel();

		// create rationalPanel for rational arithmetic
		JPanel rationalPanel = new RationalPanel();

		jtpPanels.add(intPanel, "Integer Operations");
		jtpPanels.add(rationalPanel, "Rational Operations");

		// set flowlayout in the frame
		setLayout(new BorderLayout());
		add(jtpPanels, BorderLayout.CENTER);
	}

	// set the attributes for the frame so that it can run as either an applet
	// or GUI application
	public static void main(String[] args) {

		Ch37Lab1 applet = new Ch37Lab1();
		JFrame frame = new JFrame();
		frame.setTitle("Chapter 37 Lab 1");
		frame.add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}

class IntPanel extends CalculationPanel {
	private static final long serialVersionUID = 1L; // eclipse complains

	IntPanel() {
		// invoke the superclass constructor method that has a String parameter
		super("Integer Calculation");
	}

	// method for adding integers
	void add() {
		int result = getNum1() + getNum2();

		// set result in JTextField tf3
		tfResult.setText(String.valueOf(result));
	}

	// subtracting
	void subtract() {
		int result = getNum1() - getNum2();

		// set result in JTextField tf3
		tfResult.setText(String.valueOf(result));
	}

	// multiplying
	void multiply() {
		int result = getNum1() * getNum2();

		// set result in JTextField tfResult
		tfResult.setText(String.valueOf(result));
	}

	// dividing
	void divide() {
		int result = getNum1() / getNum2();

		// set result in JTextField tfResult
		tfResult.setText(String.valueOf(result));
	}

	// gets the number, trimming any spaces
	private int getNum1() {
		// use trim() to trim extraneous space in the text field
		int num1 = Integer.parseInt(tfNum1.getText().trim());
		return num1;
	}

	private int getNum2() {
		int num2 = Integer.parseInt(tfNum2.getText().trim());
		return num2;
	}
}

// class for rational numbers
class RationalPanel extends CalculationPanel {
	private static final long serialVersionUID = 1L; // eclipse complains

	RationalPanel() {
		super("Rational Calculation");
	}

	void add() {
		Rational num1 = getNum1();
		Rational num2 = getNum2();
		Rational result = num1.add(num2);

		// set result in JTextField tfResult
		tfResult.setText(result.toString());
	}

	void subtract() {
		Rational num1 = getNum1();
		Rational num2 = getNum2();
		Rational result = num1.subtract(num2);

		// set result in JTextField tfResult
		tfResult.setText(result.toString());
	}

	void multiply() {
		Rational num1 = getNum1();
		Rational num2 = getNum2();
		Rational result = num1.multiply(num2);

		// set result in JTextField tfResult
		tfResult.setText(result.toString());
	}

	void divide() {
		Rational num1 = getNum1();
		Rational num2 = getNum2();
		Rational result = num1.divide(num2);

		// set result in JTextField tfResult
		tfResult.setText(result.toString());
	}

	Rational getNum1() {
		StringTokenizer st1 = new StringTokenizer(tfNum1.getText().trim(), "/");
		int number1 = Integer.parseInt(st1.nextToken());
		int denom1 = Integer.parseInt(st1.nextToken());
		return new Rational(number1, denom1);
	}

	Rational getNum2() {
		StringTokenizer st2 = new StringTokenizer(tfNum2.getText().trim(), "/");
		int number2 = Integer.parseInt(st2.nextToken());
		int denom2 = Integer.parseInt(st2.nextToken());
		return new Rational(number2, denom2);
	}

}

// abstract class, with attributes for two classes
abstract class CalculationPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L; // eclipse complains
	
	private JPanel p0 = new JPanel();
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	JTextField tfNum1, tfNum2, tfResult;
	private JButton jbtAdd, jbtSub, jbtMult, jbtDiv;

	public CalculationPanel(String title) {
		p0.add(new JLabel(title));

		// add labels to text fields
		p1.setLayout(new FlowLayout());
		p1.add(new JLabel("Number 1"));
		p1.add(tfNum1 = new JTextField(" ", 3));
		p1.add(new JLabel("Number 2"));
		p1.add(tfNum2 = new JTextField(" ", 3));
		p1.add(new JLabel("Result"));
		p1.add(tfResult = new JTextField(" ", 4));
		tfResult.setEditable(false);

		// set FlowLayout for p2
		p2.setLayout(new FlowLayout());
		p2.add(jbtAdd = new JButton("Add"));
		p2.add(jbtSub = new JButton("Subtract"));
		p2.add(jbtMult = new JButton("Multiply"));
		p2.add(jbtDiv = new JButton("Divide"));

		// add panels into CalculationPanel
		setLayout(new BorderLayout());
		add("North", p0);
		add("Center", p1);
		add("South", p2);

		// register listener for source objects
		jbtAdd.addActionListener(this);
		jbtSub.addActionListener(this);
		jbtMult.addActionListener(this);
		jbtDiv.addActionListener(this);

	}
	

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (e.getSource() instanceof JButton) {
			if ("Add".equals(actionCommand))
				add();
			if ("Subtract".equals(actionCommand))
				subtract();
			if ("Multiply".equals(actionCommand))
				multiply();
			if ("Divide".equals(actionCommand))
				divide();
		}
	}

	// all subclasses must have methods of these names
	abstract void add();
	abstract void subtract();
	abstract void multiply();
	abstract void divide();
}