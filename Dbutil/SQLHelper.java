
package Dbutil;

import java.sql.*;
public class SQLHelper {
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/compliance_system";
	private static String user = "root", pwd = "root";
	private static Connection con;
    
	static {
		try {
			Class.forName(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
    
	public static void executeUpdate(String sql) {
		try {
			con = DriverManager.getConnection(url, user, pwd);
			Statement cmd = con.createStatement();
			cmd.executeUpdate(sql);
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public static ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			Statement cmd = con.createStatement();
			rs = cmd.executeQuery(sql);
		} catch (Exception ex) { 
			ex.printStackTrace();
		}
		return rs;
	}

	public static void closeConnection() {
		try {
           if(!con.isClosed())
			con.close();
		  } catch (Exception ex) {
		}
	}
	
	public static void main(String args[]) {
		try {  
	          Class.forName("com.mysql.jdbc.Driver");     //Load MYSQL JDBC dirver     
	          //Class.forName("org.gjt.mm.mysql.Driver");  
	         System.out.println("Success loading Mysql Driver!");  
	        }  
	        catch (Exception e) {  
	          System.out.print("Error loading Mysql Driver!");  
	          e.printStackTrace();  
	        }  
	        try {  
	          Connection connect = DriverManager.getConnection(  
	              "jdbc:mysql://localhost:3306/compliance_system","root","root");  
	               //connet to the url
	      
	          System.out.println("Success connect MySql server!");  
	           
	        }  
	        catch (Exception e) {  
	          System.out.print("get data error!");  
	          e.printStackTrace();  
	        }
	}

}
