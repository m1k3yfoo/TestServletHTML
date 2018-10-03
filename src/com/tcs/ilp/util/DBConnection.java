package com.tcs.ilp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String dbURL = "jdbc:oracle:thin:@10.101.121.236:1521:xe";
	private static String dbUserName = "batch0518";
	private static String dbPassword = "batch0518";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Connection established successfully.");
		return con;
	}
	
	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
