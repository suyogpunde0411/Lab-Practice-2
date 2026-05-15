import java.util.Scanner;

public class SingleShortestPath {
    static final int INF = 9999;

    public static void djikstras(int[][] graph, int n, int source) {
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            distance[i] = INF;
            visited[i] = false;
        }
        distance[source] = 0;
        for (int count = 0; count < n - 1; count++) {
            int min = INF;
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    u = i;
                }
            }
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }

        }

        System.out.println("Distance from source " + source + " : ");
        System.out.println("Vertex\t Shortest Distance");
        for (int i = 0; i < n; i++) {
            System.out.print(i + "\t\t" + distance[i] + '\n');
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        int graph[][] = new int[n][n];
        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter Source :");
        int source = sc.nextInt();

        djikstras(graph, n, source);
    }

}
