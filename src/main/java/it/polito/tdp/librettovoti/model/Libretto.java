package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {

	private List <Voto> voti; // qui è NULL --> non punta a nulla
	 // uso lista generica, decido poi dopo in base
	// ad efficienza se optare per LINKED LIST o per ARRAY LIST
	
	public Libretto () {
		//se devo modificare la tipologia di lista, dovrò modificare questo unico punto
		this.voti = new ArrayList <>(); // --> RIFERIMENTO a un oggetto 
										// questa volta da definire nello specifico 
										// a quale classe appartiene
	}
	
	public void add(Voto v) {
		voti.add(v);
	}
	
	public String toString() {
		//[LA LISTA QUANDO STAMPA SE STESSA ]
		String s ="";
		for(Voto vi: voti)
			s=s+vi.toString() + "\n";
		return s;
	
	}
	
}
