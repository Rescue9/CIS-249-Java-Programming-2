/**
 * Program: Ch32Lab1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Apr 29, 2013
 * Purpose: To create a set of 3 clocks
 */

package Ch32.Lab1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ch32Lab1 extends JApplet implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// declare three clock panels
	private ClockControl clockControl1, clockControl2, clockControl3;
	
	// declare group control buttons
	private JButton jbtResumeAll, jbtSuspendAll;
	
	/** This main method enables the applet to run as an Application */
	public static void main(String[] args){
		// create a frame
		JFrame frame = new JFrame("Ch32 Lab 1");
		
		// create an instance of the applet
		Ch32Lab1 applet = new Ch32Lab1();
		
		// add the applet instance to the frame
		frame.add(applet, BorderLayout.CENTER);
		
		// invoke init() and start()
		applet.init();
		applet.start();
		
		// display the frame
		frame.setSize(600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void init(){
		// panel p1 for holding three clocks
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 3));
		
		// create a clock for Berlin
		p1.add(clockControl1 = new ClockControl());
		
		// create a clock for San Francisco
		p1.add(clockControl2 = new ClockControl());
		
		// create a clock for Taichung
		p1.add(clockControl3 = new ClockControl());
		
		// panel p2 for holding two group control buttons
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(jbtResumeAll = new JButton("Resume All"));
		p2.add(jbtSuspendAll = new JButton("Suspend All"));
		
		// add panel p1 and p2 into the applet
		setLayout(new BorderLayout());
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		// register the listeners
		jbtResumeAll.addActionListener(this);
		jbtSuspendAll.addActionListener(this);
	}
	
	/** Handle group control buttons */
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == jbtResumeAll){
			// start all clocks
			clockControl1.resume();
			clockControl2.resume();
			clockControl3.resume();
		} else if (e.getSource() == jbtSuspendAll){
			// stop all clocks
			clockControl1.suspend();
			clockControl2.suspend();
			clockControl3.suspend();
			
		}
	}
	
	class ClockControl extends JPanel implements ActionListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Clock clock = new Clock();
		private JButton jbtSuspend = new JButton("Suspend");
		private JButton jbtResume = new JButton("Resume");
		
		public ClockControl(){
			// group buttons in panel
			JPanel panel = new JPanel();
			panel.add(jbtSuspend);
			panel.add(jbtResume);
			
			// add clock and buttons to the panel
			setLayout(new BorderLayout());
			add(clock, BorderLayout.CENTER);
			add(panel, BorderLayout.SOUTH);
			
			// register Listeners
			jbtSuspend.addActionListener(this);
			jbtResume.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == jbtSuspend){
				clock.suspend();
			} else if (e.getSource() == jbtResume){
				clock.resume();
			}
		}
		
		public void suspend(){
			clock.suspend();
		}
		
		public void resume(){
			clock.resume();
		}
	}
	
	class Clock extends StillClock implements Runnable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private boolean suspended;
		
		public Clock(){
			new Thread(this).start();
		}
		
		public void run(){
			while(true){
				setCurrentTime();
				repaint();
				try	{
					Thread.sleep(1000);
					waitForNotificationToResume();
				} catch (InterruptedException ex){
				}
			}
		}
		
		public synchronized void suspend(){
			suspended = true;
		}
		
		public synchronized void resume(){
			if (suspended){
				suspended = false;
				notifyAll();
			}
		}
		
		private synchronized void waitForNotificationToResume() throws InterruptedException {
			while (suspended){
				wait();
			}
		}
	}
	

}
