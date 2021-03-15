package it.polito.tdp.librettovoti;
import javafx.scene.control.TextField;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.time.LocalDate;
//import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
//import javafx.scene.control.TextInputControl;
import javafx.scene.control.DatePicker;

public class FXMLController {
	
	@FXML
	    private ResourceBundle resources;
	@FXML
	    private URL location;

    @FXML
    private TextField txtVoto;

    @FXML
    private DatePicker pickerEsame; //data esame

    @FXML
    private TextField txtEsame;

    @FXML
    private TextArea txtResult;

	private Libretto model; //creo riferimento a modello

    @FXML
    void handleInserisci(ActionEvent event) {
    	// Leggi e controlla i DATI, a seconda delle eccezioni che si possono creare
    	
    		String nomeEsame =txtEsame.getText();
    		if(nomeEsame.length()==0) {
    			txtResult.setText("ERRORE: nome esame vuoto");
    			return; //se errore --> fermo 
    		}
    		
    		String votoEsame = txtVoto.getText();
    		int votoInt=0;
    		try {
    			votoInt = Integer.parseInt(votoEsame);
    		} catch(NumberFormatException nfe) {
    			txtResult.setText("ERRORE: il voto deve essere numerico");
    			return;
    		}
    		if(votoInt<18 || votoInt>30) { //numerico, ma fuori range
    			txtResult.setText("ERRORE: il voto deve essere compreso tra 18 e 30");
    			return;	
    		}
    		
    		/*String dataEsame = txtData.getText();
    		LocalDate data = null;
    		try {
    			data = LocalDate.parse(dataEsame);
    		} catch(DateTimeParseException dtpe) {
    			txtResult.setText("ERRORE: la data non è nel formato corretto");
    			return;
    		}*/
    		
    		LocalDate data = pickerEsame.getValue(); 
    		//l'ho messo a INHEDIT nelle proprietà (così non si può scrivere qualcosa in data, ma solo selezionarne una)
    		if (data==null) {
    			txtResult.setText("ERRORE: la data è obbligatoria");
    			return;	
    		}
    		
    	// aggiungere i CONTROLLI su validità di ogni dato che sto leggendo
    	// in modo da passare dei parametri validi al modello
    	//perché se controller si acccorge che ci sono dati non validi, non prosegue
    	//controlli logici, come sapere se quell'esame è già stato dato, li fa il modello
    	//controller guarda la VALIDITA' dei dati
    		
    	//Esegui l'azione
    		Voto voto = new Voto(nomeEsame, votoInt, data); //controller può usare creazione voto del model
    		model.add(voto); //delego modello ad aggiungerlo
    		
    	//Aggiorna i risultati (nella view)
    		txtResult.setText(model.toString()); //modello sa stamparsi in stringa
    		//ripulisco i campi di inserimento
    		txtEsame.clear();
    		txtVoto.clear();
    		//txtData.clear();
    		pickerEsame.setValue(null);
    }

    
    //settaggio di modello, per avere aggiornamerto reale con il modello
    public void setModel(Libretto model) {
    	this.model=model;
    }
    
    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert pickerEsame != null : "fx:id=\"pickerEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
