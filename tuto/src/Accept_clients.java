import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Accept_clients implements Runnable {

	private ServerSocket socketserver;
	private Socket socket;
	private int nbrclient = 0;
	private int maxNumber;
	private Player[] player = new Player[2];

	public Accept_clients(ServerSocket s, int number){
		socketserver = s;
		maxNumber = number;
	}

	public void run() {

		try {
			while(true && nbrclient < maxNumber){
				nbrclient++;
				socket = socketserver.accept(); // Client connection
				System.out.println("Enter your name:");
				Scanner sc = new Scanner(System.in);
				player [nbrclient -1 ] = new Player (socket, sc.next());
				System.out.println(player [nbrclient -1 ].getName()+ " is now connected !");
			}
			socketserver.close();
			System.out.println("Number of connexion have reached a maximum --> Server is now down");
			for (int i = 0; i<maxNumber; i++){
				player[i].getSocket().close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}