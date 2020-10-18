package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {

	
	private static Connection instance;
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLiXeMay";
	private static final String USER = "sa";
	private static final String PASSWORD ="huynhanhtien0403";
	
	
	private DatabaseConnect() {
		
	}
	
	public static void connect() throws SQLException {
		if(instance == null) {
			instance =  DriverManager.getConnection(URL, USER, PASSWORD);
		}
		
	}
	
	
	public static Connection getInstance() {
		return instance;
	}
	
	public static void disconnect() throws SQLException {
		
		if(instance != null)
			instance.close();
	}
}
