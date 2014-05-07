/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_tools;

import client.Client;
import database.DbLinkParticipants;
import database.Participant;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.html.HTMLDocument.Iterator;
import server.NOGServer;

/**
 *
 * @author pierre
 */
public class MyTableModel extends AbstractTableModel {

    private DbLinkParticipants dbLink;
    private NOGServer nogServer;
    private Object[][] data;
    private Client client;

    public MyTableModel(Client client) throws Exception {
        dbLink = client.getDbLink();
        data = dbLink.getPartObj(dbLink.selectAllParticipants());
        nogServer = client.getNogServer();
        this.client = client;
    }

    private String[] columnNames = {
        "ID",
        "Name",
        "SEX",
        "COUNTRY",
        "BIRTHDATE",
        "SIZE",
        "WEIGHT",
        "SPORT"};

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col == 0) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
        try {
            dbLink.updateField(columnNames[col], (String) value, (int) data[row][0]);
            client.getNogServer().showUpdate(data[row][1] + " has been updated by " + client.getName() + 
                    " in: " + columnNames[col] + " with value " + (String) value, client);

        } catch (Exception ex) {
            Logger.getLogger(MyTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
