/*
 * Java Code for Dijkstra's Algorithm for weighted undirected graph using priority queue
 * Author : Komal Soham Wadekar
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraPQ {

	int vertices;
	LinkedList<Node> listArr[];
	int distance[];
	PriorityQueue<Node> pq;
	Set<Integer> visited;

	class Node implements Comparable<Node> {
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node node) {
			// TODO Auto-generated method stub
			if (this.weight > node.weight)
				return 1;
			else if (this.weight < node.weight)
				return -1;
			else
				return 0;

		}
	}

	public DijkstraPQ(int vertices) {
		this.vertices = vertices;
		listArr = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			listArr[i] = new LinkedList<Node>();
		}
		distance = new int[vertices];
		pq = new PriorityQueue<Node>();
		visited = new HashSet<Integer>();
	}

	public void addEdge(int src, int dest, int weight) {
		Node node = new Node(dest, weight);
		listArr[src].add(node);
		node = new Node(src, weight);
		listArr[dest].add(node);
	}

	public void printGraph(DijkstraPQ graph) {
		for (int i = 0; i < graph.vertices; i++) {
			LinkedList<Node> list = graph.listArr[i];
			for (int j = 0; j < list.size(); j++) {
				System.out.println("Vertex " + i + " is connected to vertex " + list.get(j).vertex + " with wight "
						+ list.get(j).weight);
			}
		}
	}

	public void shortestPath(int source) {

		for (int i = 0; i < vertices; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		distance[source] = 0;
		pq.add(new Node(source, 0));

		while (!pq.isEmpty()) {
			int vertex = pq.remove().vertex;
			visited.add(vertex);
			traverseNeighbors(vertex);
		}
		printShortestPaths(source);
	}

	public void traverseNeighbors(int vertex) {
		int edgeWeight = -1;
		int newWeight = -1;

		for (int i = 0; i < listArr[vertex].size(); i++) {
			Node v = listArr[vertex].get(i);
			if (!visited.contains(v.vertex)) {
				edgeWeight = v.weight;
				newWeight = distance[vertex] + edgeWeight;
				if (newWeight < distance[v.vertex]) {
					distance[v.vertex] = newWeight;
				}
				pq.add(new Node(v.vertex, distance[v.vertex]));
			}
		}
	}

	public void printShortestPaths(int source) {
		System.out.println("Shortest path from node : ");
		for (int i = 0; i < distance.length; i++) {
			System.out.print(source + " to " + i + " is " + distance[i]);
			System.out.println();
		}
	}

	public static void main(String args[]) {
		DijkstraPQ graph = new DijkstraPQ(5);

		graph.addEdge(0, 1, 9);
		graph.addEdge(0, 2, 6);
		graph.addEdge(0, 3, 17);
		graph.addEdge(0, 4, 13);
		graph.addEdge(2, 1, 4);
		graph.addEdge(2, 3, 4);
		graph.addEdge(4, 2, 3);

		graph.printGraph(graph);
		graph.shortestPath(0);

	}
}
