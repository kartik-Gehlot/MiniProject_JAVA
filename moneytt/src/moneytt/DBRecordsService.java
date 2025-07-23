package moneytt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBRecordsService {
	
	

   
 
	
	
	
	
	public static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", 
            "September", "October", "November", "December"};
public static final String[] ABBRMONTHS = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	
    private static final String createRecordQuery = String.format("INSERT INTO %s(%s,%s,%s,%s,%s,%s) VALUES(?,?,?,?,?,?);", 
            Record.TABLE_NAME, Record.COLUMN_USERID, Record.COLUMN_CATEGORY, 
            Record.COLUMN_DATE, Record.COLUMN_AMOUNT, Record.COLUMN_TYPE, Record.COLUMN_DETAIL);

    private static final String searchRecordQuery1 = String.format("SELECT * FROM %s WHERE %s=?;", 
            Record.TABLE_NAME, Record.COLUMN_USERID);

    private static final String searchRecordQuery2 = String.format("SELECT * FROM %s WHERE %s=? AND MONTH(%s)=? AND YEAR(%s)=?;", 
            Record.TABLE_NAME, Record.COLUMN_USERID, Record.COLUMN_DATE, Record.COLUMN_DATE);

    private static final String searchRecordQuery3 = String.format("SELECT * FROM %s WHERE %s=? AND MONTH(%s)=? AND YEAR(%s)=? AND %s=?;", 
            Record.TABLE_NAME, Record.COLUMN_USERID, Record.COLUMN_DATE, Record.COLUMN_DATE, Record.COLUMN_TYPE);
            
    private static final String updateRecordQuery = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=? AND %s=?;",
            Record.TABLE_NAME, Record.COLUMN_CATEGORY, Record.COLUMN_DATE, Record.COLUMN_AMOUNT, 
            Record.COLUMN_TYPE, Record.COLUMN_DETAIL, Record.COLUMN_USERID, Record.COLUMN_RECORDID);

    private static final String deleteRecordQuery = String.format("DELETE FROM %s WHERE %s=? AND %s=?;", 
            Record.TABLE_NAME, Record.COLUMN_USERID, Record.COLUMN_RECORDID);

    private static final String sumRecordAmountQuery1 = String.format("SELECT SUM(%s) FROM %s WHERE %s=? AND MONTH(%s)=? AND YEAR(%s)=? AND %s=?;", 
            Record.COLUMN_AMOUNT, Record.TABLE_NAME, Record.COLUMN_USERID, 
            Record.COLUMN_DATE, Record.COLUMN_DATE, Record.COLUMN_TYPE);

    private static final String sumRecordAmountQuery2 = String.format("SELECT SUM(%s) FROM %s WHERE %s=? AND MONTH(%s)=? AND YEAR(%s)=? AND %s=? AND %s=?;", 
            Record.COLUMN_AMOUNT, Record.TABLE_NAME, Record.COLUMN_USERID, 
            Record.COLUMN_DATE, Record.COLUMN_DATE, Record.COLUMN_TYPE, Record.COLUMN_CATEGORY);

   
    public static int createRecord(Record record) {
    	try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(createRecordQuery);
            ps.setInt(1, record.getUserID());
            ps.setString(2, record.getCategory());
            ps.setString(3, record.getDate());
            ps.setInt(4, record.getAmount());
            ps.setString(5, record.getType());
            ps.setString(6, record.getDetail());
            int updatedRowCount = ps.executeUpdate();
            return updatedRowCount; 
        } catch(SQLException se) {
            se.printStackTrace();
            return -1;
        
        }
    }


    
    public static ResultSet searchRecords(int userID) {	
    	try {
            Connection connection = DBConnection.getConnection();
	        PreparedStatement ps = connection.prepareStatement(searchRecordQuery1);
            ps.setInt(1, userID);
		    ResultSet rs = ps.executeQuery();
		    return rs;
		} catch(Exception e) {
		    e.printStackTrace();
		}
    	return null;
    }

 
    public static ResultSet searchRecords(int userID, int selectMonth, int selectYear) {
    	try {
            Connection connection = DBConnection.getConnection();
	        PreparedStatement ps = connection.prepareStatement(searchRecordQuery2);
            ps.setInt(1, userID);
            ps.setInt(2, selectMonth);
            ps.setInt(3, selectYear);
            ResultSet rs = ps.executeQuery();
	        return rs;
        } catch(Exception e) {
            e.printStackTrace();
        }
    	return null;
    }

   
    public static ResultSet searchRecords(int userID, int selectMonth, int selectYear, String selectType) {
    	try {
            Connection connection = DBConnection.getConnection();
	        PreparedStatement ps = connection.prepareStatement(searchRecordQuery3);
            ps.setInt(1, userID);
            ps.setInt(2, selectMonth);
            ps.setInt(3, selectYear);
            ps.setString(4, selectType);
            ResultSet rs = ps.executeQuery();
		    return rs;
		} catch(Exception e) {
		    e.printStackTrace();
		}
    	return null;
    }

   
    public static int updateRecords(Record record) {
    	try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(updateRecordQuery);
            ps.setString(1, record.getCategory());
            ps.setString(2, record.getDate());
            ps.setInt(3, record.getAmount());
            ps.setString(4, record.getType());
            ps.setString(5, record.getDetail());
            ps.setInt(6, record.getUserID());
            ps.setInt(7, record.getRecordID());
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

   
    public static int deleteRecords(int userID, int recordID) {
    	try {	
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(deleteRecordQuery);
	        ps.setInt(1, userID);
	        ps.setInt(2, recordID);	
	        int updatedRowCount = ps.executeUpdate();
	        return updatedRowCount;     
		}catch(SQLException se){
	        se.printStackTrace();
	        return -1;
	    }catch (Exception e) {
		    e.printStackTrace();
		    return -2;
		}  	
    }



   
    public static Object searchStatictic(int userID, int selectMonth, int selectYear, String selectType) {
    	try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sumRecordAmountQuery1);
            ps.setInt(1, userID);
            ps.setInt(2, selectMonth);
            ps.setInt(3, selectYear);
            ps.setString(4, selectType);
            ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Object sum = rs.getObject(1);
		    	if(sum != null) {
		    		return sum;
		    	} else {
		    		return 0;
		    	}	
			}
		} catch(Exception e) {
		    e.printStackTrace();
		}
    	return 0;
    }



    public static Object searchStatictic(int userID, int selectMonth, int selectYear, String selectType, String selectCategory) {
    	try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sumRecordAmountQuery2);
            ps.setInt(1, userID);
            ps.setInt(2, selectMonth);
            ps.setInt(3, selectYear);
            ps.setString(4, selectType);
            ps.setString(5, selectCategory);
            ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Object sum = rs.getObject(1);
		    	if(sum != null) {
		    		return sum;
		    	} else {
		    		return 0;
		    	}	
			}
		} catch(Exception e) {
		    e.printStackTrace();
		}
    	return 0;
    }




}
