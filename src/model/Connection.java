package model;

import java.sql.DriverManager;

public class Connection {

	private static java.sql.Connection con;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "blackthorne");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private static Connection myCon = new Connection();

//	private Connection() {
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "blackthorne");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public static java.sql.Connection getCon() {
		return con;
	}
}
