package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public Studente getDatiStudente(String matr) {

		final String sql = "SELECT * "
				+ "FROM studente s "
				+ "WHERE s.matricola= ?";


		Studente s = null ;
	//	String tot = "   ";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, matr);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

			try {
				s = new Studente();
				String matricola = rs.getString("matricola");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String cds = rs.getString("CDS");
			//	tot = nome +" "+cognome;
				s.setMatricola(matricola);
				s.setCds(cds);
				s.setCognome(cognome);
				s.setNome(nome);
				
			}catch(SQLException e) {
				return null;
			}

			//	System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
			}

			conn.close();
			
			return s;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db ", e);
		}
	}
	
public static boolean inscriviStudenteACorso(String matricola, String cod) {
		
		String sql1="SELECT * "+
				"FROM iscrizione "+
				"WHERE matricola=? AND codins=?";
		
		String sql2="INSERT INTO iscrizione "
				+ "VALUES(?,?)";
		try {
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql1);
			
			st.setString(1, matricola);
			st.setString(2, cod);
			
			ResultSet rs=st.executeQuery();
			
			if(rs.next()) {
				rs.close();
				st.close();
				conn.close();
				return false;
			}
			rs.close();
			
			st=conn.prepareStatement(sql2);
			st.setString(1, matricola);
			st.setString(2, cod);
			st.executeUpdate();
			
			st.close();
			conn.close();
			
			return true;
		}catch(SQLException sqle) {
			throw new RuntimeException("Errore DB",sqle);
		}
	}
	
}
