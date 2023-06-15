package mygraph;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    var graph = new Graph();
    var graph2 = new Graph();

 // Adiciona os vértices ao grafo
    graph.addVertex("a");
    graph.addVertex("b");
    graph.addVertex("c");
    graph.addVertex("d");
    graph.addVertex("e");
    graph.addVertex("f");
    graph.addVertex("g");
    graph.addVertex("h");
    
    graph2.addVertex("1");
    graph2.addVertex("2");
    graph2.addVertex("3");
    graph2.addVertex("4");

 // Adiciona as arestas ao grafo
    graph.addEdge("a", "b");
    graph.addEdge("a", "c");
    graph.addEdge("b", "d");
    graph.addEdge("b", "e");
    graph.addEdge("c", "f");
    graph.addEdge("e", "g");
    graph.addEdge("e", "h");

    graph2.addEdge("2", "4");
    graph2.addEdge("2", "3");
    graph2.addEdge("3", "1");
    graph2.addEdge("3", "4");
    
    System.out.println(graph);
    System.out.printf("\n");
    System.out.println(graph2);
    System.out.printf("\n");
    
    System.out.println("Vizinhos GRAFO 1 - Vértice A: " + graph.neighbours("a"));
    System.out.printf("\n");
    System.out.println("Vizinhos GRAFO 2 - Vértice 2: " + graph2.neighbours("2"));
    System.out.printf("\n");

    if (graph.direct("a", "c"))
        System.out.println("A e C estao ligados!!");
    
    if (!graph.direct("b", "d"))
        System.out.println("B e D NAO estao ligados!!");
    System.out.println("\n");
    
    if (graph2.direct("1", "3"))
        System.out.println("1 e 3 estao ligados!!");
    
    if (!graph2.direct("1", "4"))
        System.out.println("1 e 4 NAO estao ligados!!");
    System.out.printf("\n");
    
//ATVD PARCIAL
    
    //CAMINHO
    List<Vertex> caminho = graph.caminho(graph, "a", "b");
    if (caminho != null) {
        System.out.println("Caminho encontrado entre A e B: " + caminho);
    } else {
        System.out.println("Não existe caminho entre A e B no Grafo.");
    }
    System.out.printf("\n");
    
    //UNIÃO
	Graph uniao = Graph.uniao(graph, graph2);
	System.out.println("União de G1 e G2: " + uniao);
	System.out.printf("\n");
	
	//Teste Intersecção
	/*
	graph.addVertex("A");
	graph.addVertex("B");
	graph.addVertex("C");
	graph.addEdge("A", "B");
	graph.addEdge("B", "C");
	    
	graph2.addVertex("B");
	graph2.addVertex("C");
	graph2.addVertex("D");
	graph2.addEdge("B", "C");
	graph2.addEdge("C", "D");
	*/
	    
	 //INTERSECÇÃO
	 Graph interseccao = Graph.interseccao(graph, graph2);
	 System.out.println(interseccao);
 
 //FIM ATVD PARCIAL
    
// ATVD FINAL
	 
	// Após adicionar os vértices e arestas ao grafo

	 String startVertexLabel = "a";
	 String endVertexLabel = "d";

	 List<Vertex> caminhoGraph1 = graph.bfs(startVertexLabel, endVertexLabel);

	 if (caminhoGraph1 != null) {
	     StringBuilder sb = new StringBuilder();
	     sb.append("Caminho encontrado entre " + startVertexLabel + " e " + endVertexLabel + " no grafo 1: [");
	     for (int i = 0; i < caminhoGraph1.size(); i++) {
	         Vertex vertex = caminhoGraph1.get(i);
	         sb.append(vertex.getLabel());
	         if (i < caminhoGraph1.size() - 1) {
	             sb.append(", ");
	         }
	     }
	     sb.append("]");
	     System.out.println(sb.toString());
	 } else {
	     System.out.println("Não existe caminho entre " + startVertexLabel + " e " + endVertexLabel + " no grafo 1.");
	 }
	 
// FIM ATVD FINAL
	 
    System.exit(0);
  }
}
