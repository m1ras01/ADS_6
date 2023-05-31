import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> adjacencyList;

    public WeightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        source.addAdjacentVertex(destination, weight);
        adjacencyList.get(source).add(destination);
    }

    public List<Vertex<V>> getAdjacentVertices(Vertex<V> vertex) {
        return adjacencyList.get(vertex);
    }

    public Map<Vertex<V>, List<Vertex<V>>> getAdjacencyList() {
        return adjacencyList;
    }
}
