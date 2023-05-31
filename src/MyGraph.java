import java.util.LinkedList;

public class MyGraph {
    private int numberOfVertex;
    private LinkedList<Integer>[] edgeList;

    public MyGraph(int numberOfVertex){
        this.numberOfVertex = numberOfVertex;
        this.edgeList = new LinkedList[numberOfVertex];
        for(int i = 0 ; i < numberOfVertex;i++){
            edgeList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source , int destination){
        checker(source);
        checker(destination);
        edgeList[source].add(destination);
        edgeList[destination].add(source);
    }

    public void printGraph(){
        for (int i = 0 ; i < numberOfVertex;i++){
            System.out.print("Vertex " + i + " connected to: ");
            for(int neighbor : edgeList[i]){
                System.out.print(neighbor+" ");
            }
            System.out.println();
        }
    }

    public void removeEdge(int source,int destination){
        checker(source);
        checker(destination);
        edgeList[source].remove(source);
        edgeList[destination].remove(source);
    }
    public boolean hasEdge(int source, int destination){
        checker(source);
        checker(destination);
        return edgeList[source].contains(destination);
    }
    public void checker(int index){
        if(index<0 || index > numberOfVertex){
            throw new IllegalArgumentException("Vertex "+ index+" is out of range!");
        }
    }
    public LinkedList<Integer> getNeighbor(int vertex){
        checker(vertex);
        return edgeList[vertex];
    }

    public void dfs(int startVertex){
        checker(startVertex);
        boolean[] visited = new boolean[numberOfVertex];
        dfs(startVertex,visited);
    }
    private void dfs(int startVertex , boolean[] visited){
        visited[startVertex] = true;
        System.out.print(startVertex+" ");
        for (int neighbor:edgeList[startVertex]){
            if(!visited[neighbor]){
                dfs(neighbor,visited);
            }
        }
    }

    public void bfs(int startVertex){
        checker(startVertex);
        boolean[] visited = new boolean[numberOfVertex];
        bfs(startVertex,visited);

    }
    private void bfs(int starVertex, boolean[] visited){

    }

}


