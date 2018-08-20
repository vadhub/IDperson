package com.abg.connect;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
	private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "root";
    
    private static Connection conect;
    private static Statement stmt;
    private static ResultSet rs;
    
    public void connection() {
    	 try {    		 
    		 String query = "select * from books";
    		 
    		 conect = (Connection) DriverManager.getConnection(url, user, password);
             stmt = ((java.sql.Connection) conect).createStatement();
             rs = stmt.executeQuery(query);             

         } catch (SQLException sqlEx) {
             sqlEx.printStackTrace();
         } finally {
        	 try {
				((ResultSet) conect).close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}        	         	 
         }
    }
}

