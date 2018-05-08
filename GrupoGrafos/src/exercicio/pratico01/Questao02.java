/**
 * Disciplina: Teoria dos Grafos
 * 
 * Exercício Prático 01
 * 
 * Grupo:
 * 	Bianca Rangel
 * 	Rafael Guerra de Pontes
 * 	Victor
 * 	Wesley Roseno
 * 
 * Questão 02: Seja G um grafo não-direcionado ponderado. Determine o caminho mais curto entre dois vértices. 
 * 
 * */

package exercicio.pratico01;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;


public class Questao02 {

	public static void main(String[] args) {

		// Declaração de um grafo simples ponderado.
		SimpleWeightedGraph<String,DefaultWeightedEdge> g = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		// Adicionando vértices
		for (char ch = 'A'; ch <= 'I'; ch++) {
			String c = new String("" + ch);
			g.addVertex(c);

		}
	    
		// Adicionando arestas ponderadas
		g.setEdgeWeight(g.addEdge("A","B"), 2);
	    g.setEdgeWeight(g.addEdge("A","G"), 3);
	    g.setEdgeWeight(g.addEdge("A","F"), 7);
	    g.setEdgeWeight(g.addEdge("B","G"), 6);
	    g.setEdgeWeight(g.addEdge("B","C"), 4);
	    g.setEdgeWeight(g.addEdge("C","D"), 2);
	    g.setEdgeWeight(g.addEdge("C","H"), 2);
	    g.setEdgeWeight(g.addEdge("D","E"), 1);
	    g.setEdgeWeight(g.addEdge("D","H"), 8);
	    g.setEdgeWeight(g.addEdge("E","I"), 2);
	    g.setEdgeWeight(g.addEdge("E","F"), 6);
	    g.setEdgeWeight(g.addEdge("F","I"), 5);
	    g.setEdgeWeight(g.addEdge("I","G"), 1);
	    g.setEdgeWeight(g.addEdge("I","H"), 4);
	    g.setEdgeWeight(g.addEdge("G","H"), 3);
	    
	    
	    DijkstraShortestPath <String,DefaultWeightedEdge>  p = 
	    		new DijkstraShortestPath <> (g);
 
	 
	    
		// Calculando e exibindo todos os melhores caminhos possíveis por vértice
		for (String source : g.vertexSet()) {
			System.out.println("Todos os melhores caminhos partindo de " + source);
			for (String destination : g.vertexSet()) {
				if(!source.equals(destination)) {
					System.out.println("De " + source + " a " + destination + ": " +
							p.getPath(source, destination) + " com peso " + 
							p.getPathWeight(source, destination));
				}
			}
			System.out.println("");
		}
	}
	
}
