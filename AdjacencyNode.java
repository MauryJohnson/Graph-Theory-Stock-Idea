package graph;

// an AdjancenyNode represents an edge in the graph.  It is a node in 
// the adjacency list of a vertex

public class AdjacencyNode {
	double RelativeWeight;		// weight of this edge
	int vertexNum;  // index in vertices array of the vertex
	//                 at the other end of this edge
	double ComparativeWeight;	
	
	//Add more Weights as 

	AdjacencyNode next;  // next node in this adjacency list

	public AdjacencyNode(int vertexNum, AdjacencyNode next, double RelativeWeight, double ComparativeWeight) {
		this.vertexNum = vertexNum;
		this.next = next;
		this.RelativeWeight = RelativeWeight;   
		this.ComparativeWeight = ComparativeWeight; 
		//
		//MORE WEIGHTS
		//
		}

}		
