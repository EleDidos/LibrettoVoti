package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;

public class TestLibretto { //APPLICAZIONE
	
	public static void main (String [] args) {
	
	System.out.println("Voti del libretto:\n");
	Libretto l = new Libretto ();
	Voto v1 = new Voto ("Analisi 1", 25, LocalDate.of(2019, 2, 15));
	l.add(v1);
	l.add(new Voto ("Fisica 1", 30, LocalDate.of(2020, 2, 15)));
	l.add(new Voto ("Info", 30, LocalDate.of(2019, 2, 13)));
	
	System.out.println(l);
	}
}
