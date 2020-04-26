import java.util.*;
//Implementation of a basic java graph using a hashmap and linked lists as values
public class Graph<T>{
	
	private Map<T,List<T>> map;
	
	public Graph() {
		this.map = new HashMap<>();
	}
	//Each vertex has a linked list of vertices it connects to 
	public void addVertex(T s) {
		this.map.put(s, new java.util.LinkedList<T>());
	}
	/*
	 * Adds an edge between two vertices by adding the 
	 * appropriate vertex in the specified vertex's linked list
	 */
	public void addEdge(T from, T to, boolean bi) {
		if(!this.map.containsKey(from)) {
			this.addVertex(from);
		}
		if(!this.map.containsKey(to)) {
			this.addVertex(to);
		}
		this.map.get(from).add(to);
		if(bi) {
			this.map.get(to).add(from);
		}
	}
	//Gets the count of total vertices in the graph 
	public int getVertexCount() {
		System.out.println("Current Verttices: " + this.map.keySet().size());
		return this.map.keySet().size(); 
	}
	//Gets the count of total edges in the graph including bidirectional ones
	public int getEdgeCount() {
		int count = 0;
		for(T v: this.map.keySet()) {
			count += this.map.get(v).size();
		}
		System.out.println("Current Edges: " + count);
		return count;
	}
	//Checks whether specified vertex exists in the graph 
	public boolean hasVertex(T v) {
		if(this.map.containsKey(v)) {
			System.out.println("This graph contains vertex " + v);
			return true;
		}
		else {
			System.out.println("This graph does not contain vertex " + v);
			return false;
		}
	}
	//Checks whether an edge exists between the two vertices 
	public boolean hasEdge(T to, T from) {
		if(this.map.get(to).contains(from)) {
			System.out.println("This graph contains an edge between " + to + " and " + from);
			return true;
		}
		else {
			System.out.println("This graph does not contain an edge between " + to + " and " + from);
			return false;
		}
	}
	//Prints out the adjacency list of each vertex in the graph 
	public String printGraph(){
		StringBuilder builder = new StringBuilder();
		builder.append("Adjacency List\n");
		for(T v: this.map.keySet()) {
			builder.append(v.toString() + ": ");
			for(T e: this.map.get(v)) {
				builder.append(e.toString() + " ");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	
	
	public static void main(String args[]) {
		Graph<Integer> graph = new Graph<>();
		graph.addEdge(3,7,true);
		graph.addEdge(9,3,true);
		graph.addEdge(6,4,true);
		graph.addEdge(6,3,true);
		graph.addEdge(8,0,true);
		graph.addEdge(0,9,true);
		graph.hasVertex(6);
		graph.hasVertex(10);
		graph.hasEdge(9,3);
		graph.hasEdge(3,8);
		System.out.println(graph.printGraph());
	}
	
}