import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

	public static void main(String[] zero){

		ServerSocket socket;
		try {
			socket = new ServerSocket(2009);
			Thread t = new Thread(new Accept_clients(socket));
			t.start();
			System.out.println("Server is ready !");

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}