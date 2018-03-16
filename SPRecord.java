package graph;

public class SPRecord {
	boolean inTree;
	double RelativeWeight;
	double ComparativeWeight;
	//ADD MORE WEIGHTS HERE!!!!!!!!!!!!!!!!!!!!!!!!!!
	//At least 5 weights should be used..
	
	
	//The Weights are to be determined using an algorithm.
	

	//
	String name;
	//Name of the Stock
	String group;
	//The Stock's group type
	
	SPRecord(boolean inTree, double RelativeWeight, double ComparativeWeight, String name, String group){
		this.inTree = inTree;
		//INTREE or ACCESSED
		this.RelativeWeight = RelativeWeight;
		this.ComparativeWeight = ComparativeWeight;
		this.name = name;
		this.group = group;
	}

	public String toString( ){
		return inTree+ " " +RelativeWeight +" "+ComparativeWeight + " " + name;
	}
	
	public static void printRecords(SPRecord [ ] spRecords, Graph g){
		for (int j = 0; j<spRecords.length; j++){
			System.out.println(j+" "+g.adjLists[j].name+ ": "+ spRecords[j]);
		}
	}
}
