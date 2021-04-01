package it.polito.tdp.lab04.model;

import java.util.List;


import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private CorsoDAO corsoDAO;
	private StudenteDAO studenteDAO;
	
	//private List<Corso> corsi;
	//private List<Studente> studenti;

	public Model() {
		super();
		corsoDAO = new CorsoDAO();
		studenteDAO = new StudenteDAO();
	}
	
	public List<Corso> getTuttiICorsi(){
		return corsoDAO.getTuttiICorsi();
	}
	public List<Studente> getStudentiIscrittiCorso(String cod) {
		return corsoDAO.getStudentiIscrittiCorso(cod);
	}
	
	public boolean inscriviStudenteACorso(String studente, String cod) {
		return StudenteDAO.inscriviStudenteACorso(studente, cod);
	}
	public Studente getDatiStudente(String matr) {
		return studenteDAO.getDatiStudente(matr);
	}
	public List<Corso> CorsiStudente(String matr){
		return corsoDAO.CorsiStudente(matr);
	}
	public boolean studenteIscritto(String matri,String codinss) {
		return corsoDAO.studenteIscritto(matri, codinss);
	}
}
