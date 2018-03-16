package graph;

// represents a vertex in the graph

class Vertex {
	//VTEXES ARE PRINTED OUT in format   Vertex_Name: AdjList 1, Adjlist 2, ..... AdjList n
 	String name;  			//name of the vertex
	AdjacencyNode adjList;	// adjacency list giving neighbors of the vertex

	Vertex(String name, AdjacencyNode neighbors) {
		this.name = name;
		this.adjList = neighbors;
	}

}
