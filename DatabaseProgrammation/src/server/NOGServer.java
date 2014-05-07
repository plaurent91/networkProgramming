package server;

import client.*;
import database.DbLinkParticipants;
import java.awt.List;
import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteStub;
import java.sql.SQLException;
import java.util.ArrayList;

public interface NOGServer extends Remote {

    
    public void showUpdate (String message, ClientSerie client) throws Exception;
    public String[] getRoom() throws Exception;
    public void unregister (ClientSerie client) throws Exception;
    public void registerChat(String chatName, String owner, ClientSerie client, String roomDescription) throws Exception;
    public void register (String name, String pass, String job, boolean isAdmin, ClientSerie client, Boolean isNewbie) throws Exception;
    public ArrayList getAllUsers() throws Exception;
    public ArrayList<ChatRoomImpl> getChatList() throws Exception;
}
