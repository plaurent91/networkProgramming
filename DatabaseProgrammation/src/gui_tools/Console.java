package gui_tools;

import client.Client;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class Console extends JFrame implements ActionListener {

    private JTextArea console = new JTextArea();
    private JTextField input;
    private String message;
    private Client client;

    public Console(final Client client) throws Exception {
        this.client = client;
        this.setTitle(client.getName() + "@" + client.getChatRoom().getChatRoomName() + "'s Console");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    client.getChatRoom().unregister(client.getName());
                } catch (Exception ex) {
                    Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.setSize(400, 400);
        this.setLocation(100, 100);
        console = new JTextArea(200, 200);
        console.setFont(new Font("Helvetica", Font.PLAIN, 12));;
        DefaultCaret caret = (DefaultCaret) console.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        this.add(console);
        input = new JTextField();
        input.addActionListener((ActionListener) this);
        this.add(console);
        this.add(input, "South");
        JScrollPane sp = new JScrollPane(console);
        sp.setBounds(10, 60, 780, 500);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.getContentPane().add(sp);
        this.setAlwaysOnTop(true);
        
        setText("Welcome on the " + client.getChatRoom().getChatRoomName() + "'s chat."
                + "\nYou can get all the command by typing help or just chat with everyone.\n");
        
    }
    
    public void setConsoleVisible() {
        this.setVisible(true);
    }

    public void setText(String text) {
        console.setText(console.getText() + text + "\n");
    }

    public String getMessage() {
        return message;
    }

    public void cleanConsole() {
        this.console.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.message = input.getText();
        try {
            setText(client.getName() + ": " + message);
            this.client.RunCommande(message);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        input.setText("");
    }

}
