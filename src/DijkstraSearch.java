import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distance;
    private Map<Vertex<V>, Vertex<V>> parent;

    public DijkstraSearch(WeightedGraph<V> graph) {
        super(graph);
        this.distance = new HashMap<>();
        this.parent = new HashMap<>();
    }

    public void dijkstra(Vertex<V> startVertex) {
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distance::get));
        distance.put(startVertex, 0.0);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();

            List<Edge<V>> edges = graph.getEdges(currentVertex);
            for (Edge<V> edge : edges) {
                Vertex<V> destination = edge.getDest();
                double newDistance = distance.get(currentVertex) + edge.getWeight();

                if (!distance.containsKey(destination) || newDistance < distance.get(destination)) {
                    queue.remove(destination);
                    distance.put(destination, newDistance);
                    parent.put(destination, currentVertex);
                    queue.add(destination);
                }
            }
        }
    }

    public double getShortestDistance(Vertex<V> destination) {
        return distance.getOrDefault(destination, Double.POSITIVE_INFINITY);
    }

    public List<Vertex<V>> getShortestPath(Vertex<V> destination) {
        List<Vertex<V>> path = new ArrayList<>();

        while (destination != null) {
            path.add(destination);
            destination = parent.get(destination);
        }

        Collections.reverse(path);
        return path;
    }
}
