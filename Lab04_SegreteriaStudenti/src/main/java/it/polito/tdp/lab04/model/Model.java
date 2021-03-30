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
	public Corso getCorso(Corso corso) {
		return corsoDAO.getCorso(corso);
	}
	public Studente getStudentiIscrittiAlCorso(Corso corso) {
		return corsoDAO.getStudentiIscrittiAlCorso(corso);
	}
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		return corsoDAO.inscriviStudenteACorso(studente, corso);
	}
}
