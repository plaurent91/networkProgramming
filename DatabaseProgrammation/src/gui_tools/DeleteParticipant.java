package gui_tools;

import client.Client;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * @author Jan Stola
 */
public class DeleteParticipant extends javax.swing.JFrame {

    private Client client;

    public DeleteParticipant(Client client) throws SQLException {
        this.client = client;
        this.setVisible(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws SQLException {

        setTitle("Delete Participant to NOG");
        setLocation(350, 250);
        getContentPane().removeAll();

        IDLabel = new javax.swing.JLabel();
        IDField = new javax.swing.JTextField("Type the ID to cancel");
        IDField.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                IDField.setText("");
            }
        });
        passLabel = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        validation = new javax.swing.JButton();
        informationLabel = new javax.swing.JLabel();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        IDLabel.setText("ID: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(IDLabel, gridBagConstraints);

        IDField.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(IDField, gridBagConstraints);

        passLabel.setText("Pass: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(passLabel, gridBagConstraints);

        passField.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(passField, gridBagConstraints);

        validation.setText("Ok");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(validation, gridBagConstraints);
        validation.addActionListener(new BoutonListener());

        informationLabel.setText("Validate by Typing your pass");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(informationLabel, gridBagConstraints);

        pack();
    }

    class BoutonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (!passField.getText().equals(client.getPass())) {
                informationLabel.setText("Unable to delete the participant, wrong password");
                pack();
                return;
            }
            try {
                client.getDbLink().deleteParticipant(Integer.parseInt(IDField.getText()));
                client.setIsUpdated(true);
                try {
                    client.getNogServer().showUpdate("Participant (" + IDField.getText() + ") has been deleted by " + client.getName(),
                            client);
                } catch (Exception ex) {
                    Logger.getLogger(AddParticipant.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (SQLException ex) {
                Logger.getLogger(AddParticipant.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        }
    }

// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDLabel;
    private javax.swing.JTextField IDField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JTextField passField;
    private javax.swing.JLabel informationLabel;
    private javax.swing.JButton validation;
    private java.awt.GridBagConstraints gridBagConstraints;
}
