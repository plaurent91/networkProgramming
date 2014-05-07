package application;

import gui_package.*;

/** 
 * This is the main class used to start the application
 * It is important to determine the image path here!
 * @author pierre : pierre  
 */

public class Main {

	/**
	 * If you are running Windows/MAC OS, 
	 * please change this path according to the document windows_mac_compatibility.txt
	 */
	public final static String ImagePath = "images/";
	
	/**
	 * If you are running Windows/MAC OS, 
	 * please change this path according to the document windows_mac_compatibility.txt
	 */
	public final static String sortApplication = "./sort";

	/**
	 * Start a new application  
	 */
	public static void main(String[] args) {
		
		Application application = new Application();
		application.startGUI();

	}

}
