import java.util.ArrayList;

public class DiAdjacencyMatrix implements DiGraphADT{

	
	public static void main(String[] args) {
		
	}
	
    // instance variable
	private boolean matrix[][];
    private int numNodes;  // number of nodes
    private int numEdges;
    
     
	public DiAdjacencyMatrix(int n) {
		matrix = new boolean[n][n];
	     numNodes = n;
	     numEdges = 0;
	}
	
	public int nNodes() {
		return numNodes;
	}

	public int nEdges() {
		return numEdges;
	}

	public boolean addEdge(int node1, int node2) {
		if (isEdge(node1,node2)) {
			return false;
		}
		else {
			numEdges++;
	        matrix[node1][node2] = true;
	        return true;
		}
	}

	public boolean isEdge(int node1, int node2) {
		if (matrix[node1][node2] == false) {
			return false;
		}
		else {
			return true;
		}
		
	}

	public ArrayList<Integer> successors(int node) {
		   ArrayList<Integer> successorNodes = new ArrayList<Integer>();
	        for (int i=0; i<nNodes(); i++) {
	           if (matrix[node][i] == true) {
	        	  successorNodes.add(i); 
	           }
	        }
	        return successorNodes;
	}

	public ArrayList<Integer> predecessors(int node) {
	     ArrayList<Integer> predecessorNodes = new ArrayList<Integer>();
	        for (int i=0; i<nNodes(); i++)
	           if (matrix[i][node] == true)
	             predecessorNodes.add(i);
	        return predecessorNodes;
	}

	
	public int outDegree(int node) {
		  return successors(node).size();
	}

	 public int inDegree(int node) {
		 return predecessors(node).size();
	 }
}
