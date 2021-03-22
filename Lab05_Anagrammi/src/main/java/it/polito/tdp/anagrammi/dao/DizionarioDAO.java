package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class DizionarioDAO {

	public void caricaDizionario(Set<String> dizionario) {
		
		String sql = "SELECT nome FROM parola";
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				dizionario.add(rs.getString("nome"));
			}
			
			conn.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	

}
