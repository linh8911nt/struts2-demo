/**
 * 
 */
package com.fa.linhnt49.struts2.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author nguyenthanhlinh
 *
 */
public class DbConnect {

	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException 
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
		Properties properties = new Properties();
		properties.load(DbConnect.class.getResourceAsStream("/dbconnect.properties"));
		String driver = properties.getProperty("db.driver");
		String url = properties.getProperty("db.url");
		String user = properties.getProperty("db.user");
		String password = properties.getProperty("db.password");
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}
}
