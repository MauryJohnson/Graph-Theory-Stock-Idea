package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//  represents a weighted undirected graph

public class Graph {
	Vertex[ ] adjLists;   // array of all vertices in the graph

	//CREATE THE GRAPH GIVEN THE GRAPH.TXT@@@@@@@@@@@@@@@@@@@@@@@@@
	public Graph(String file) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(file));

		// read number of vertices
		adjLists = new Vertex[sc.nextInt()];

		// read vertex names & create vertices
		for (int v=0; v < adjLists.length; v++) {
			adjLists[v] = new Vertex(sc.next(), null);
		}

		// read edges
		while (sc.hasNext()) {
			// read vertex names and translate to vertex numbers
			int v1 = indexForName(sc.next());
			int v2 = indexForName(sc.next());
			int weight1 = sc.nextInt( );
			//NEXT INT
			int weight2 = sc.nextInt( );
			//...............
			//ADD MORE WEIGHTS HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1

			// add v2 to front of v1's adjacency list and
			// add v1 to front of v2's adjacencylist
			
			adjLists[v1].adjList = new AdjacencyNode(v2, adjLists[v1].adjList, weight1, weight2);
			adjLists[v2].adjList = new AdjacencyNode(v1, adjLists[v2].adjList, weight1 +0.0 , weight2 + 0.0);
		}
		sc.close( );
	}
	
	int indexForName(String name) {
		for (int v=0; v < adjLists.length; v++) {
			if (adjLists[v].name.equals(name)) {
				return v;
			}
		}
		return -1;
	}	
	
	
	public int numberOfVertices( ){
		return adjLists.length;
	}

	// print a summary of the graph
	public SPRecord[][] summarize( ){
		SPRecord [][]Matrix = new SPRecord[numberOfVertices()][numberOfVertices()];
		
		int i=0;
		
		System.out.print("Summary: \n\n");
		
		for(int j = 0; j<numberOfVertices( ); j++){
			Vertex vj = adjLists[j];
			
			//Matrix[0][j]=new SPRecord(false,0,0,vj.name);
			
			System.out.print(vj.name+": ");
			for(AdjacencyNode e = vj.adjList; e != null; e = e.next){
				System.out.print(adjLists[e.vertexNum].name+" "+e.RelativeWeight+"," + e.ComparativeWeight + ", ");
				i=e.vertexNum;
				if(i!=j){
					//System.out.print("MADE IT 1");
				Matrix[i][j]=new SPRecord(false,e.vertexNum,e.RelativeWeight,adjLists[e.vertexNum].name, "");
				Matrix[i][j].name=adjLists[e.vertexNum].name;
				Matrix[i][j].RelativeWeight=e.RelativeWeight;
				Matrix[i][j].ComparativeWeight=e.ComparativeWeight;
				//
				//WEIGHTS MAY BE ADDED OR DELETED.... SEE COMMENT (2) IN MAIN METHOD BELOW 
				//
				}
				else{
					//System.out.print("MADE IT 2");
					Matrix[i][j]=new SPRecord(false,0,0,adjLists[e.vertexNum].name, "");
				}
			}
			System.out.println();
		}
		
		
		
		System.out.print("\nEND OF SUMMARY\n");
		
		return Matrix;
	}
	
	
	public int shortestPath(String nameFrom, String nameTo){
			
			//
		
				return 0;
		
	}
	
	public void PrintMatrix(SPRecord [] [] Matrix){
		
		int i=0;
		
		System.out.print("\n");
		
		for(int j = 0; j<4; j++){
			
			Vertex vj = adjLists[j];
		
			System.out.print(vj.name+": \n");
			for(AdjacencyNode e = vj.adjList; e != null; e = e.next){
				
				i=e.vertexNum;
				
				System.out.print(Matrix[i][j].toString() + "\n");
				//CAN BE ADJUSTED FOR EXTRA WEIGHTS/PARAMETERS
				
			}
			System.out.println();
		}
		
		
		
		
		
		
		return;
	}
	
	public static void main(String[] args) throws FileNotFoundException {		
		Graph g =  new Graph("graph.txt");
		/* (1)
		 When creating a graph, will need to first list all of the types of stocks and then list all of the stocks, followed by the type of stock and the stock it is
		 linked to along with the weight(s) associated with it.
		
		*/
		SPRecord [][] Matrix = new SPRecord[g.numberOfVertices()][g.numberOfVertices()];
		
		Matrix = g.summarize();
		
		g.PrintMatrix(Matrix);
		
		// (2) Completed:Prototype for creating the group stocks
		//			Customize the amount of weights by visiting the SPRecord and AdjacencyNode and the Scanner (at top of this package) and THE TOSTRING located in SPRecord.java, then 
		//			the print Matrix and summarize function in [graph] to input/ output the data added / removed....
		
		//			Matrix contains all data that portrays connected Vertices.
		//			
		
		
		// (3) NEEDS:Algorithm to get Data on Stocks  
		//		 Algorithm to Create the Weights
		//       Possible user interface
		//
		
		
	}
}