package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DizionarioDAO {

	//Il metodo isCorrect funziona bene
	public boolean isCorrect(String anagramma) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM parola WHERE nome = ?";
		
		boolean corretto=false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, anagramma);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				corretto=true;
			}
			
			conn.close();
			
		} catch(SQLException e) {
			throw new RuntimeException("Errore Db");
		}
		
		
		
		
		return corretto;
	}
	
	
	

}
