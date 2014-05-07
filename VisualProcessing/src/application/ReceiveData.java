package application;

import gui_package.Application;
import java.io.*;
import java.util.StringTokenizer;

/**
 * This class allows both the interfaces (host/guest) to communicate each other
 * It is the class you have to modify if you want to implement new functionalities
 * @author pierre
 *
 */

public class ReceiveData {

	private BufferedReader in;
	private PrintWriter out;
	private Application javaGUI;

	/**
	 * To receive data, you need the following parameters:
	 * @param in the inputStream of your application
	 * @param out the outputStream of your application
	 * @param javaGUI a link to your application
	 */
	public ReceiveData (BufferedReader in, PrintWriter out, Application javaGUI) {
		this.in = in;
		this.out = out;
		this.javaGUI = javaGUI; 
	}

	/**
	 * this function provides the implementation of a received command.
	 * It is the function you have to modify if you want to implement new functionalities
	 * @param command is the link (String) to the command you have asked 
	 * @throws IOException 
	 */
	public void analyzeData (String command) throws IOException {

		if ((command != null) &&  (command.length() != 0)) {
			// Check if it is the end of a trasmission
			switch (command.split(" ")[0]) {
			case "End": {
				javaGUI.cleanUp();
				javaGUI.changeStatusTS(javaGUI.DISCONNECTING, true);
				break;
			}

			case "TakePhoto": {
				String title = "image";
				captureImage take = new captureImage(title);
				take.captureFrame();
				out.println("Photo has been taken by host!");
				break;
			}

			case "ref": {
				String title = "image";
				captureImage tak= new captureImage(title, true);
				tak.captureFrame();
				out.println("Reference picture has been taken by host!");
				break;
			}

			case "delete": {
				if (command.split(" ").length != 2) {
					out.println("You didn't provide the image number ... Put it!");
				}
				File imgToDelete = new File(Main.ImagePath + "image" + command.split(" ")[1] + ".png");
				if (!imgToDelete.exists())
					out.println("Image doesn't exist!");
				else imgToDelete.delete();
				out.println("image" + command.split(" ")[1] + " has been deleted from your db");
				for (int i = Integer.valueOf(command.split(" ")[1]); i < new File (Main.ImagePath).length(); i++) {
					File f = new File(Main.ImagePath + "image" + i + ".png");
					f.renameTo(new File(Main.ImagePath + "image" + (i-1) + ".png"));
				}
				break;
			}

			case "size": {
				int i = 0;
				String result = "";
				File folder = new File(Main.ImagePath);
				out.println("Database contains " + folder.list().length + " images");
				break;
			}

			case "sort": {
				/**
				 * Execute the C++ function to sort the database
				 */
				Process p;
				String[] arg = {Main.sortApplication};
				p = Runtime.getRuntime().exec(arg);
				BufferedReader in = new BufferedReader(  
						new InputStreamReader(p.getInputStream()));  
				String line = null;  
				while ((line = in.readLine()) != null) {  
					out.println(line);  
				}  
				break;
			}

			case "display": {
				if (command.split(" ").length != 2) {
					out.println("You didn't provide the image number ... Put it!");
				}
				else {
					DisplayImage imageToDisplay = new DisplayImage(command.split(" ")[1]);
					imageToDisplay.DisplayImage(out);}
				break;
			}

			case "help": {
				BufferedReader buff = new BufferedReader(new FileReader("command.txt"));
				String line;
				while ((line = buff.readLine()) != null) {
					out.println(line);
				}
				buff.close();
				break;
			}

			// Otherwise, receive what text
			default: {
				javaGUI.appendToChatBox(command + "\n");
				javaGUI.changeStatusTS(javaGUI.NULL, true);
				break;
			}
			}
		}

	}
}
