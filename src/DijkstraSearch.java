import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraSearch<V> extends Search<V> {
    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(graph, source);
    }

    @Override
    public List<Vertex<V>> search() {
        List<Vertex<V>> path = new ArrayList<>();
        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> parentMap = new HashMap<>();
        Queue<Vertex<V>> priorityQueue = new PriorityQueue<>((v1, v2) -> Double.compare(distances.get(v1), distances.get(v2)));

        for (Vertex<V> vertex : graph.getAdjacencyList().keySet()) {
            distances.put(vertex, Double.MAX_VALUE);
        }

        distances.put(source, 0.0);
        priorityQueue.add(source);

        while (!priorityQueue.isEmpty()) {
            Vertex<V> currentVertex = priorityQueue.poll();

            for (Vertex<V> adjacentVertex : graph.getAdjacentVertices(currentVertex)) {
                double newDistance = distances.get(currentVertex) + currentVertex.getAdjacentVertices().get(adjacentVertex);

                if (newDistance < distances.get(adjacentVertex)) {
                    priorityQueue.remove(adjacentVertex);
                    distances.put(adjacentVertex, newDistance);
                    parentMap.put(adjacentVertex, currentVertex);
                    priorityQueue.add(adjacentVertex);
                }
            }
        }

        Vertex<V> current = graph.getAdjacencyList().keySet().stream().filter(v -> v.equals(source)).findFirst().orElse(null);
        while (current != null) {
            path.add(0, current);
            current = parentMap.get(current);
        }

        return path;
    }
}
