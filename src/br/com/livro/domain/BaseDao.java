package br.com.livro.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	public BaseDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost/livro_java_rest";
		Connection conn = DriverManager.getConnection(url, "usr_java_rest", "123456");
		return conn;
	}
	
	public static void main(String[] Args) throws SQLException {
		BaseDao db = new BaseDao();
		Connection conn = db.getConnection();
		System.out.println(conn);
	}
}
