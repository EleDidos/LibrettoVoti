package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.util.*;

public class TestLibretto { //APPLICAZIONE
	
	public static void main (String [] args) {
		
	//PUNTO 1
	
	System.out.println("Voti del libretto:\n");
	Libretto l = new Libretto ();
	Voto v1 = new Voto ("Analisi 1", 25, LocalDate.of(2019, 2, 15));
	l.add(v1);
	l.add(new Voto("Chimica", 25, LocalDate.of(2019, 9, 15)));
	l.add(new Voto ("Fisica 1", 30, LocalDate.of(2020, 2, 15)));
	l.add(new Voto ("Info", 30, LocalDate.of(2019, 2, 13)));
	
	System.out.println("\n"+l);
	
	//PUNTO 2
	
	List <Voto> venticinque = l.listaVotiConPunteggio(25);
	System.out.println(venticinque);
	//con questo secondo metodo, ho già la stampa implementata, perché stampo direttamente un libretto
	System.out.println(l.librettoVotiUguali(25));
	
	
	//PUNTO 3
	Voto cercato = l.ricercaCorso ("Analisi 1"); //null se non esiste
	System.out.println("Il corso cercato corrisponde al seguente voto: "+cercato+"\n");
	
	//PUNTO 4-5
	Voto chimica = l.ricercaCorso("Chimica") ;
	Voto chimica_doppio = new Voto("Chimica", 25, LocalDate.of(2019, 9, 15)) ;
	Voto chimica_conflitto = new Voto("Chimica", 29, LocalDate.of(2019, 9, 15)) ;
	System.out.println(chimica + " doppione di " + chimica_doppio + "? -> "+
	l.esisteDuplicato(chimica_doppio));
	System.out.println(chimica + " doppione di " + chimica_conflitto + "? -> "+
	l.esisteDuplicato(chimica_conflitto));
	System.out.println(chimica + " conflitto di " + chimica_doppio + "? -> "+
	l.esisteConflitto(chimica_doppio));
	System.out.println(chimica + " conflitto di " + chimica_conflitto + "? -> "+
	l.esisteConflitto(chimica_conflitto));


}

}

	

