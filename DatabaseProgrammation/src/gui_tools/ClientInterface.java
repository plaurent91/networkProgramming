package gui_tools;

/*
 * ClientInterface.java requires SpringUtilities.java
 */
import client.Client;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableRowSorter;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class ClientInterface extends JPanel {

    private boolean DEBUG = false;
    private JLabel information = new JLabel();
    private JButton refresh = new JButton ("Refresh");
    private JTable table;
    private JTextField filterText;
    private JButton addParticipant = new JButton("Add Participant");
    private JButton deleteParticipant = new JButton("Delete Participant");
    private TableRowSorter<MyTableModel> sorter;
    private Client client;
    private MyTableModel model;

    public ClientInterface(Client client) throws Exception {
        super();
        this.client = client;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        client.setClientInterface(this);

        //Create a table with a sorter.
        model = new MyTableModel(client);
        sorter = new TableRowSorter<MyTableModel>(model);
        table = new JTable(model);
        table.setRowSorter(sorter);
        table.setPreferredScrollableViewportSize(new Dimension(5000, 5000));
        table.setFillsViewportHeight(true);
        
        

        //For the purposes of this example, better to have a single
        //selection.
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //When selection changes, provide user with row numbers for
        //both view and model.
        //Fiddle with the Sport column's cell editors/renderers.
        setUpSexColumn(table, table.getColumnModel().getColumn(2));
        setUpCountryColumn(table, table.getColumnModel().getColumn(3));
        setUpSportColumn(table, table.getColumnModel().getColumn(7));

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);

        //Create a separate form for filterText 
        JPanel form = new JPanel(new SpringLayout());
        JLabel l1 = new JLabel("Filter Text:", SwingConstants.TRAILING);
        form.add(l1);
        filterText = new JTextField();
        filterText.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }

                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }

                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
                    }
                });

        // Setting the buttons
        addParticipant.addActionListener(new addParticipantsListener());
        deleteParticipant.addActionListener(new deleteParticipantsListener());
        refresh.addActionListener(new refreshListener()); 
                
        l1.setLabelFor(filterText);
        form.add(filterText);
        form.add(deleteParticipant);
        form.add(addParticipant);
        form.add(refresh);
        setUpdateText("Info");
        form.add(information);
        SpringUtilities.makeCompactGrid(form, 3, 2, 6, 6, 6, 6);
        add(form);

    }

    /**
     * Update the row filter regular expression from the expression in the text
     * box.
     */
    private void newFilter() {
        RowFilter<MyTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(filterText.getText(), 1, 4);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }

    public void setUpSexColumn(JTable table,
            TableColumn sexColumn) {
        //Set up the editor for the sport cells.
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("F");
        comboBox.addItem("M");
        comboBox.addItem("Other");
        sexColumn.setCellEditor(new DefaultCellEditor(comboBox));

        //Set up tool tips for the sport cells.
        DefaultTableCellRenderer renderer
                = new DefaultTableCellRenderer();
        renderer.setToolTipText("Display the possibilities");
        sexColumn.setCellRenderer(renderer);
    }

    public void setUpCountryColumn(JTable table,
            TableColumn countryColumn) {
        //Set up the editor for the sport cells.
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Sweden");
        comboBox.addItem("Finland");
        comboBox.addItem("Norway");
        comboBox.addItem("Denmark");
        comboBox.addItem("Iceland");
        comboBox.addItem("Other");
        countryColumn.setCellEditor(new DefaultCellEditor(comboBox));

        //Set up tool tips for the sport cells.
        DefaultTableCellRenderer renderer
                = new DefaultTableCellRenderer();
        renderer.setToolTipText("Click for combo box");
        countryColumn.setCellRenderer(renderer);
    }

    public void setUpSportColumn(JTable table,
            TableColumn sportColumn) {
        //Set up the editor for the sport cells.
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Alpine Skiing");
        comboBox.addItem("Biathlon");
        comboBox.addItem("Cross Country");
        comboBox.addItem("Skijumping");
        comboBox.addItem("Speed Skating");
        comboBox.addItem("Other");
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

        //Set up tool tips for the sport cells.
        DefaultTableCellRenderer renderer
                = new DefaultTableCellRenderer();
        renderer.setToolTipText("Click for combo box");
        sportColumn.setCellRenderer(renderer);
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI(final Client client) throws Exception {
        //Create and set up the window.
        JFrame frame = new JFrame("Nordic Games' Participants");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                try {
                    client.getNogServer().unregister(client);
                } catch (Exception ex) {
                    Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //Create and set up the content pane.
        ClientInterface newContentPane = new ClientInterface(client);

        newContentPane.setOpaque(
                true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();

        frame.setVisible(
                true);

        while (true) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
            if (client.isIsUpdated()) {
                //frame.remove(newContentPane);
                newContentPane = new ClientInterface(client);

                newContentPane.setOpaque(true); //content panes must be opaque
                frame.setContentPane(newContentPane);
                
                newContentPane.getInformation().setText("Update done!");
                
                // Revalidate frame to cause it to layout the new panel correctly.
                frame.revalidate();
                client.setIsUpdated(false);
            }
        }
    }

    public void displayInterface() throws Exception {
        createAndShowGUI(client);
    }

    public MyTableModel getModel() {
        return model;

    }

    class refreshListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            client.setIsUpdated(true);
        }
    }

    class addParticipantsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                new AddParticipant(client);
            } catch (SQLException ex) {
                Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class deleteParticipantsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                new DeleteParticipant(client);
            } catch (SQLException ex) {
                Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public JLabel getInformation() {
        return information;
    }

    public void setUpdateText(String text) {
        this.information.setText(text);
    }
    
    

}
