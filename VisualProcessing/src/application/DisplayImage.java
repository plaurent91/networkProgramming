package application;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This class allows the user to display the images in the database.
 * @author pierre
 **/

public class DisplayImage {
	
	private String title;
	
	/**
	 * The general constructor to display an image
	 * @param title put as parameter, the image title (only the numer as all images in the db are called image"n".png)
	 */
	public DisplayImage (String title) {
		this.title = title;
	}

	/**
	 * Method called to display the image
	 * See the path can be modified on the main function
	 * @param out send the PrintWriter in case you can't display the image, in order to send a notification
	 */
    public void DisplayImage(PrintWriter out)
    {
        BufferedImage img = null;
		try {
			img = ImageIO.read(new File(Main.ImagePath + "image" + title + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			out.println("Impossible to display this image ... it should non exist!\nPlease reconnect");
		}
        ImageIcon icon=new ImageIcon(img);
        JFrame frame=new JFrame("image" + title + ".png");
        frame.setLayout(new FlowLayout());
        frame.setSize(500,500);
        frame.setAlwaysOnTop(true);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
    }
}

