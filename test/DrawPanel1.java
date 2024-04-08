import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.Graphics;


public class DrawPanel1 extends JPanel {

	private Boolean draw = false;
	

	private java.util.ArrayList<Point2D> arrPoints = new java.util.ArrayList<Point2D>();

	public Boolean getDraw() {
		return draw;
	}

	public void setDraw(Boolean draw) {
		this.draw = draw;
	}

	public java.util.ArrayList<Point2D> getArrPoints() {
		return arrPoints;
	}

	public void setArrPoints(java.util.ArrayList<Point2D> arrPoints) {
		this.arrPoints = arrPoints;
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if (draw) {
			g.translate(150, 60);
			for (int i = 0; i < arrPoints.size() - 1; i++) {
				Point2D p1 = arrPoints.get(i);
				Point2D p2 = arrPoints.get(i + 1);
				g2.draw(new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2
						.getY()));
               	}	
		}
	}
	public void Clear()
	{
		draw=false;
		arrPoints.clear();
		repaint();
	}
}