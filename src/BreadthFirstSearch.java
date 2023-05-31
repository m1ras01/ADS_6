import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    private Set<Vertex<V>> visited;
    private Map<Vertex<V>, Vertex<V>> parent;

    public BreadthFirstSearch(WeightedGraph<V> graph) {
        super(graph);
        this.visited = new HashSet<>();
        this.parent = new HashMap<>();
    }

    public void bfs(Vertex<V> startVertex) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            System.out.println("Visited: " + currentVertex.getData());

            List<Edge<V>> edges = graph.getEdges(currentVertex);
            for (Edge<V> edge : edges) {
                Vertex<V> destination = edge.getDest();
                if (!visited.contains(destination)) {
                    queue.add(destination);
                    visited.add(destination);
                    parent.put(destination, currentVertex);
                }
            }
        }
    }
}
