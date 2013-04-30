/**
 * Program: Ch22Lab1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Apr 23, 2013
 * Purpose: To create a game of 24
 */

package Ch22.Lab1;

import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Ch22Lab1 extends JApplet{

	private static final long serialVersionUID = 1L; // eclipse complains
	
	private JLabel jlblCard1	= new JLabel();
	private JLabel jlblCard2	= new JLabel();
	private JLabel jlblCard3	= new JLabel();
	private JLabel jlblCard4	= new JLabel();
	
	private JTextField jtfExpression = new JTextField(8);
	
	private JButton jbtVerify = new JButton("Verify");
	private JButton jbtRefresh = new JButton("Refresh");
	
	private ImageIcon[] cardIcons = new ImageIcon[52];
	
	private JPanel panel1 = new JPanel();
	
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private ArrayList<Integer> currentCardValues = new ArrayList<Integer>();
	

	public Ch22Lab1() {

		for (int i = 0; i < 52; i++){
			list.add(i);
		}
		
		// load the image icons
		for (int i = 0; i< 52; i++){
			cardIcons[i] = new ImageIcon("archives/Ch22/image/card/" + (i+1) + ".png");
		}
		
		panel1.add(jlblCard1);
		panel1.add(jlblCard2);
		panel1.add(jlblCard3);
		panel1.add(jlblCard4);
		
		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.add(new JLabel("  Enter an expression, using the provided cards, which results in 24:   "), BorderLayout.WEST);
		panel2.add(jtfExpression, BorderLayout.CENTER);
		panel2.add(jbtVerify, BorderLayout.EAST);
		
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel3.add(jbtRefresh);
		
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		add(panel3, BorderLayout.NORTH);
		
		refresh();
		
		jbtRefresh.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				refresh();
			}
		});
		
		jbtVerify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// check whether all numbers in the expression are currently selcted
				if (!correctNumbers()){
					JOptionPane.showMessageDialog(null, "The numbers in the expression don't" +
							"\nmatch the numbers in the set ");
				} else {
					// check to see if the expression evaluates to 24
					if (evaluate()){
						JOptionPane.showMessageDialog(null, "Correct");
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect result");
					}
				}
			}
		});
		
	}
	
	private boolean correctNumbers(){
		// get the user entered card values from the expression
		ArrayList<Integer> valueList = new ArrayList<Integer>();
		
		String expression = jtfExpression.getText();
		
		String [] numbers = expression. split("[()+-/*]");
		
		for (String s : numbers){
			if(s.length() > 0){
				valueList.add(new Integer(s));
			}
		}
		
		Collections.sort(valueList);
		Collections.sort(currentCardValues);
		
		if(valueList.equals(currentCardValues)){
			return true;
		} else {
			return false;
		}
	}
	
	private boolean evaluate(){
		return EvaluateExpression.evaluateExpression(jtfExpression.getText().trim()) == 24;
	}
	
	private void refresh(){
		Collections.shuffle(list);
		
		int index1 = list.get(0);
		int index2 = list.get(1);
		int index3 = list.get(2);
		int index4 = list.get(3);
		
		currentCardValues.clear();
		currentCardValues.add(index1 % 13 + 1);
		currentCardValues.add(index2 % 13 + 1);
		currentCardValues.add(index3 % 13 + 1);
		currentCardValues.add(index4 % 13 + 1);
		
		jlblCard1.setIcon(cardIcons[index1]);
		jlblCard2.setIcon(cardIcons[index2]);
		jlblCard3.setIcon(cardIcons[index3]);
		jlblCard4.setIcon(cardIcons[index4]);
		
		// added action to empty expression field
		jtfExpression.setText("");
	}
	
	public static void main(String[] args){
		Ch22Lab1 applet = new Ch22Lab1();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(3);
		frame.setTitle("Chapter 22 Lab 1: 24-Point Card Game");
		frame.add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static class  EvaluateExpression {
		
		/** Evaluate an Expression */
		public static int evaluateExpression(String expression){
			// create operandStack to store operands
			GenericStack<Integer> operandStack = new GenericStack<Integer>();
			
			// create operand stack to store operands
			GenericStack<Character> operatorStack = new GenericStack<Character>();
			
			StringTokenizer tokens = new StringTokenizer(expression, "()+-/*", true);
			
			// Phase 1: scan tokens
			while(tokens.hasMoreTokens()){
				String token = tokens.nextToken().trim(); // extract a token
				if(token.length() == 0) // blank space
					continue; // back to the while loop to extract the next token
				else if (token.charAt(0) == '+' || token.charAt(0) == '-'){
					// process all +,-,*,/ in the top of the operator stack
					while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' ||
							operatorStack.peek() == '-' || operatorStack.peek() == '*' ||
							operatorStack.peek() == '/')){
						processAnOperator(operandStack, operatorStack);
					}
					
					// push the + or - into the operator stack
					operatorStack.push(token.charAt(0));
				}
				else if (token.charAt(0) == '*' || token.charAt(0) == '/'){
					// process all *, / in the top of the operator stack
					while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' ||
							operatorStack.peek() == '/')){
						processAnOperator(operandStack, operatorStack);
					}
					
					// push the * or / into the operator stack
					operatorStack.push(token.charAt(0));
				}
				else if (token.trim().charAt(0) == '('){
					operatorStack.push('('); // push '(' to the stack
				}
				else if (token.trim().charAt(0)== ')'){
					// process all the operators in the stack until seeing '('
					while (operatorStack.peek() != '('){
						processAnOperator(operandStack, operatorStack);
					}
					operatorStack.pop(); // pop the '(' symbol from the stack
				}
				else {
					// an operand is scanned
					// push an operand into the stack
					operandStack.push(new Integer(token));
				}
			}
			
			// Phase 2: process all the remaining operators in the stack
			while(!operatorStack.isEmpty()){
				processAnOperator(operandStack, operatorStack);
			}
			return operandStack.pop();
		}
		
		/** Process one operator: Take an operator from the operatorStack
		 * and apply it on the operands in the operandStack
		 */
		
		public static void processAnOperator(GenericStack<Integer> operandStack, GenericStack<Character> operatorStack){
			char op = operatorStack.pop();
			int op1 = operandStack.pop();
			int op2 = operandStack.pop();
			if (op == '+')
				operandStack.push(op2 + op1);
			else if (op == '-')
				operandStack.push(op2 - op1);
			else if (op == '*')
				operandStack.push(op2 * op1);
			else if (op == '/')
				operandStack.push(op2 / op1);			
		}
	}
}
