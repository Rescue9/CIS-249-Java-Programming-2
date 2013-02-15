package Ch16.Lab1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

public class RegularPolygonPanel extends JPanel {
	
	private static final long serialVersionUID = 1L; // eclipse complains
	
	private int numberOfSides = 3;
	
	public RegularPolygonPanel(){	
	}
	
	public RegularPolygonPanel(int numberOfSides){
		setNumberOfSides(numberOfSides);
	}
	
	public int getNumberOfSides(){
		return numberOfSides;
	}
	
	public void setNumberOfSides(int numberOfSides){
		this.numberOfSides = numberOfSides < 3 ? 3 : numberOfSides;
		repaint();
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);
		
		double angle = 2 * Math.PI / numberOfSides;
		
		// create a polygon object
		Polygon polygon = new Polygon();
		
		// add points to the polygon
		for (int i = 0; i < numberOfSides; i++){
			polygon.addPoint((int)(xCenter + radius * Math.cos(i * angle)),
					(int)(yCenter - radius * Math.sin(i * angle)));
		}
		
		// draw the polygon
		g.drawPolygon(polygon);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(200,200);
	}

}
