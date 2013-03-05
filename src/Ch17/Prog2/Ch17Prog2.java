package Ch17.Prog2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Ch17Prog2 extends JFrame {
	
	private static final long serialVersionUID = 1L; // eclipse complains
	
	JLabel jlblText = new JLabel("Text Field");
	JTextField jtfInput = new JTextField(30);
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	
	private JRadioButton jrbtLeft, jrbtCenter,jrbtRight;
	private ButtonGroup buttons = new ButtonGroup();
	
	public Ch17Prog2(){
		
		p1.setLayout(new FlowLayout());
		p1.add(jlblText);
		p1.add(jtfInput);		
		
		TitledBorder title = BorderFactory.createTitledBorder("Horizontal Alignment");
		
		p2.setBorder(title);
		p2.setLayout(new FlowLayout());
		p2.add(jrbtLeft = new JRadioButton("Left"));
		p2.add(jrbtCenter = new JRadioButton("Center"));
		p2.add(jrbtRight = new JRadioButton("Right"));
		
		// set button group
		buttons.add(jrbtLeft);
		buttons.add(jrbtCenter);
		buttons.add(jrbtRight);
		
		jrbtLeft.addItemListener(new MyRadioListener());
		jrbtCenter.addItemListener(new MyRadioListener());
		jrbtRight.addItemListener(new MyRadioListener());
				
		p3.add(p2);
		
		add(p1, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args){
		Ch17Prog2 myProg = new Ch17Prog2();
		myProg.setTitle("Chapter 17 Program 2");
		myProg.pack();
		myProg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myProg.setLocationRelativeTo(null);
		myProg.setVisible(true);
	}
	
	class MyRadioListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (jrbtLeft.isSelected()){
				jtfInput.setHorizontalAlignment(JTextField.LEFT);
			}
			if (jrbtCenter.isSelected()){
				jtfInput.setHorizontalAlignment(JTextField.CENTER);
			}
			if (jrbtRight.isSelected()){
				jtfInput.setHorizontalAlignment(JTextField.RIGHT);
			}
		}
		
	}

}
