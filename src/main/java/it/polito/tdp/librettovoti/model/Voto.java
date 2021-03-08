package it.polito.tdp.librettovoti.model;

import java.time.*;

// Una classe con all'interno solo un costruttore e metodi get e set per tutti i campi
// Non ha logica
// POJO - Plain Old Java Object
// Java Beans

/**
 *  Scrivo la SPIEGAZIONE che apparirà anche 
 *  solo passando il cursore sulla classe
 * @author elena
 * 
 * @param nome del corso ottenuto
 * @param voto ottenuto
 * @param data superamento
 *
 */

public class Voto {
	
	private String nome;
	private int voto; //30 lode come lo rappresento?
	private LocalDate data;
	
	public Voto(String nome, int voto, LocalDate data) {
		this.nome = nome;
		this.voto = voto;
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Esame " +"nome "+ " superato con "+ voto +" in data " + data;
	}
	
	
	
	

}
