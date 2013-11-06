import java.io.*;
import java.net.*;
import java.util.*;

public class Player {
	private Socket socket;
	private String name;
	private int score;
	private ChosingWindow chosingWindow; // Adding a choosing grafical window for each player
	
	public Player () {
		name = null;
		socket = null;
		score = 0;
		chosingWindow = null;
	}
	
	public Player (Socket s, String nm) {
		this.name = nm;
		this.socket = s;
		this.score = 0;
		this.chosingWindow = new ChosingWindow(name);
	}
	
	public int getScore(){
		return score;
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	public String getName() {
		return name;
	}
	
	public Choice purposeChoice() {
		return chosingWindow.getChoice();
	}
	
	public void incrementScore() {
		score ++;
	}

}
