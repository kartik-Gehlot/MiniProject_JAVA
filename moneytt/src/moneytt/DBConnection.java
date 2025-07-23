package moneytt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
   
	 static final String URL = "jdbc:mysql://localhost:3306/moneytracker"; 
     static final String USER = "root"; 
     static final String PASS = "";  

    
   
    
    public static Connection getConnection() throws SQLException {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
