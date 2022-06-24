package model;

import java.util.ArrayList;

public abstract class Sommet {
	
	/* 
	 * 
	 * 
	 * 
	 * AJOUTER LES METHODES/ARGUMENTS DONT VOUS AUREZ BESOIN EN UNE CLASSE QUI HERITE DE CELLE CI J'AI 
	 * 
	 * INITIALISER LES ARGUMENTS <code>precedent/weight<code> COMME VOUS VOULEZ DANS LE CONSTRUCTEUR DE VOTRE NOUVELLE CLASSE
	 * 
	 * 
	 * 
	 * */
	
	//ARGUMENTS
	private int index;
	private int weight;
	private Sommet precedent;
	protected ArrayList<Sommet> suivants;
	
	// CONSTRUCTEUR
	public Sommet(int index) {
		this.index = index;
		suivants = new ArrayList<Sommet>();
		
//		precedent = null;
//		this.weight = 9999;
	}
	
	//REQUEUTES
	
	public int getIndex() {
		return this.index;
	}
	public int getWeight() {
		return this.weight;
	}
	
	public Sommet getPrecedent() {
		return this.precedent;
	}
	
	public ArrayList<Sommet> getSuivants(){
		return suivants;
	}
	
	public Sommet getSuivant(int index) {
		if(index < suivants.size()) {
			return suivants.get(index);
		}
		return null;
	}
	
	// COMMANDES
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void setPrecedent(Sommet precedent) {
		this.precedent = precedent;
	}
	
	public void addSuivant(Sommet svt) {
		if(svt != null) {
			suivants.add(svt);
		}
	}
	
	public String toString() {
		return "index : " + index;
	}
}
