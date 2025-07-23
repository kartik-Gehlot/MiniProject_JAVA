package moneytt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBUserService {
    
    private static final String userLoginQuery = String.format("SELECT * FROM %s WHERE %s=? AND %s=?;", 
            User.TABLE_NAME, User.COLUMN_NAME, User.COLUMN_PASSWORD);

    
  
    public static User validateUserLogin(String commitUsername, String commitPassword) {
        User user = null;
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(userLoginQuery);
            ps.setString(1, commitUsername);
            ps.setString(2, commitPassword);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user = new User(
                    rs.getInt(User.COLUMN_USERID),
                    rs.getString(User.COLUMN_NAME),
                    rs.getString(User.COLUMN_EMAIL),
                    rs.getString(User.COLUMN_PHONE),
                    rs.getString(User.COLUMN_PASSWORD)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    private static final String userRegisterQuery = String.format("INSERT INTO %s(%s,%s,%s,%s) VALUES(?,?,?,?);", 
    		User.TABLE_NAME, User.COLUMN_NAME, User.COLUMN_EMAIL, User.COLUMN_PHONE, User.COLUMN_PASSWORD);
   
    public static int createUser(User user) {
    	try {
            Connection connection = DBConnection.getConnection();	
            PreparedStatement ps = connection.prepareStatement(userRegisterQuery);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getPassword());
            int updatedRowCount = ps.executeUpdate();
	        return updatedRowCount;
		} catch(SQLException se) {
	        se.printStackTrace();
	        return -1;
	    } catch(Exception e) {
            e.printStackTrace();
            return -2;
        }
    }
}
