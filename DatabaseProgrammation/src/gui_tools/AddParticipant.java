package gui_tools;

import client.Client;
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
import server.NOGServer;

/**
 * @author Jan Stola
 */
public class AddParticipant extends javax.swing.JFrame {

    private Client client;

    public AddParticipant(Client client) throws SQLException {
        this.client = client;
        this.setVisible(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws SQLException {

        setTitle("Register new athlete to NOG");
        setLocation(350, 250);
        getContentPane().removeAll();

        IDLabel = new javax.swing.JLabel();
        IDField = new javax.swing.JTextField(Integer.toString(client.getDbLink().findMaxID() + 1));
        IDField.setEditable(false);
        surnameNameLabel = new javax.swing.JLabel();
        surnameNameField = new javax.swing.JTextField();

        birthdayField = new javax.swing.JTextField("Please use yyyy/mm/dd");
        birthdayField.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                birthdayField.setText("");
            }
        });

        sizeLabel = new javax.swing.JLabel();
        sizeField = new javax.swing.JTextField();
        weightLabel = new javax.swing.JLabel();
        weightField = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        genderChoice = new javax.swing.JComboBox();
        sportLabel = new javax.swing.JLabel();
        sportChoice = new javax.swing.JComboBox();
        countryChoice = new javax.swing.JComboBox();
        validation = new javax.swing.JButton();
        countryLabel = new javax.swing.JLabel();
        birthdayLabel = new javax.swing.JLabel();
        function = new javax.swing.JComboBox();
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

        surnameNameLabel.setText("Surname, Name: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(surnameNameLabel, gridBagConstraints);

        surnameNameField.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(surnameNameField, gridBagConstraints);

        genderLabel.setText("Gender (F or M): ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(genderLabel, gridBagConstraints);

        genderChoice.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"F", "M"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);

        getContentPane()
                .add(genderChoice, gridBagConstraints);

        countryLabel.setText("Country: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(countryLabel, gridBagConstraints);

        countryChoice.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Denmark",
            "Finland",
            "Iceland",
            "Norway", "Sweden"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);

        getContentPane()
                .add(countryChoice, gridBagConstraints);

        birthdayLabel.setText("Birthdate: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(birthdayLabel, gridBagConstraints);

        birthdayField.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(birthdayField, gridBagConstraints);

        sizeLabel.setText("Size (cm): ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(sizeLabel, gridBagConstraints);

        sizeField.setColumns(5);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(sizeField, gridBagConstraints);

        weightLabel.setText("Weight (kg): ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(weightLabel, gridBagConstraints);

        weightField.setColumns(5);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(weightField, gridBagConstraints);

        sportLabel.setText("Sport: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(sportLabel, gridBagConstraints);

        sportChoice.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Alpine Skiing",
            "Biathlon",
            "Cross Country",
            "Skijumping", "Speed Skating"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);

        getContentPane()
                .add(sportChoice, gridBagConstraints);

        validation.setText("Ok");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);

        getContentPane().add(validation, gridBagConstraints);
        validation.addActionListener(
                new BoutonListener());

        informationLabel.setText(
                "Register a new participant to NOG  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);

        getContentPane()
                .add(informationLabel, gridBagConstraints);

        pack();
    }

    class BoutonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                client.getDbLink().createNewParticipant(Integer.parseInt(IDField.getText()), surnameNameField.getText(), 
                                                        (String) genderChoice.getSelectedItem(), (String) countryChoice.getSelectedItem(), 
                                                        birthdayField.getText(), Float.parseFloat(sizeField.getText()), 
                                                        Float.parseFloat(weightField.getText()), (String) sportChoice.getSelectedItem());
               client.setIsUpdated(true);
                try {
                    client.getNogServer().showUpdate("A new participant (" + IDField.getText() + ") has been add by " + client.getName(),
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
    private javax.swing.JComboBox genderChoice;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JTextField IDField;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JComboBox function;
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JComboBox countryChoice;
    private javax.swing.JLabel sportLabel;
    private javax.swing.JComboBox sportChoice;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JTextField surnameNameField;
    private javax.swing.JLabel surnameNameLabel;
    private javax.swing.JLabel informationLabel;
    private javax.swing.JButton validation;
    private javax.swing.JTextField birthdayField;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JTextField sizeField;
    private javax.swing.JLabel weightLabel;
    private javax.swing.JTextField weightField;
    private java.awt.GridBagConstraints gridBagConstraints;
    // End of variables declaration//GEN-END:variables

}
