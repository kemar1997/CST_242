package database.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

/**
 *
 * @author Carl
 */
public class Database1
{
    /**
     * @param args the String[] args command line arguments
     */
    public static void main(String[] args)
    {
        JTextArea myOutput = new JTextArea(8, 25);
        JScrollPane myScrollPane = new JScrollPane(myOutput);

        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            String filename = "./../Books.mdb";
            String database
                    = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="
                    + filename.trim() + ";DriverID=22;READONLY=true}";

            Connection myConnection = DriverManager.getConnection(database);
            Statement sqlSelect = myConnection.createStatement();
            ResultSet myResult = sqlSelect.executeQuery(
                    "SELECT PublisherCode, Name FROM Publisher");

            myOutput.setEditable(false);

            while ( myResult.next() )
            {
                myOutput.append(myResult.getString("PublisherCode")
                        + "\t" + myResult.getString("Name") + "\n");
            }

            JOptionPane.showMessageDialog(null, myScrollPane);
            myConnection.close();
        }

        catch (SQLException ex)
        {
            System.out.println("MS Access exception");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("Driver not found");
        }
    }
    
}
