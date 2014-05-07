/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import client.ClientSerie;
import java.rmi.Remote;
import java.util.Map;

/**
 *
 * @author pierre
 */
public interface ChatRoomSerie extends Remote {
    
    public String getChatRoomName() throws Exception;
    public void sendMsg(String msg, String clientName) throws Exception;
    public void register(ClientSerie client, String name) throws Exception;
    public void unregister (String name) throws Exception;
    public Map<String, ClientSerie> getClientList() throws Exception;
    public String getOwner() throws Exception;
    public String getRoomDescription() throws Exception;
    public void deleteChatRoom() throws Exception;
}
