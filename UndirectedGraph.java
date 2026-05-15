import java.util.*;

public class UndirectedGraph {

    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    // Constructor
    UndirectedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add edge (undirected)
    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // ================= DFS =================
    void DFS() {
        boolean[] visited = new boolean[V];

        System.out.print("DFS Traversal: ");

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsUtil(i, visited);
            }
        }
        System.out.println();
    }

    void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // ================= BFS =================
    void BFS() {
        boolean[] visited = new boolean[V];

        System.out.print("BFS Traversal: ");

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfsUtil(i, visited);
            }
        }
        System.out.println();
    }

    void bfsUtil(int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        UndirectedGraph g = new UndirectedGraph(7);

        // Component 1
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);

        // Component 2 (disconnected)
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        g.DFS();
        g.BFS();
    }
} 
