import java.io.*;
import java.util.*;
import java.net.*;

public class Client {

	public static void main (String args[]) {

		Socket s;
        BufferedReader in;
        Scanner sc = new Scanner(System.in);

		try{
			s = new Socket(InetAddress.getLocalHost(), 2009);
			
			// Recepting message from the server
            in = new BufferedReader (new InputStreamReader (s.getInputStream()));
            String message = in.readLine();
            //Sending the message on console
            System.out.println(message);
            
            //Writting the login
            OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
 
            sc = new Scanner(System.in);
 
            String sendMessage = sc.next();
            bw.write(sendMessage);
            bw.flush();
            
			s.close();
			
		} catch (IOException e){

		}
	}

}
