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
    	ComboBox.getItems().add("");
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
    		 txtResult.setText("");
    		 
    		 }else {
    			 txtResult.setText("Matricola non esistente");
    		 }
    	}else {
    		txtResult.setText("Errore nell'inserimento della matricola");
    	}
    }

    @FXML
    void doCercaCorsi(ActionEvent event) {

    }

    @FXML
    void doCercaIscritti(ActionEvent event) {

    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

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
