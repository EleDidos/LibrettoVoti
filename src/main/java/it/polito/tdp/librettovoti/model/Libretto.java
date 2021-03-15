/**
 *  SONO TUTTE CLASSI che fanno parte del MODELLo, perché
 *  gestiscono logica del progetto
 *  
 *  LIBRETTO = CLASSE CHE USERO' COME MODELLO
 *  può essere chiamato sia da controller che dalla classe Test Libretto
 */

package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {

	private List <Voto> voti; // qui è NULL --> non punta a nulla
	 // uso lista generica, decido poi dopo in base
	// ad efficienza se optare per LINKED LIST o per ARRAY LIST
	
	//--> se io avessi molti voti, sarebbe meglio costruire in parallerlo una mappa
	//miglioro EFFICIENZA
	private Map <String,Voto> votiMap; //identity Map
	
	public Libretto () {
		//se devo modificare la tipologia di lista, dovrò modificare questo unico punto
		this.voti = new ArrayList <>(); 
		this.votiMap = new HashMap<>();
		
		System.out.println("Sono Libretto: sono stato creato :)");
	}
	
	public void add(Voto v) { //inserisce in due punti diversi
		voti.add(v); //in ordine di inserimento
		votiMap.put(v.getNome(),v);//facilemnte accessibili dal nome
		
	}
	
	//IL LIBRETTO SA STAMPARSI
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
		//con MAP
		if(votiMap.get(nomeCorso)!=null)
			return votiMap.get(nomeCorso);
		else
			return null;
		
		//con LIST
		/*Voto risultato = null;
		for(Voto vi: voti) 
			if(vi.getNome().equals(nomeCorso))
				risultato=vi;
		
		return risultato;*/
	}
	
	
	//PUNTO 4 
	/**
	 * Verifica se nel libretto c'è già un voto con stesso nome
	 * e stessa valutazione
	 * In caso affermativo sarà un DUPLICATO
	 * @param v
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
		
		//ricerca su una MAP molto più efficiente
		Voto trovato = votiMap.get(v.getNome());
		if(trovato==null)
			return false;
		else {
			if(votiMap.get(trovato.getNome()).getVoto()==v.getVoto())
				return true;
			else
				return false;
		}
		
		
		/*for(Voto vi: voti) con LISTA
			if(vi.getNome().equals(v.getNome()) && vi.getVoto()==v.getVoto()) {
				trovato=true;
				break;
			}
		return trovato;*/
	}
	
	
	//PUNTO 5
	/**
	 * Verifica se nel libretto c'è già un voto con stesso esame
	 * ma valutazione diversa 
	 * In caso affermativo è un CONFLITTO
	 * @param v
	 * @return
	 */
	
	public boolean esisteConflitto(Voto v) {
	//ricerca su una MAP molto più efficiente
			Voto trovato =votiMap.get(v.getNome());
			if(trovato==null)
				return false;
			else {
				if(votiMap.get(trovato.getNome()).getVoto()==v.getVoto())
					return false;
				else
					return true;
			}
	/*
		boolean trovato = false;
		for(Voto vi: voti)
			if(vi.getNome().equals(v.getNome()) && vi.getVoto()!=v.getVoto()) {
				trovato=true;
				break;
			}
		return trovato;*/
		
	}
}
