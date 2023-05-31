public class Main {
    public static void main(String[] args) {
        MyGraph s = new MyGraph(8);
        s.addEdge(1,2);
        s.addEdge(1,3);
        s.addEdge(2,4);
        s.addEdge(2,5);
        s.addEdge(3,6);
        s.addEdge(3,7);
        s.dfs(1);
    }
}