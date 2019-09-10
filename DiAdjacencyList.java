 import java.util.ArrayList;
import java.util.*;

public class DiAdjacencyList implements DiGraphADT{

	private LinkedList<Integer> list[];
	private int numNodes;
	private int numEdges;
	
	public DiAdjacencyList(int n) {
		numNodes = n;
		numEdges = 0;
		list = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new LinkedList<>();
		}
	}
	
	public int nNodes() {
		return numNodes;
	}

	
	public int nEdges() {
		return numEdges;
	}

	
	public boolean addEdge(int node1, int node2) {
		if (isEdge(node1, node2)) {
			return false;
		}
		else {
			list[node1].add(node2);
			numEdges++;
			return true;
		}
	}

	
	public boolean isEdge(int node1, int node2) {
		return list[node1].contains(node2);
	}

	
	public ArrayList<Integer> successors(int node) {
		ArrayList<Integer> successorNodes = new ArrayList<Integer>();
		for (int i = 0; i < list[node].size(); i++) {
			successorNodes.add(list[node].get(i));
		}
		return successorNodes;
	}

	
	public ArrayList<Integer> predecessors(int node) {
		 ArrayList<Integer> predecessorNodes = new ArrayList<Integer>();
		 for (int i = 0; i < list.length; i++) {
			 for (int j = 0; j < list[i].size(); j++) {
				 if (list[i].get(j).equals(node)) {
					 predecessorNodes.add(i);
				 }
			 }
		 }
	     return predecessorNodes;
	}

	
	public int outDegree(int node) {
		return successors(node).size();
	}
	
	 public int inDegree(int node){
        return predecessors(node).size();
	}

}
