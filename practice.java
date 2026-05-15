import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Node{
    int f,g,h;
    int x,y;
    Node parent;
    Node(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class practice {

    static int heuristic(int x1,int x2,int y1,int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
    
    public static void aStar(int[][] grid, int sx, int sy, int gx, int gy) {
        int n = grid.length;
        PriorityQueue<Node> open = 
        new PriorityQueue<>((a,b)->a.f-b.f);

        boolean[][] closed = new boolean[n][n];
        int[][] gCost = new int[n][n];

        for(int[] row : gCost){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        Node start = new Node(sx,sy);
        start.g=0;
        start.h=heuristic(sx, sy, gx, gy);
        start.f=start.g+start.h;

        open.add(start);
        gCost[sx][sy] = 0;
        
        int dx[]={0,0,-1,1};
        int dy[]={-1,1,0,0};

        while (!open.isEmpty()) {
            Node current = open.poll();

            if(current.x == gx && current.y==gy){
                printPath(current);
                return;
            }

            closed[current.x][current.y]=true;

            for(int i=0;i<4;i++){
                int nx = current.x+dx[i];
                int ny = current.y+dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<n && !closed[nx][ny] && grid[nx][ny]==0){
                    int newG = current.g+1;
                    if (newG < gCost[nx][ny]) {
                        Node neighbour =new Node(nx,ny);
                        neighbour.g= newG;
                        neighbour.h=heuristic( nx, ny, gx,gy);
                        neighbour.f=neighbour.g+neighbour.h;
                        neighbour.parent=current;

                        gCost[nx][ny] = newG;
                        open.add(neighbour);
                    }
                }
            }
        }
        System.out.println("No path found");
    }

    public static void printPath(Node node){
        List<Node> path = new ArrayList<>();
        while(node!=null){
            path.add(node);
            node=node.parent;
        }

        Collections.reverse(path);

        for(Node n:path){
            System.out.println("(" + n.x + ", " + n.y + ")");
        }
    }


    public static void main(String[] args) {
        int grid[][]={
            {0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0}
        };
        aStar(grid, 0,0,4,4);
    }


}
