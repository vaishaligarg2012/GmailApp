package com.Cmail.ConnectionConfig;

import java.sql.*;

public class DBConfig {
   public static Connection getConnection() throws Exception {
	   Class.forName("org.h2.Driver");
	   Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/CMail","sa","");
	   return con;
   }
}
