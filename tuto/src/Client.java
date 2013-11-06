import java.io.*;
import java.net.*;

public class Client {

	public static void main (String args[]) {

		Socket s;

		try{
			s = new Socket(InetAddress.getLocalHost(), 2009);
			s.close();
		} catch (IOException e){

		}
	}

}
