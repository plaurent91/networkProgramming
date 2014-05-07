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
public class DbLinkUsers {

    public static final String TABLE_NAME = "ROOT.USERS";
    private PreparedStatement createAccountStatement;
    private PreparedStatement findAccountStatement;
    private PreparedStatement insertStatement;
    private PreparedStatement selectStatement;
    private Statement statement;
    private Connection connection;

    public DbLinkUsers()
            throws RemoteException, ClassNotFoundException, SQLException {
        super();
        this.connection = createDatasource();
        prepareStatements(connection);
        this.statement = connection.createStatement();
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
                + TABLE_NAME + " VALUES (?, ?, ?, ?, ?)");
        selectStatement = connection.prepareStatement("SELECT * from "
                + TABLE_NAME + " WHERE NAME = ?");
    }

    public ArrayList<String[]> selectAllUsers() throws SQLException {
        ResultSet result = statement.executeQuery("SELECT * FROM " + TABLE_NAME);
        ArrayList<String[]> allUsers = new ArrayList();
        while (result.next()) {
            String[] toSend = new String[3];
            toSend[0] = result.getString("Name");
            toSend[1] = result.getString("Pass");
            toSend[2] = Boolean.toString(result.getBoolean("isAdmin"));
            allUsers.add(toSend);
            //System.out.println("Participant " + participant.toString());
        }
        return allUsers;
    }

    public void insert(String name, String pass, String job, boolean isAdmin) throws Exception {
        insertStatement.setString(1, name);
        insertStatement.setString(2, pass);
        insertStatement.setBoolean(3, true);
        insertStatement.setString(4, job);
        insertStatement.setBoolean(5, isAdmin);
        insertStatement.executeUpdate();
        System.out.println(name + " is new on the trade Market");
    }
}
