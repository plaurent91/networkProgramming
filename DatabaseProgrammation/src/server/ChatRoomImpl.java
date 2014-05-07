/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import client.ClientSerie;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import javax.swing.RowFilter.Entry;

/**
 *
 * @author pierre
 */
public class ChatRoomImpl extends UnicastRemoteObject implements ChatRoomSerie {

    private String name;
    private String owner;
    private ClientSerie client;
    private String roomDescription;
    private Map<String, ClientSerie> clientList = new HashMap<String, ClientSerie>();

    public ChatRoomImpl(String name, String clientName, ClientSerie client, String roomDescription) throws Exception {
        super();
        this.name = name;
        this.owner = clientName;
        this.client = client;
        this.roomDescription = roomDescription;
        Naming.rebind(name, this);
    }

    public String getChatRoomName() throws Exception {
        return this.name;
    }

    public void sendMsg(String msg, String clientName) throws Exception {
        for (String mapKey : clientList.keySet()) {
            // utilise ici hashMap.get(mapKey) pour accéder aux valeurs
            if (!clientName.equals(mapKey)) {
                clientList.get(mapKey).receiveChatMsg(msg);
            }
        }
    }

    public void register(ClientSerie client, String name) throws Exception {
        clientList.put(name, client);
    }

    public void unregister(String name) throws Exception {
        clientList.remove(name);
    }

    public Map<String, ClientSerie> getClientList() throws Exception {
        return clientList;
    }

    public void deleteChatRoom() throws Exception {
        Naming.unbind(name);
        UnicastRemoteObject.unexportObject(this, true);
        }

    public String getOwner() throws Exception {
        return owner;
    }

    public String getRoomDescription() throws Exception {
        return roomDescription;
    }

}
