package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Graphe {
	private ArrayList<Sommet> sommets;
	private int[][] adjacenceMatrix;
	private int size;
	
	public Graphe(int size) {
		if(size > 1) {
			this.size = size;
			sommets = new ArrayList<Sommet>();
			adjacenceMatrix = new int[size][size];
			Scanner s = new Scanner(System.in);
			String systemin;
			for(int i = 0; i < size; i++) {
				sommets.add(new StdSommet(i));
				adjacenceMatrix[i][i] = 0;
				for(int j = 0; j < size; j++) {
					if(i != j) {
						System.out.println("poids entre le sommet x" + i + " et x" + j);
						systemin = s.nextLine();
						adjacenceMatrix[i][j] = Integer.valueOf(systemin);
					}
				}
			}
			sommets.get(0).setWeight(0);
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(i != j) {
						if(adjacenceMatrix[i][j] < 9999)
							sommets.get(i).addSuivant(sommets.get(j));
					}
				}
			}
		}
		else {
			System.out.println("Mauvaise valeur entré");
		}
		drawBoard();
	}
	
	// REQUETES
	public ArrayList<Sommet> getSommets(){
		return this.sommets;
	}
	
	public int[][] getAdjacenceMatrix(){
		return adjacenceMatrix;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void drawBoard() {
		for(int i = 0; i < this.size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(" __ ");
			}
			System.out.println();
			System.out.print("|");
			for(int j = 0; j < size; j++) {
				if(this.adjacenceMatrix[i][j] == 9999)
					System.out.print("  ");
				else
					System.out.print(" " + adjacenceMatrix[i][j]);
				
				System.out.print(" |");
			}
			System.out.println();
		}
		for(int j = 0; j < size; j++) {
			System.out.print(" __ ");
		}
		System.out.println();
	}
	
//	public void dijkstraSolver() {
//		for(int i = 0; i < size; i++) {
//			for(int j = 0; j < sommets.get(i).getSuivants().size(); j++) {
//				if(sommets.get(i).getWeight() + adjacenceMatrix[i][sommets.get(i).getSuivant(j).getIndex()] < sommets.get(i).getSuivant(j).getWeight()) {
//					System.out.println(i + "    " + j + "    : " + sommets.get(i).getWeight() + adjacenceMatrix[i][sommets.get(i).getSuivant(j).getIndex()]);
//					sommets.get(sommets.get(i).getSuivant(j).getIndex()).setWeight(sommets.get(i).getWeight() + adjacenceMatrix[i][sommets.get(i).getSuivant(j).getIndex()]);
//					sommets.get(i).getSuivant(j).setPrecedent(sommets.get(i));
//				}
//			}
//			System.out.println("fin");
//		}
//		
//		for(int i = 0; i < size; i++) {
//			System.out.println(i + " : " + sommets.get(i).getWeight());
//			if(sommets.get(i).getPrecedent() != null)
//				System.out.println("Le Précédent : " + sommets.get(i).getPrecedent());
//		}
//	}
	
}
