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
 * Questão 3: Construa uma classe para determinar se um grafo é bipartido. Para tal, use a classe PatonCycleBase.
 * 
 * */

package exercicio.pratico01;

import java.util.List;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.alg.cycle.PatonCycleBase;
import org.jgrapht.graph.SimpleGraph;

public class Questao03 {

	public static void main(String[] args) {
		
		String[] edges1 = { // Arestas do primeiro grafo de teste
	    		"ab", "ac", "bd", "cd", "de", "df", "eg", "fg"
	    };

		// Declaração do primeiro grafo de teste
		MyGraph graph1 = new MyGraph(edges1, 7);
		
		System.out.println("O grafo 1 é bipartido? " + graph1.isGraphBipartite());
		
		// Procedimentos para o segundo grafo de teste
		String[] edges2 = { // Arestas do segundo grafo de teste
	    		"ab", "ac", "bc", "bd", "be", "cd", "ce", "de", "df", "ef"
	    	};
		
		// Declaração do segundo grafo de teste
		MyGraph graph2 = new MyGraph(edges2, 6);
		
		System.out.println("O grafo 2 é bipartido? " + graph2.isGraphBipartite());
	}
	
@SuppressWarnings("serial")
public static class MyGraph extends SimpleGraph<Character, DefaultEdge> {
		
		public MyGraph(String[] edges, int nVertices) {
			super(DefaultEdge.class);
			
			// Adicionando vértices
			for (char ch = 'a'; ch <= 'a' + nVertices; ch++) {
				Character c = new Character(ch);
				this.addVertex(c);
			}
			
			// Adicionando arestas
			for (int i = 0; i < edges.length; i++) {
				Character v1 = new Character(edges[i].charAt(0));
				Character v2 = new Character(edges[i].charAt(1));
				this.addEdge(v1, v2);
			}
			
		}
		
		/*
		 * Função que determina se um grafo é bipartido.
		 * @return true, se for bipartido. false, c.c.
		 * */
		public Boolean isGraphBipartite() {
			PatonCycleBase<Character, DefaultEdge> cycle = new PatonCycleBase<>(this);
			// Se o grafo contiver um ciclo ímpar, não é bipartido.
			for (List<Character> l : cycle.findCycleBase()) {
				if(l.size() % 2 != 0) return false;
			}
			// c.c. é bipartido.
			return true;
		}

	}
	
}
