package server;
import client.*;
import database.*;

//import gui_tools.PasswordGUI;

import java.awt.List;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.RemoteStub;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.sql.ResultSet;

@SuppressWarnings("serial")
public class NOGServerImpl extends UnicastRemoteObject implements NOGServer {
    
    private DbLinkUsers dbLinkUsers = new DbLinkUsers();
    private ArrayList<ClientSerie> clientList = new ArrayList<ClientSerie>();
    private ArrayList<ChatRoomImpl> chatList = new ArrayList<ChatRoomImpl>();
    
	public NOGServerImpl() throws Exception {
		super();
	}
        
    @Override
    public void showUpdate(String message, ClientSerie client) throws Exception {
        for (int i = 0; i < clientList.size(); i ++) {
            if(!clientList.get(i).equals(client))
            clientList.get(i).receiveMsg(message);
        }
    }

    @Override
    public void register(String name, String pass, String job, boolean isAdmin, ClientSerie client, Boolean isNewbie) throws Exception {
        clientList.add(client);
        if (isNewbie)
        dbLinkUsers.insert(name, pass, job, isAdmin);
    }   
    
    public ArrayList getAllUsers() throws SQLException {
        return dbLinkUsers.selectAllUsers();
    }
    
    public void registerChat(String chatName, String owner, ClientSerie client, String roomDescription) throws Exception {
        chatList.add(new ChatRoomImpl(chatName, owner, client, roomDescription));
    }
    
    public String[] getRoom() throws Exception{
        String[] roomNames = new String[chatList.size()];
        if (chatList.isEmpty()) {
            roomNames = new String[1];
            roomNames[0] = "No room are available, create it!";
        }
        for (int i = 0; i < chatList.size(); i ++)
            roomNames[i] = chatList.get(i).getChatRoomName();
        return roomNames;
    }

    @Override
    public void unregister(ClientSerie client) throws Exception {
        clientList.remove(client);
        System.out.println("Client is unregistered !");
    }

    public ArrayList<ChatRoomImpl> getChatList() throws Exception {
        return chatList;
    }
    
}
