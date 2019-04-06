package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	
	private AnagrammiModel model;

	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParolaInserita;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private Button btnReset;

    
    @FXML
    void doCalcola(ActionEvent event) {
    	
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    	
    	
    	//Prendo la parola e ci tolgo segni di punteggiatura e spazi
    	String parolaDaAnagrammare =  txtParolaInserita.getText().trim().toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_'~()\\[\\]\"]", "");
    	System.out.println(parolaDaAnagrammare);
    	//Salvo in anagrammi, tutti gli anagrammi creati nel model con l'algoritmo ricorsivo
    	Set<String> anagrammi=model.calcolaAnagrammi(parolaDaAnagrammare);
    	
    	//Ciclo il set di stringhe contenenti gli anagrammi
    	for(String s: anagrammi) {
    		//Il metodo isCorrect controllerà se il dizionario contiene la parola
    		//Se la contiene restituisce true e stampa la parola nel box degli anagrammi corretti
    		if(model.isCorrect(s)) {
    			txtAnagrammiCorretti.appendText(s+ "\n");}
    		//Altrimenti restituisce false e stampa la parola nel box degli anagrammi non corretti
    		else {
    			txtAnagrammiErrati.appendText(s+"\n");}
    		
    	}
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParolaInserita.clear();
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    	
    }

    @FXML
    void initialize() {
        assert txtParolaInserita != null : "fx:id=\"txtParolaInserita\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    
    public void setModel(AnagrammiModel model) {
    	this.model=model;
    	
    	
    }
}
