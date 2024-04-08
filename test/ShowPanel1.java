import java.awt.Graphics2D;
import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;

public class ShowPanel1 extends JPanel {
	private Boolean draw = false;

	public Boolean getDraw() {
		return draw;
	}

	public void setDraw(Boolean draw) {
		this.draw = draw;
	}

	protected void paintComponent(Graphics g)

	{
		g.setColor(new Color(0, 0, 128));
		g.setFont(new Font("Verdana", Font.BOLD, 12));

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

	}
}