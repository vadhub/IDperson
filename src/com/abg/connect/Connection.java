package com.abg.connect;

import java.sql.ResultSet;
import java.sql.Statement;

public class Connection {
	private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "root";
    
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    
    
}
