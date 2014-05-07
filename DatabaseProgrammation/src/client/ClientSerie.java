package client;

import java.io.Externalizable;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientSerie extends Remote, Serializable{
	void receiveMsg (String msg) throws RemoteException;
        public void receiveChatMsg(String msg) throws RemoteException;
}