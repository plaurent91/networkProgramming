import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Accept_clients implements Runnable {

	private ServerSocket socketserver;
	private Socket socket;
	private int nbrclient = 0;
	private int maxNumber;
	//private Player[] player;
	private ArrayList <Player> ArrayPlayer = new ArrayList <Player>();
	private Game game;
	private PrintWriter out;
	private BufferedReader in;

	public Accept_clients(ServerSocket s, int number){
		socketserver = s;
		maxNumber = number;
		//player = new Player [maxNumber];
	}

	public void run() {

		try {
			while(true && nbrclient < maxNumber){
				nbrclient++;
				socket = socketserver.accept(); // Client connection
				out = new PrintWriter(socket.getOutputStream());
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				out.println("Enter your name: ");
				out.flush();
				String name = in.readLine();
				
				ArrayPlayer.add(new Player (socket, name));
				System.out.println(ArrayPlayer.get(nbrclient - 1).getName()+ " is now connected !");
			}
			socketserver.close();
			System.out.println("Number of connexion has reached a maximum --> Server is now full");
			System.out.println("GAME STARTS !!!");
			
			//Starting the game:
			while (ArrayPlayer.size() > 1)
			game = new Game (ArrayPlayer);
			//ArrayPlayer = game.getArray();

			//Closing the sockets !!!
			Iterator <Player> it = ArrayPlayer.iterator();
					while (it.hasNext())
						it.next().getSocket().close();
					System.out.println("GAME IS OVER !!!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}