import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraph {

    private int V;
    private ArrayList<ArrayList<Integer>>  adj;

    UndirectedGraph(int V){
        this.V =V;
        adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        } 
    }

    public void addEdge(int i,int j){
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    public void DFS(){
        boolean[] visited  = new boolean[V];
        System.out.println("DFS Traversal : ");
        for(int i=0;i<V;i++){
           if(!visited[i]){
            DFSUtil(i,visited);
            }
        }
    }

    public void DFSUtil(int node , boolean[] visited){
        visited[node] =true;
        System.out.print(node+" ");
        for(int neighbour: adj.get(node)){
            if(!visited[neighbour]){
                DFSUtil(neighbour, visited);
            }
        }
    }

    public void BFS(){
        boolean[] visited =new boolean[V];
        System.out.println("BFS Traversal :");
        for(int i=0;i<V;i++){
            if(!visited[i]){
                BFSUtil(i,visited);
            }
        }
    }

    public void BFSUtil(int start,boolean[] visited){
        Queue<Integer> queue =new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()){
            int curr = queue.poll();
            System.out.print(curr+" ");
            for(int neighbour: adj.get(curr)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    queue.add(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {
        UndirectedGraph g = new UndirectedGraph(7);
         // Component 1
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        // Component 2 (disconnected)
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        g.DFS();
        System.out.println();
        g.BFS();

    }
}