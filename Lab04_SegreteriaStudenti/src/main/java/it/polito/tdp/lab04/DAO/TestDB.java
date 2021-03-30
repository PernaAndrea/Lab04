package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Corso;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		
	//	cdao.getCorso();
		for(Corso i : cdao.getTuttiICorsi()) {
			System.out.println(i.getCodins()+i.getNome());
		}
		
	}

}
