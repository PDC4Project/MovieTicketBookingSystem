package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author zk
 */
public class DB {

    private String protocol = "jdbc:derby:";
    private Connection conn;

    public DB() {
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        try {
            String dbName = "TicketDB"; // the name of the database
            this.conn = DriverManager.getConnection(protocol + dbName
                    + ";create=false");
            Class.forName(driver);    
        } catch (SQLException | ClassNotFoundException ex) {
        }
    }
    public Connection getConnection() {
        return conn;
    }
}
