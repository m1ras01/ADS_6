import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(graph, source);
    }

    @Override
    public List<Vertex<V>> search() {
        List<Vertex<V>> path = new ArrayList<>();
        Queue<Vertex<V>> queue = new ArrayDeque<>();
        Set<Vertex<V>> visited = new HashSet<>();
        Map<Vertex<V>, Vertex<V>> parentMap = new HashMap<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            path.add(currentVertex);

            for (Vertex<V> adjacentVertex : graph.getAdjacentVertices(currentVertex)) {
                if (!visited.contains(adjacentVertex)) {
                    queue.add(adjacentVertex);
                    visited.add(adjacentVertex);
                    parentMap.put(adjacentVertex, currentVertex);
                }
            }
        }

        return path;
    }
}
