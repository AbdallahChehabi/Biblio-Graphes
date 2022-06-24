package solvers;

import model.Graphe;

public class DijkstraSolver implements Solver{
	
	// ARGUMENTS
	Graphe graphe;
	
	public DijkstraSolver(Graphe graphe) {
		this.graphe = graphe;
	}
	
	// REQUETES
	public Graphe getGraphe() {
		return this.graphe;
	}
	
	// COMMANDES
	public void setGraphe(Graphe graphe) {
		this.graphe = graphe;
	}
	
	public void solve() {
		for(int i = 0; i < graphe.getSize(); i++) {
			for(int j = 0; j < graphe.getSommets().get(i).getSuivants().size(); j++) {
				if(graphe.getSommets().get(i).getWeight() + graphe.getAdjacenceMatrix()[i][graphe.getSommets().get(i).getSuivant(j).getIndex()] < graphe.getSommets().get(i).getSuivant(j).getWeight()) {
//					System.out.println(i + "    " + j + "    : " + graphe.getSommets().get(i).getWeight() + "    " + graphe.getAdjacenceMatrix()[i][graphe.getSommets().get(i).getSuivant(j).getIndex()]);
					graphe.getSommets().get(graphe.getSommets().get(i).getSuivant(j).getIndex()).setWeight(graphe.getSommets().get(i).getWeight() + graphe.getAdjacenceMatrix()[i][graphe.getSommets().get(i).getSuivant(j).getIndex()]);
					graphe.getSommets().get(i).getSuivant(j).setPrecedent(graphe.getSommets().get(i));
				}
			}
		}
	}
	
	public void printResult() {
		for(int i = 0; i < graphe.getSize(); i++) {
			System.out.println(i + " : " + graphe.getSommets().get(i).getWeight());
			if(graphe.getSommets().get(i).getPrecedent() != null)
				System.out.println("Le Précédent : " + graphe.getSommets().get(i).getPrecedent());
		}
	}
}
