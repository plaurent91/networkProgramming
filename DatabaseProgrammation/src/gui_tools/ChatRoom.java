package gui_tools;

import client.Client;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import server.ChatRoomSerie;

/**
 * @author Jan Stola
 */
public class ChatRoom extends JFrame {

    private Client client;
    private JPanel panel;

    public ChatRoom(Client client) {
        this.client = client;
        this.panel = (JPanel) getContentPane();
    }

    public void createAndShowGui() throws Exception {
        this.setVisible(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws SQLException, Exception {

        setTitle("Chat Room for NOG");
        setLocation(350, 250);
        panel.removeAll();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    client.getNogServer().unregister(client);
                    client.getChatRoom().unregister(client.getName());
                } catch (Exception ex) {
                    Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        chatRoomLabel = new JLabel();
        chatRoomBox = new JComboBox();
        joinChatRoom = new JButton("join Room");
        createNewRoom = new JButton("Create a Room");
        information = new JLabel("Select chat room, see who is online");
        roomNameLabel = new JLabel("Room name: ");
        roomNameField = new JTextField();
        validateRoom = new JButton("Create it !");
        description = new JTextArea("Provide a small description about the room\n you want to create");
        description.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                description.setText("");
            }
        });

        panel.setLayout(new GridBagLayout());

        chatRoomLabel.setText("Available rooms: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(chatRoomLabel, gridBagConstraints);

        chatRoomBox.setModel(new DefaultComboBoxModel(client.getNogServer().getRoom()));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panel.add(chatRoomBox, gridBagConstraints);

        createForm(2, 0, gridBagConstraints.LINE_START);
        gridBagConstraints.insets = new Insets(5, 5, 0, 0);
        panel.add(joinChatRoom, gridBagConstraints);
        joinChatRoom.addActionListener(new JoinListener());

        createForm(1, 1, gridBagConstraints.HORIZONTAL);
        panel.add(createNewRoom, gridBagConstraints);
        createNewRoom.addActionListener(new CreateNewRoomListener());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panel.add(roomNameLabel, gridBagConstraints);
        roomNameLabel.setVisible(false);

        createForm(1, 2, GridBagConstraints.HORIZONTAL);
        gridBagConstraints.insets = new Insets(5, 5, 0, 5);
        panel.add(roomNameField, gridBagConstraints);
        roomNameField.setVisible(false);

        createForm(2, 3, gridBagConstraints.HORIZONTAL);
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        panel.add(validateRoom, gridBagConstraints);
        validateRoom.addActionListener(new ValidateListener());
        validateRoom.setVisible(false);

        createForm(1, 4, gridBagConstraints.HORIZONTAL);
        description.setRows(5);
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        panel.add(description, gridBagConstraints);
        description.setVisible(false);
        
        createForm(1, 3, gridBagConstraints.HORIZONTAL);
        panel.add(information, gridBagConstraints);

        pack();
    }

    class CreateNewRoomListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            information.setText("Type the room name and create it");
            createNewRoom.setVisible(false);
            chatRoomLabel.setVisible(false);
            chatRoomBox.setVisible(false);
            joinChatRoom.setVisible(false);
            roomNameLabel.setVisible(true);
            roomNameField.setVisible(true);
            validateRoom.setVisible(true);
            description.setVisible(true);
            pack();
        }
    }

    class JoinListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                client.setChatRoom((ChatRoomSerie) Naming.lookup((String) chatRoomBox.getSelectedItem()));
                client.getChatRoom().register(client, client.getName());
                client.setConsole(new Console(client));
                client.getConsole().setConsoleVisible();
                client.getChatRoom().sendMsg(client.getName() + " is connected on the room!", client.getName());
                dispose();
            } catch (Exception ex) {
                System.out.println("This room doesn't exist");
            }
        }
    }

    class ValidateListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            try {
                client.getNogServer().registerChat(roomNameField.getText(), client.getName(), client, description.getText());
                initComponents();
            } catch (Exception ex) {
                Logger.getLogger(ChatRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void createForm(int x, int y, int Constraints) {
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = Constraints;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(5, 5, 0, 0);
    }

// Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel chatRoomLabel;
    private JComboBox chatRoomBox;
    private JButton joinChatRoom;
    private JButton createNewRoom;
    private JLabel information;
    private JLabel roomNameLabel;
    private JTextField roomNameField;
    private JButton validateRoom;
    private JTextArea description;
    private GridBagConstraints gridBagConstraints;
}