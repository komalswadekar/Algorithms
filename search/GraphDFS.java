import java.util.Iterator;
import java.util.LinkedList;

/*
 * Java implementation of depth first search on a 
 * directed graph using adjacency list representation.
 * Author : Komal Soham Wadekar
 */
public class GraphDFS {

	int vertices;
	LinkedList<Integer> listArray[];

	public GraphDFS(int vertices) {
		this.vertices = vertices;
		listArray = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			listArray[i] = new LinkedList<>();
		}
	}

	public void addEdge(GraphDFS graph, int src, int dest) {
		listArray[src].add(dest);
	}

	public void dfs(int start) {
		LinkedList<Integer> dfsList = new LinkedList<>();
		boolean visited[] = new boolean[vertices];
		dfsSearch(visited, dfsList, start);

	}

	public void dfsSearch(boolean visited[], LinkedList<Integer> dfsList, int start) {
		visited[start] = true;
		dfsList.add(start);

		while (!dfsList.isEmpty()) {
			int s = dfsList.poll();
			System.out.println(s + " ");

			Iterator<Integer> itr = listArray[s].iterator();
			int next = 0;
			while (itr.hasNext()) {
				next = itr.next();
				if (!visited[next]) {

					dfsSearch(visited, dfsList, next);
				}
			}
		}
	}

	public static void main(String args[]) {
		GraphDFS graph = new GraphDFS(6);

		graph.addEdge(graph, 0, 1);
		graph.addEdge(graph, 0, 4);
		graph.addEdge(graph, 1, 3);
		graph.addEdge(graph, 1, 2);
		graph.addEdge(graph, 2, 3);
		graph.addEdge(graph, 2, 4);
		graph.addEdge(graph, 0, 5);

		graph.dfs(0);
	}
}
