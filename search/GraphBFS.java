import java.util.Iterator;
import java.util.LinkedList;

/*
 * Java implementation of breadth first search on a 
 * directed graph using adjacency list representation.
 * Author : Komal Soham Wadekar
 */
public class GraphBFS {

	int vertices;
	LinkedList<Integer> listArray[];
	
	public GraphBFS(int vertices){
		this.vertices = vertices;
		listArray = new LinkedList[vertices];
		for(int i=0; i<vertices; i++){
			listArray[i] = new LinkedList<>();
		}		
	}
	
	public void addEdge(GraphBFS graph, int src, int dest){
		listArray[src].add(dest);
	}
	
	public void bfs(int start){
		LinkedList<Integer> bfsList = new LinkedList<>();
		boolean visited[] = new boolean[vertices];
		
		visited[start] = true;
		bfsList.add(start);
		while(!bfsList.isEmpty()){
			int s = bfsList.poll();
			System.out.println(s+" ");
			
			Iterator<Integer> itr = listArray[s].iterator();
			int next=0;
			while(itr.hasNext()){
				next = itr.next();
				if(!visited[next]){
					visited[next] = true;
					bfsList.add(next);
				}				
			}			
		}
	}
		
	public static void main(String args[]){
		GraphBFS graph = new GraphBFS(6);
		
		graph.addEdge(graph, 0, 1);
		graph.addEdge(graph, 0, 4);
		graph.addEdge(graph, 1, 3);
		graph.addEdge(graph, 1, 2);
		graph.addEdge(graph, 2, 3);
		graph.addEdge(graph, 2, 4);
		graph.addEdge(graph, 3, 5);
		
		graph.bfs(1);
		
	}
}

