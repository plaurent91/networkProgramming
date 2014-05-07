package database;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.text.html.HTMLDocument.Iterator;

@SuppressWarnings("serial")
public class DbLinkParticipants {

    public static final String TABLE_NAME = "ROOT.PARTICIPANTS";
    private PreparedStatement createAccountStatement;
    private PreparedStatement findAccountStatement;
    private PreparedStatement insertStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement selectStatement;
    private Statement statement;
    private Connection connection;

    public DbLinkParticipants()
            throws RemoteException, ClassNotFoundException, SQLException {
        super();
        this.connection = createDatasource();
        prepareStatements(connection);
        this.statement = connection.createStatement();
        System.out.println("Connected to the DB !");
        this.prepareStatements(connection);
    }

    private Connection createDatasource() throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        DatabaseMetaData dbm = connection.getMetaData();
        return connection;
    }

    private Connection getConnection()
            throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientXADataSource");
        return DriverManager.getConnection(
                "jdbc:derby://localhost:1527/Nordic Games;create=true", "root", "root");
    }

    private void prepareStatements(Connection connection) throws SQLException {
        insertStatement = connection.prepareStatement("INSERT INTO "
                + TABLE_NAME + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        selectStatement = connection.prepareStatement("SELECT * from "
                + TABLE_NAME + " WHERE ID = ?");
        deleteStatement = connection.prepareStatement("DELETE FROM " 
                + TABLE_NAME + " WHERE ID=?");
    }
    
    public void createNewParticipant (int ID, String name, String sex, String country, String birthdate, float size, float weight, String sport) throws SQLException {
        insertStatement.setInt(1, ID);
        insertStatement.setString(2, name);
        insertStatement.setString(3, sex);
        insertStatement.setString(4, country);
        insertStatement.setString(5, birthdate);
        insertStatement.setDouble(6, size);
        insertStatement.setDouble(7, weight);
        insertStatement.setString(8, sport);
        insertStatement.executeUpdate();
    }
    
    public void deleteParticipant (int id) throws SQLException {
        deleteStatement.setInt(1, id);
        deleteStatement.executeUpdate();
    }

    public String getField(String field, int index) throws Exception {
        selectStatement.setInt(1, index);
        ResultSet result = selectStatement.executeQuery();
        if (result.next()) {
            return result.getString(field);
        } else {
            System.out.println("Unable to access the account");
            return null;
        }
    }

    public void updateField(String field, String value, int index) throws Exception {
        selectStatement.setInt(1, index);
        ResultSet result = selectStatement.executeQuery();
        if (result.next()) {
            PreparedStatement updateField = this.connection.prepareStatement(
                    "UPDATE " + TABLE_NAME + " SET " + field
                    + "= ?"
                    + " WHERE ID = ?");
            updateField.setString(1, value);
            updateField.setInt(2, index);
            updateField.executeUpdate();
        } else {
            System.out.println("Unable to access the account");
        }
    }

    public ArrayList<Participant> selectAllParticipants() throws SQLException {
        ResultSet result = statement.executeQuery("SELECT * FROM " + TABLE_NAME);
        ArrayList<Participant> allParticipant = new ArrayList();
        while (result.next()) {
            String Name = result.getString("Name");
            int Id = result.getInt("ID");
            String Sex = result.getString("Sex");
            String Country = result.getString("Country");
            String Birthdate = result.getString("Birthdate");
            float Size = result.getFloat("Size");
            float Weight = result.getFloat("Weight");
            String Sport = result.getString("Sport");

            Participant participant = new Participant(Id, Name, Sex, Country, Birthdate,
                    Size, Weight, Sport);
            allParticipant.add(participant);
            //System.out.println("Participant " + participant.toString());
        }
        return allParticipant;
    }

    public int findMaxID() throws SQLException {
        ResultSet rs = statement.executeQuery("select max(ID) from " + TABLE_NAME);
        rs.next();
        int myMaxId = rs.getInt(1);
        return myMaxId;
    }

    public Object[][] getPartObj(ArrayList<Participant> ArrayPart) {
        Object[][] PartObj = new Object[ArrayPart.size()][8];

        java.util.Iterator<Participant> it = ArrayPart.iterator();
        int i = 0;

        while (it.hasNext()) {
            Participant participant = it.next();
            PartObj[i][0] = participant.getID();
            PartObj[i][1] = participant.getName();
            PartObj[i][2] = participant.getSex();
            PartObj[i][3] = participant.getCountry();
            PartObj[i][4] = participant.getBirthdate();
            PartObj[i][5] = participant.getSize();
            PartObj[i][6] = participant.getWeight();
            PartObj[i][7] = participant.getSport();
            i++;
        }

        return PartObj;
    }
}
