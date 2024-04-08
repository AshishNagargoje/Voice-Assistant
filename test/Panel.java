import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Panel extends JPanel {

	
	public void saveImage(String name,String type) {
		BufferedImage image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		paint(g2);
		try{
			ImageIO.write(image, type, new File(name+"."+type));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
        
        public static void main(String[] args)
        {
            new Panel();
        }
}
