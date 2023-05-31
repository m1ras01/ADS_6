import java.util.ArrayList;
import java.util.List;

public abstract class Search<V> {
    protected WeightedGraph<V> graph;
    protected Vertex<V> source;

    public Search(WeightedGraph<V> graph, Vertex<V> source) {
        this.graph = graph;
        this.source = source;
    }

    public abstract List<Vertex<V>> search();
}
