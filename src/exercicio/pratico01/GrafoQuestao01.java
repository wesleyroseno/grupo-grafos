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
 * */

package exercicio.pratico01;

import java.util.ArrayList;
import java.util.Arrays;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

/**
 * Seja G um grafo simples. Determine a matriz de incidência de G.
 * Grupo:
 * 	Bianca
 * 	Rafael Guerra de Pontes
 * 	Wesley Roseno
 * */
public class GrafoQuestao01 {

	public static void main(String[] args) {

		// Main graph instance 
		MyGraph graph = new MyGraph();
		
		// Printing output
		graph.printVertices();
		graph.printEdges();
		graph.printAdjMatrix();
		graph.printIncMatrix();
		
	}
	
	public static class MyGraph extends SimpleGraph<Character, DefaultEdge>{
		
		private String[] edges = {
	    		"ab", "ac",
	    		"bc", "bd", "be",
	    		"cd", "ce",
	    		"de", "df",
	    		"ef"
	    	};
		
		// Lista de Vértices associada a uma sequência ordenada
		private ArrayList<Character> vertexList;
		
		// Lista de Arestas associada a uma sequência ordenada
		private ArrayList<DefaultEdge> edgesList;
		
		private int[][] adjMatrix; // Matriz de adjacências
		private int[][] incMatrix; // Matriz de incidências
		
		public MyGraph() {
			super(DefaultEdge.class);
			
			vertexList = new ArrayList<>();
			edgesList = new ArrayList<>();
			
			// Adicionando vértices
			for (char ch = 'a'; ch <= 'f'; ch++) {
				Character c = new Character(ch);
				this.addVertex(c);
				vertexList.add(c);
			}
			
			// Adicionando arestas
			for (int i = 0; i < edges.length; i++) {
				Character v1 = new Character(edges[i].charAt(0));
				Character v2 = new Character(edges[i].charAt(1));
				this.addEdge(v1, v2);
				this.edgesList.add(this.getEdge(v1, v2));
			}
			
			int nVertices = this.vertexSet().size();
			adjMatrix = new int[nVertices][nVertices];
			
			for (int i = 0; i < nVertices; i++) {
				for (int j = 0; j < nVertices; j++) {
					if (this.containsEdge(vertexList.get(i), vertexList.get(j))) {
						adjMatrix[i][j] = 1;
					} else {
						adjMatrix[i][j] = 0;
					}
				}
			}
			
			int nEdges = this.edgeSet().size();
			incMatrix = new int[nEdges][nVertices];
			
			// Inicializar contadores de incidência com zero
			for (int[] linha: incMatrix)
				Arrays.fill(linha, 0);
			
			for (int i = 0; i < nEdges; i++) {
				// Incremento da origem
				Character sourceVertex = this.getEdgeSource(edgesList.get(i));
				int sourceIndex = vertexList.indexOf(sourceVertex);
				incMatrix[i][sourceIndex] += 1;
				
				// Incremento do destino
				Character targetVertex = this.getEdgeTarget(edgesList.get(i));
				int targetIndex = vertexList.indexOf(targetVertex);
				incMatrix[i][targetIndex] += 1;
			}
			
		}
		
		private void print(String s) {
			System.out.print(s);
		}
		
		public void printAdjMatrix() {
			
			int size = this.vertexSet().size();
			
			print("Matriz de Adjacências de G =\n");
			print("   ");
			for (Character c : vertexList) {
				print(c + " ");
			}
			for (int i = 0; i < size; i++) {
				print("\n" + vertexList.get(i) + ": ");
				for (int j = 0; j < size; j++) {
					print(adjMatrix[i][j] + " ");
				}
			}
			print("\n");
			
		}
		
		public void printIncMatrix() {
			print("Matriz de Incidências de G =\n");
			print("   ");
			for (Character c : vertexList) {
				print(c + " ");
			}
			for (int i = 0; i < incMatrix.length; i++) {
				print("\n" + i + ": ");
				for (int j = 0; j < vertexList.size(); j++) {
					print(incMatrix[i][j] + " ");
				}
			}
		}
		
		public void printVertices() {
			print("Vértices: " + this.vertexSet() + "\n");	
		}
		
		public void printEdges() {
			print("Arestas: " + this.edgeSet() + "\n");	
		}	
		
	}

}
