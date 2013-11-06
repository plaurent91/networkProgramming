import java.io.*;
import java.net.*;
import java.util.*;

public class Player {
	private Socket socket;
	private String name;
	private int score;
	
	public Player () {
		name = null;
		socket = null;
		score = 0;
	}
	
	public Player (Socket s, String nm) {
		this.name = nm;
		this.socket = s;
		this.score = 0;
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	public String getName() {
		return name;
	}
	
	public void increment () {
		score ++;
	}

}
