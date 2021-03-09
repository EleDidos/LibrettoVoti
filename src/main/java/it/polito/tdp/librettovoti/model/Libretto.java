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
	
	//PUNTO 2
	
	//meglio creare una lista che potrei riusare ma...
	//dovrò modificare tutte le classi in cui uso un certo tipo di list
	public List <Voto> listaVotiConPunteggio(int p) {
		List <Voto> ok = new LinkedList <Voto>();
		for(Voto vi: voti)
			if(vi.getVoto()==p)
				ok.add(vi);
		return ok;
		//lo stesso oggetto "vi" è contenuto in due liste diverse
		//sto usando un oggetto che già esisteva 
	}
	
	public Libretto librettoVotiUguali(int punteggio) {
		//potrei creare un libretto direttamente che ha già tutti i metodi
		//e non mostro nulla all'esterno 
		Libretto nuovo = new Libretto();
		for(Voto vi: voti)
			if(vi.getVoto()==punteggio)
				nuovo.add(vi); //libretto ha un suo metodo add
		return nuovo;
	}
	
	//PUNTO 3
	/**
	 * Ricerca un voto con il nome corrispondente a quello passato,
	 * restituisce null se non c'è niente di coincidente
	 * @param nomeCorso
	 * @return
	 */
	
	public Voto ricercaCorso(String nomeCorso) {
		Voto risultato = null;
		for(Voto vi: voti) 
			if(vi.getNome().equals(nomeCorso))
				risultato=vi;
		
		return risultato;
	}
	
}
