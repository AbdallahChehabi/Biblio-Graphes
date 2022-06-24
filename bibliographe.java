import model.Graphe;
import solvers.DijkstraSolver;

public class bibliographe {

	public static void main(String[] args) {
		Thread a = new Thread(new Runnable() {

			@Override
			public void run() {
				Graphe g = new Graphe(3);
				DijkstraSolver dijkstraSolver = new DijkstraSolver(g);
				System.out.println("dijkstraSolver debut");
				dijkstraSolver.solve();
				dijkstraSolver.printResult();
				System.out.println("dijkstraSolver fin");
				//g.dijkstraSolver();
			}
			
		});
		a.start();
		System.out.println("Goodbye");
	}

}
