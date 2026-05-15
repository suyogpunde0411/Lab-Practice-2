public class NQueenBT {
    int N;
    public void solveNQueen(int n){
        this.N=n;
        int[][] board = new int[N][N];
        solve(board,0);
    }

    public void solve(int[][] board,int row){
        if(row == N){
            printBoard(board);
            System.out.println();
            return;
        }
        for(int col=0;col<N;col++){
            if(isSafe(row, col, board)){
                board[row][col]=1;
                solve(board, row+1);
                board[row][col]=0;
            }
        }
    }    

    public boolean isSafe(int row,int col,int[][] board){
        for(int i=0;i<row;i++){
            if(board[i][col]==1) return false;
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]==1) return false;
        }
        for(int i=row,j=col;i>=0 && j<N;i--,j++){
            if(board[i][j]==1) return false;
        }
        return true;
    }

    public void printBoard(int[][] board){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        NQueenBT obj = new NQueenBT();
        obj.solveNQueen(4);
    }
}