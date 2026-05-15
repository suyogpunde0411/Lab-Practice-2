import java.util.*;

class Node {
    int x, y, g, h, f;
    Node parent;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class AStarGrid {

    static int heuristic(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static void aStar(int[][] grid, int sx, int sy, int gx, int gy) {

        int n = grid.length;

        PriorityQueue<Node> open = new PriorityQueue<>((a, b) -> a.f - b.f);

        boolean[][] closed = new boolean[n][n];
        int[][] gCost = new int[n][n];

        for (int[] row : gCost)
            Arrays.fill(row, Integer.MAX_VALUE);

        Node start = new Node(sx, sy);
        start.g = 0;
        start.h = heuristic(sx, sy, gx, gy);
        start.f = start.g + start.h;

        open.add(start);
        gCost[sx][sy] = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!open.isEmpty()) {

            Node current = open.poll();

            if (current.x == gx && current.y == gy) {
                printPath(current);
                return;
            }

            closed[current.x][current.y] = true;

            for (int i = 0; i < 4; i++) {

                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n &&
                    grid[nx][ny] == 0 && !closed[nx][ny]) {

                    int newG = current.g + 1;

                    if (newG < gCost[nx][ny]) {

                        Node neighbor = new Node(nx, ny);
                        neighbor.g = newG;
                        neighbor.h = heuristic(nx, ny, gx, gy);
                        neighbor.f = neighbor.g + neighbor.h;
                        neighbor.parent = current;

                        gCost[nx][ny] = newG;
                        open.add(neighbor);
                    }
                }
            }
        }

        System.out.println("No path found");
    }

    static void printPath(Node node) {
        List<Node> path = new ArrayList<>();

        while (node != null) {
            path.add(node);
            node = node.parent;
        }

        Collections.reverse(path);

        for (Node n : path) {
            System.out.println("(" + n.x + ", " + n.y + ")");
        }
    }

    public static void main(String[] args) {

        int[][] grid = {
            {0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };

        aStar(grid, 0, 0, 4, 4);
    }
}