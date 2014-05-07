package gui_tools;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jan Stola
 */
public class Form extends javax.swing.JFrame {

    private Client client;
    private boolean isCompleted;
    private boolean toRegister = false;

    public Form(Client client) {
        this.client = client;
        this.isCompleted = false;
        this.setVisible(true);
        client.setNewbie(false);
        initComponents(toRegister);
        while (true) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
            if (getIsCompleted()) {
                break;
            }
        }
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Client getClient() {
        return client;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(boolean toRegister) {

        setTitle("Nordic Games' Registration");
        setLocation(350, 250);
        getContentPane().removeAll();
        loginLabel = new javax.swing.JLabel();
        loginField = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        passConfirmationLabel = new javax.swing.JLabel();
        passConfirmationField = new javax.swing.JPasswordField();
        validation = new javax.swing.JButton();
        occupationLabel = new javax.swing.JLabel();
        occupationField = new javax.swing.JTextField();
        stateLabel = new javax.swing.JLabel();
        function = new javax.swing.JComboBox();
        informationLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        loginLabel.setText("Login:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(loginLabel, gridBagConstraints);

        loginField.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(loginField, gridBagConstraints);

        passLabel.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(passLabel, gridBagConstraints);

        passField.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(passField, gridBagConstraints);

        if (toRegister) {
            passConfirmationLabel.setText("Confirm Pass:");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
            getContentPane().add(passConfirmationLabel, gridBagConstraints);

            passConfirmationField.setColumns(20);
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
            getContentPane().add(passConfirmationField, gridBagConstraints);

            occupationLabel.setText("Occupation:");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
            getContentPane().add(occupationLabel, gridBagConstraints);

            occupationField.setColumns(20);
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
            getContentPane().add(occupationField, gridBagConstraints);

            stateLabel.setText("Function:");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 4;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
            getContentPane().add(stateLabel, gridBagConstraints);
        }

        function.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"User", "Admin", "Register"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(function, gridBagConstraints);

        validation.setText("Ok");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(validation, gridBagConstraints);
        validation.addActionListener(new BoutonListener());

        informationLabel.setText("Information here ...");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(informationLabel, gridBagConstraints);

        pack();
    }

    class BoutonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            ArrayList<String[]> Usr = new ArrayList();
            try {
                Usr = client.getNogServer().getAllUsers();
            } catch (Exception ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (!client.isNewbie() && (function.getSelectedItem().equals("Admin") || function.getSelectedItem().equals("User"))) {               
                // Checking the authentification
                
                int i = 0;

                while (!(Usr.get(i))[0].equals(loginField.getText())) {
                    i ++;
                    if (i == Usr.size()) {
                        informationLabel.setText("This login doesn't exist!");
                        pack();
                        return;
                    }
                }
                
                if (!(Usr.get(i))[1].equals(passField.getText())) {
                    informationLabel.setText("Wrong Password, please retype it!");
                    pack();
                    return;
                }
                
                if (function.getSelectedItem().equals("Admin") && !(Usr.get(i))[2].equals("true")) {
                    informationLabel.setText("Sorry, you don't have the Admin rights!");
                    pack();
                    return;
                }
                
                client.setName(loginField.getText());
                client.setPass(passField.getText());
                if (function.getSelectedItem().equals("Admin")) {
                    client.setAdmin(true);
                } else {
                    client.setAdmin(false);
                }
                setIsCompleted(true);
                dispose();
                return;
            }

            if (function.getSelectedItem().equals("Register")) {
                toRegister = true;
                client.setNewbie(true);
                initComponents(toRegister);
                return;
            } else {

                for (int i = 0; i < Usr.size(); i++) {

                    if ((Usr.get(i))[0].equals(loginField.getText())) {
                        informationLabel.setText("This login already exists, please change it!");
                        pack();
                        return;
                    }
                }

                if (!passField.getText().equals(passConfirmationField.getText())) {

                    informationLabel.setText("Retype password (difference beetwen 1st and 2nd one)");
                    pack();
                } //else if (client.getNogServer().getAllUsers())
                else {
                    client.setName(loginField.getText());
                    client.setPass(passField.getText());
                    client.setOccupation(occupationField.getText());
                    if (function.getSelectedItem().equals("Admin")) {
                        client.setAdmin(true);
                    } else {
                        client.setAdmin(false);
                    }
                    setIsCompleted(true);//isCompleted = true;
                    dispose();
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField occupationField;
    private javax.swing.JLabel occupationLabel;
    private javax.swing.JTextField loginField;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JComboBox function;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JTextField passConfirmationField;
    private javax.swing.JLabel passConfirmationLabel;
    private javax.swing.JTextField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel informationLabel;
    private javax.swing.JButton validation;
    private java.awt.GridBagConstraints gridBagConstraints;
    // End of variables declaration//GEN-END:variables

}
