/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */
package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    private Model model = new Model();

    @FXML
    private ComboBox<String> ComboBox;
    
    public void setModel(Model model) {
    	this.model=model;
    	for(Corso cc: model.getTuttiICorsi()) {
    		ComboBox.getItems().add(cc.toString());
    	}
    	ComboBox.getItems().add(" ");
    }

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextArea txtResult;

    @FXML
    void buttonStudent(ActionEvent event) {

    	txtNome.setText("");
		txtCognome.setText("");
    	Studente a = new Studente();
    	
    	if(txtMatricola.getText()!=null && txtMatricola.getText().length()==6) {
    		
    		 a = model.getDatiStudente(txtMatricola.getText());
    		 if(a!=null) {
    		 
    		 txtNome.setText(a.getNome());
    		 txtCognome.setText(a.getCognome());
    		// txtResult.setText("");
    		 
    		 }else {
    			 txtResult.setText("Matricola non esistente");
    		 }
    	}else {
    		txtResult.setText("Errore nell'inserimento della matricola");
    	}
    }

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	txtResult.clear();
    	txtResult.setStyle("-fx-font-family: monospace");
    	if(txtMatricola.getText()!=null && (ComboBox.getValue()==null || ComboBox.getValue()==" ")) {
    	ArrayList<Corso> c = new ArrayList<Corso>(model.getTuttiICorsi());
    	if(txtMatricola.getText()!=null) {
    		c = (ArrayList<Corso>) model.CorsiStudente(txtMatricola.getText());
    		StringBuilder sb = new StringBuilder();
        	for(Corso cc : c) {
        		sb.append(String.format("%-8s ",cc.getCodins()));//il percentuale lo fa sostituire
        		sb.append(String.format("%-4d ",cc.getNumeroCrediti()));// il meno lo allinea a sx
        		sb.append(String.format("%-50s ",cc.getNome()));//il numero indica quanto larga fare la colonna
        		sb.append(String.format("%-4d \n",cc.getPeriodoDidattico())); //la lettera 'd' e 's' stanno a significare il tipo String o int
        	}
        	txtResult.appendText(sb.toString());
    	}else {
    		txtResult.setText("Errore nell' inserimento della matricola");
    		}
    	}else {
    		ArrayList<Corso> c = new ArrayList<Corso>(model.getTuttiICorsi());
    		for(Corso cc:c) {
    			if(cc.getNome().equals(ComboBox.getValue())) {
    					if(model.studenteIscritto(txtMatricola.getText(),cc.getCodins())) {
    							txtResult.setText("Studente già iscritto per il corso selezionato ");
    				}else {
    					txtResult.setText("Studente non iscritto per il corso selezionato ");
    				}
    			}
    		}
    	}
    }

    @FXML
    void doCercaIscritti(ActionEvent event) {

    	txtResult.setStyle("-fx-font-family: monospace");
    	
    	ArrayList<Corso> c = new ArrayList<Corso>(model.getTuttiICorsi());
    	ArrayList<Studente> iscrittiAlCorso  = new ArrayList<Studente>();
    	txtResult.clear();
    	if(ComboBox.getValue().compareTo(" ")!=0) {
    		for(Corso cc:c) {
    			if(cc.getNome().equals(ComboBox.getValue())) {
    				iscrittiAlCorso = (ArrayList<Studente>) model.getStudentiIscrittiCorso(cc.getCodins());
    			}
    		}
    		//setto correttamente il valore della text area
        	StringBuilder sb = new StringBuilder();
        	for(Studente ccc : iscrittiAlCorso) {
        		sb.append(String.format("%-6s ",ccc.getMatricola()));//il percentuale lo fa sostituire
        		sb.append(String.format("%-10s ",ccc.getCognome()));// il meno lo allinea a sx
        		sb.append(String.format("%-10s ",ccc.getNome()));//il numero indica quanto larga fare la colonna
        		sb.append(String.format("%-6s \n",ccc.getCds())); //la lettera 'd' e 's' stanno a significare il tipo String o int
        	}
        	txtResult.appendText(sb.toString());
  
    	}else {
    		txtResult.setText("Nessun corso selezionato");
    	}
    	
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	txtResult.clear();
    }

    @FXML
    void initialize() {
        assert ComboBox != null : "fx:id=\"ComboBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
