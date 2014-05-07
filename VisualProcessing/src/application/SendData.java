package application;

import gui_package.Application;

import java.io.*;
import java.net.*;

/**
 * Class which processes the data to send
 * Modify it in order to have a different process of the data to be sent
 * @author pierre
 *
 */
public class SendData {

	private BufferedReader in;
	private PrintWriter out;
	private Application javaGUI;

	/**
	 * Constructor which only need the GUI model to display the results
	 * @param javaGUI
	 */
	public SendData (Application javaGUI) {
		this.javaGUI = javaGUI;
	}
	
	/**
	 * Constructor you have to call once the connection has been established between host/guest
	 * @param in BufferedReader for the reception side
	 * @param out PrintWriter for the sending side
	 * @param javaGUI
	 */
	public SendData (BufferedReader in, PrintWriter out, Application javaGUI) {
		this.in = in;
		this.out = out;
		this.javaGUI = javaGUI;
	}

	/**
	 * Allows the guest to set up a server with the host
	 * @throws IOException
	 */
	public void setUpServer() throws IOException {
		if (javaGUI.isHost) {
			javaGUI.hostServer = new ServerSocket(javaGUI.port);
			javaGUI.socket = javaGUI.hostServer.accept();
		}
		else
			javaGUI.socket = new Socket(javaGUI.hostIP, javaGUI.port);
	}

	/**
	 * Method called to take photos (when clicking on the button)
	 */
	public void takePhoto() {
		out.println("TakePhoto");
	}

	/**
	 * method used to clear the console
	 */
	public void clearConsole() {
		javaGUI.chatText.setText("Type help for command buttons\n\n");
	}

	/**
	 * This method displays how to process the data to be sent
	 * @param toSend StringBuffer --> data to send
	 */
	public void sendData (StringBuffer toSend) {
		clearConsole();
		out.println(toSend); 
		toSend.setLength(0);
	}

}