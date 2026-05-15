import java.util.Scanner;

public class SingleSourceShortestPath {

    static final int INF = 9999;

    public static void dijkstra(int graph[][], int n, int source) {

        int distance[] = new int[n];
        boolean visited[] = new boolean[n];

        // Initialize distances
        for (int i = 0; i < n; i++) {
            distance[i] = INF;
            visited[i] = false;
        }

        distance[source] = 0;

        // Find shortest path
        for (int count = 0; count < n - 1; count++) {

            int min = INF;
            int u = -1;

            // Find minimum distance vertex
            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    u = i;
                }
            }

            visited[u] = true;

            // Update distances
            for (int v = 0; v < n; v++) {

                if (!visited[v]
                        && graph[u][v] != 0
                        && distance[u] + graph[u][v] < distance[v]) {

                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        // Display result
        System.out.println("\nVertex\tShortest Distance");

        for (int i = 0; i < n; i++) {
            System.out.println(i + "\t\t" + distance[i]);
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

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        dijkstra(graph, n, source);

        sc.close();
    }
}