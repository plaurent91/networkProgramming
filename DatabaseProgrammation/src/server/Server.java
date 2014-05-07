package server;

import client.Client;
import java.net.MalformedURLException;
import database.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.SQLException;

public class Server {
        private String Server = "NordicGames";

	public Server () throws Exception {
		NOGServer nogServer = new NOGServerImpl();
		java.rmi.Naming.rebind(Server, nogServer);
		System.out.println("System is now ready");
	}

	public static void main (String[] args) throws Exception{
                LocateRegistry.createRegistry(1099);
            new Server();
	}

}