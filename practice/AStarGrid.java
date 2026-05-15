import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int x, y, f, g, h;
    Node parent;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class AStarGrid {
    public static int heuristic(int sx, int sy, int gx, int gy) {
        return Math.abs(sx - gx) + Math.abs(sy - gy);
    }

    public static void aStar(int[][] grid, int sx, int sy, int gx, int gy) {
        int n = grid.length;
        PriorityQueue<Node> open = new PriorityQueue<>((a, b) -> a.f - b.f);

        boolean[][] closed = new boolean[n][n];
        int[][] gCost = new int[n][n];

        for (int row[] : gCost)
            Arrays.fill(row, Integer.MAX_VALUE);

        Node start = new Node(sx, sy);
        start.g = 0;
        start.h = heuristic(sx, sy, gx, gy);
        start.f = start.g + start.h;
        open.add(start);

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

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

                int newG = current.g + 1;
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !closed[nx][ny] && grid[nx][ny] == 0) {
                    Node neighbour = new Node(nx, ny);
                    neighbour.g = newG;
                    neighbour.h = heuristic(nx, ny, gx, gy);
                    neighbour.f = neighbour.g + neighbour.h;
                    neighbour.parent = current;
                    gCost[nx][ny] = newG;
                    open.add(neighbour);
                }
            }
        }

    }

    public static void printPath(Node node) {
        List<Node> path = new ArrayList<Node>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }

        Collections.reverse(path);

        for (Node n : path) {
            System.out.println("(" + n.x + "," + n.y + ")");
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 1, 0 },
                { 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0 }
        };
        aStar(grid, 0, 0, 4, 4);
    }
}