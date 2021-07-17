package Forest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class JavaDbConnect {
    private static Connection connection = null;
    public static Connection dbConnect() {
        
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/forest");
            return connection;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            return null;
        }
        }
    }

