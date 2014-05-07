/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import database.DbLinkParticipants;
import gui_tools.ClientInterface;
import gui_tools.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import server.ChatRoomSerie;
import server.NOGServer;

/**
 *
 * @author pierre
 */
public class Client extends UnicastRemoteObject implements ClientSerie {

    private NOGServer nogServer;
    private ClientInterface clientInterface;
    private String name;
    private String pass;
    private String occupation;
    private boolean admin;
    private boolean isOnline;
    private boolean isUpdated;
    private boolean newbie;
    private ChatRoomSerie chatRoomSerie;
    private ChatRoom chatRoom;
    private DbLinkParticipants dbLink;
    private Console console;

    public Client() throws Exception {
        this.nogServer = (NOGServer) Naming.lookup("NordicGames");
        this.dbLink = new DbLinkParticipants();
        this.clientInterface = new ClientInterface(this);
        this.chatRoom = new ChatRoom(this);
        this.isUpdated = false;
    }

    public void setDbLink() throws Exception {
        this.dbLink = new DbLinkParticipants();
    }

    public DbLinkParticipants getDbLink() {
        return this.dbLink;
    }

    public void run() throws SQLException, InterruptedException, Exception {
        nogServer.register(getName(), getPass(), getOccupation(), isAdmin(), this, isNewbie());
        if (isAdmin()) {
            getClientInterface().displayInterface();
        } else {
            chatRoom.createAndShowGui();
        }

    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        Form f = new Form(client);
        client = f.getClient();
        client.run();

    }

    public ClientInterface getClientInterface() {
        return clientInterface;
    }

    public void setClientInterface(ClientInterface clientInterface) {
        this.clientInterface = clientInterface;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isNewbie() {
        return newbie;
    }

    public void setNewbie(boolean newbie) {
        this.newbie = newbie;
    }

    public boolean isIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public NOGServer getNogServer() {
        return nogServer;
    }

    public void setNogServer(NOGServer nogServer) {
        this.nogServer = nogServer;
    }

    @Override
    public void receiveMsg(String msg) throws RemoteException {
        this.clientInterface.setUpdateText(msg);
    }

    public void receiveChatMsg(String msg) throws RemoteException {
        this.console.setText(msg);
    }

    public boolean isIsUpdated() {
        return isUpdated;
    }

    public void setIsUpdated(boolean isUpdated) {
        this.isUpdated = isUpdated;
    }

    public ChatRoomSerie getChatRoom() {
        return chatRoomSerie;
    }

    public void setChatRoom(ChatRoomSerie chatRoom) {
        this.chatRoomSerie = chatRoom;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public synchronized void RunCommande(String Message) throws Exception {
        //StringTokenizer tokenizer = new StringTokenizer(Message);
        switch (Message.split(" ")[0]) {
            case "quit": {
                nogServer.unregister(this);
                chatRoomSerie.sendMsg("Server info: " + name + " is leaving the room", name);
                chatRoomSerie.unregister(this.getName());
                System.exit(0);
                break;
            }
            case "/": {
                this.getConsole().cleanConsole();
                break;
            }
            case "isOnline": {
                for (String mapKey : chatRoomSerie.getClientList().keySet()) {
                    // utilise ici hashMap.get(mapKey) pour accéder aux valeurs
                    console.setText(mapKey + " is online!");
                }
                console.setText("\n");
                break;
            }
            case "owner": {
                console.setText("Server message: " + chatRoomSerie.getOwner() + " is the room's owner");
                break;
            }
            case "destroyRoom": {
                if (name.equals(chatRoomSerie.getOwner())) {
                    chatRoomSerie.sendMsg(name + " is destroying the room, please quit!", name);
                    chatRoomSerie.deleteChatRoom();
                    nogServer.getChatList().remove(chatRoomSerie.getChatRoomName());
                    console.setText("You have destroyed the room");
                } else {
                    console.setText("You can't destroy the room as you aren't the owner!");
                }

                break;
            }
            case "help": {
                BufferedReader buff = new BufferedReader(new FileReader("command"));
                String line;
                while ((line = buff.readLine()) != null) {
                    console.setText(line);
                }
                buff.close();
                break;
            }
            case "description": {
                console.setText("Server message: " + chatRoomSerie.getRoomDescription());
                break;
            }
            default: {
                chatRoomSerie.sendMsg(name + ": " + Message, name);
                break;
            }
        }
    }

}
