package application;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.googlecode.javacv.OpenCVFrameGrabber;

import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_highgui.*;

/** 
 * This class allows to take picture using the webcam, need download javaCV   
 * @author pierre
 */

public class captureImage {

	/**
	 * You import the image path from the main class to make the compatibility with different OS.
	 */
	private String dbPath = Main.ImagePath;
	private String title;
	private boolean isRef;

	/**
	 * Constructor for the class captureImage
	 * be careful not to change the title otherwise, you could have compatibility problems when processing the database
	 * using the sort function in C++.
	 * @param title give as an argument the title of file (default: "image"<number>)
	 */
	public captureImage(String title) {
		this.title = title + "0";
	}

	/**
	 * @return the size of the image (integer)
	 */
	public int nbFiles () {
		File folder=new File(dbPath);
		File[] f = folder.listFiles();
		File isImg = new File (dbPath + "image0.png");
		return f.length;
	}

	/**
	 * Method you have to implement to set up the title of your  (be careful if your image has to be reference or to compare one)
	 * @param title see Constructor
	 * @param isRef true: reference image in your database, false: image to compare
	 */
	public captureImage(String title, boolean isRef) {
		if (isRef == true) {
			try{
				BufferedReader In = new BufferedReader(new FileReader("image0.png"));
				this.title = title + Integer.toString(nbFiles());
			} catch (FileNotFoundException fnfe) {
				this.title = title + Integer.toString(nbFiles());
			}
		}
		else this.title = title + "0";
	}

	/**
	 * Implement this method to capture a frame after call the constructor
	 */
	public void captureFrame() { // 0-default camera, 1 - next...so on final OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
		OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
		try { grabber.start();
		IplImage img = grabber.grab();
		if (img != null) { cvSaveImage(dbPath + title + ".png", img);
		grabber.release();
		} 
		} catch (Exception e) { e.printStackTrace();
		} 
	} 
}