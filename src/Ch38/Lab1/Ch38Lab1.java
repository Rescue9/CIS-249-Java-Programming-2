/**
 * Program: Ch38Lab1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Apr 1, 2013
 * Purpose: To draw various shapes based upon user selection. Mouse & Keyboard listeners will be used.
 */

package Ch38.Lab1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Ch38Lab1 extends JApplet{
	
	// declare integer, KyeListener object, and construct MyIcon object array and DisplayCanvas object
	
	private static final long serialVersionUID = 1L; // eclipse complains
	
	private int currentType = 0;
	private MyIcon[] c = new MyIcon[4];
	private DisplayCanvas canvas = new DisplayCanvas();
	public KeyListener keyListener;

	public Ch38Lab1() {
		
		// construct panel, setting attributes, and add icons to the panel
		JPanel p = new JPanel();
		p.setBackground(Color.cyan);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		for (int i=0; i < 4; i++)
			p.add(c[i] = new MyIcon(i));
		
		// set layout for frame / applet and add panel and canvas object to it
		setLayout(new BorderLayout());
		add(p, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);
	}
	
	// inner class MyIcon
	public class MyIcon extends JPanel {
		
		private static final long serialVersionUID = 1L;  // eclipse complains
		
		private int type = 0;
		
		public MyIcon(int t){
			type = t;
			
			// add MouseListener for the icon objects
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e){
					if ((currentType != 3) && (type == 3)){
						canvas.addKeyListener(keyListener);
						canvas.requestFocus();
						System.out.println("Key Listener added");
					}
					
					if (currentType != type){
						c[currentType].setBackground(Color.cyan);
						c[type].setBackground(Color.red);
						currentType = type;
					}
				}
			});
		}
		
		public void paintComponent(Graphics g){
		// invoke the superclass paintComponent() method passing the value of the Graphics object
		super.paintComponent(g);
		
		int width = getSize().width;
		int height = getSize().height;
		
		// value of the type variable controls which object is drawn
		switch (type) {
			case 0: g.drawLine(10, height-10, width-10, 10);
			break;
			
			case 1: g.drawRect(10, 10, width-20, height-20);
			break;
			
			case 2: g.drawOval(10, 10, width-20, height-20);
			break;
			
			case 3: g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
			g.drawString("A", 10, 30);
			}
		}
		
		public Dimension getPreferredSize(){
			// responsible for setting preferred size of the icons
			return new Dimension(40, 40);
		}
	}
	
	public class DisplayCanvas extends JPanel {
		
		private static final long serialVersionUID = 1L; // eclipse complains
		
		private Point start = new Point(20,20); // line start point
		private Graphics g;
		
		public DisplayCanvas(){
			// constructs the keyListener object
			keyListener = new KeyAdapter() {
				public void keyPressed(KeyEvent e){
					char keyChar = e.getKeyChar();
					g = getGraphics();
					g.clearRect(0, 0, getSize().width, getSize().height);
					g.drawString(String.valueOf(keyChar), start.x, start.y);
					System.out.println("Key pressed");
				}
			};
			
			// add MouseListener in order to draw the objects
			addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e){
					g = getGraphics();
					g.clearRect(0, 0, getSize().width, getSize().height);
					switch (currentType){
					case 0: g.drawLine(start.x, start.y, e.getX(), e.getY()-start.y); break;
					case 1: g.drawRect(start.x, start.y, e.getX()-start.x, e.getY()-start.y); break;
					case 2: g.drawOval(start.x, start.y, e.getX()-start.x, e.getY()-start.y); break;
					}
				}
			});
			
			addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					start.move(e.getX(), e.getY());
				}
			});
		}
	}
	
	public static void main(String[] args){
		Ch38Lab1 applet = new Ch38Lab1();
		JFrame frame = new JFrame();
		frame.setTitle("Chapter 38 Lab 1");
		frame.add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(400, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // center the frame
		frame.setVisible(true);
	}
}
