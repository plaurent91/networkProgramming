import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

	public static void main(String[] max_Number){
		
		int maxNumber;
		if (max_Number.length == 0)
			maxNumber = 2; // 2 default players - if you want more, just add it in the args[]
		else maxNumber = Integer.parseInt(max_Number[0]);
		ServerSocket socket;
		try {
			socket = new ServerSocket(2009);
			System.out.println("Server is ready !");
			System.out.println("Maximum " + maxNumber + " players in the game");
			Thread t = new Thread(new Accept_clients(socket, maxNumber));
			t.start();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}