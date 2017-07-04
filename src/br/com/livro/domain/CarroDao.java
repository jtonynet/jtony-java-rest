package br.com.livro.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CarroDao extends BaseDao {
	
	public Carro getCarroById(Long id) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		Carro c = null;
		
		try {			
			conn = getConnection();
			stmt = conn.prepareStatement("select * from carro where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				c = createCarro(rs);
				rs.close();
			}
		} finally {
			if(stmt != null) {
				stmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		}
		
		return c;
	}

	public List<Carro> findByName(String name) {
		List carros = null;
		
		return carros;
	}
	
	private Carro createCarro(ResultSet rs) {
		return null;
	}

}
