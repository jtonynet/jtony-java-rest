package br.com.livro.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	public BaseDao() {
		try {
			
			//Class.forName("com.mysql.jdbc.Driver");
			
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected Connection getConnection() throws SQLException {
		/*
		String url = "jdbc:mysql://localhost/livro_java_rest";
		Connection conn = DriverManager.getConnection(url, "usr_java_rest", "123456");
		*/
		
		String url = "jdbc:postgresql://localhost/jtony_bookmarks_api";
		Connection conn = DriverManager.getConnection(url, "postgres", "postgres");
		return conn;
	}
	
	public static void main(String[] Args) throws SQLException {
		BaseDao db = new BaseDao();
		Connection conn = db.getConnection();
		System.out.println(conn);
	}
}

/*
CREATE TABLE carro (
      id serial,
      nome varchar(255) DEFAULT NULL,
      descricao varchar(255) DEFAULT NULL,
      url_foto varchar(255) DEFAULT NULL,
      url_video varchar(255) DEFAULT NULL,
      latitude varchar(255) DEFAULT NULL,
      longitude varchar(255) DEFAULT NULL,
      tipo varchar(255) DEFAULT NULL,
      PRIMARY KEY (id)
    );
 */

