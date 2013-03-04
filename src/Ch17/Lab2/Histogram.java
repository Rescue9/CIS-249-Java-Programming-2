/**
 * Program: Histogram.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Mar 3, 2013
 * Purpose: To display a bar graph of the number of letters used in a file.
 */

package Ch17.Lab2;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;

public class Histogram extends JPanel {
	
	private static final long serialVersionUID = 1L; // eclipse complains

	// count the occurrence of 26 letters
	private int[] count;
	
	/** set the count and display histogram */
	public void showHistogram(int[] count){
		this.count = count;
		repaint();
	}
	
	@Override /* paint the histogram */
	protected void paintComponent(Graphics g){
		if (count == null) return; // no display if count is null
		super.paintComponent(g);
		
		// find the panel size and bar width and interval dynamically
		int width = getWidth();
		int height = getHeight();
		int interval = (width - 40) / count.length;
		int individualWidth = (int)(((width - 40)/24 ) * 0.60);
		
		// find the maximum count. the maximum count has the highest bar
		int maxCount = 0;
		for (int i = 0; i < count.length; i++){
			if (maxCount < count[i])
				maxCount = count[i];
		}
		
		// x is the start position for the first bar in the histogram
		int x = 30;
		
		// draw a horizontal base line
		g.drawLine(10, height-45, width - 10, height - 45);
		for (int i = 0; i < count.length; i++){
			// find the bar height
			int barHeight = (int)(((double)count[i] / (double)maxCount)*(height - 55));
			
			// display a bar
			g.drawRect(x, height - 45 - barHeight, individualWidth, barHeight);
			
			// display a letter under the base line
			g.drawString((char)(65 + i) + "", x, height - 30);
			
			// move x for displaying the next character
			x+= interval;
		}
	}
	
	/** override getPreferredSize */
	public Dimension getPreferredSize(){
		return new Dimension(300, 300);
	}

}
