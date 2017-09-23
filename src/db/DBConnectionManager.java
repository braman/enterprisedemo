package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
	
	private Connection conn;
	
	private static DBConnectionManager instance;
	
	private DBConnectionManager() {}
	
	public static DBConnectionManager getInstance() {
		if (instance == null) {
			instance = new DBConnectionManager();
		}
		
		return instance;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		if (conn == null) {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5434/kmk_hl", "postgres", "root");
		}
		
		return conn;
	}
	
}
