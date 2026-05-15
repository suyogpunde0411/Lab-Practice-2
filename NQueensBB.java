public class NQueensBB {
    int N;
    boolean[] cols,leftDiag,rightDiag;
    public void solveNQueen(int n) {
        this.N=n;
        int[][] board = new int[N][N];

        cols = new boolean[N];
        leftDiag =new boolean[2*N -1];
        rightDiag = new boolean[2*N-1];

        solve(board,0);
    }
 
    private void solve(int[][] board, int row) {
       if(row==N){
        printBoard(board);
        System.out.println();
        return;
       }
        for(int col=0;col<N;col++){
        if(!cols[col] && !leftDiag[row-col+N-1] && !rightDiag[row+col]){
            //keep queen    
            board[row][col]=1;
            cols[col]=true;
            leftDiag[row-col+N-1]=true;
            rightDiag[row+col]=true;

            solve(board, row + 1);
        
            board[row][col]=0;
            cols[col]=false;
            leftDiag[row-col+N-1]=false;
            rightDiag[row+col]=false;

        }
       }
    }

    private void printBoard(int[][] board) {
       for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueensBB obj = new NQueensBB();
        obj.solveNQueen(5);
        
    }

}
