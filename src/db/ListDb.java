package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ListDb {
	String driverName = "com.mysql.jdbc.Driver"; 
	String dbURL = "jdbc:mysql://localhost:3306/studentmanage?useUnicode=true&characterEncoding=UTF-8"; 
	String userName = "root"; 
	String userPwd = "123456"; 

	public Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(dbURL, userName, userPwd);
		return conn;
	}

	public void closeCon(Connection conn) throws SQLException {
		if (conn != null)
			conn.close();
	}

	public void list() {
		ListDb ldb = new ListDb();
		try {
			ldb.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
