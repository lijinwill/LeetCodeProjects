package Two_dimension_dfs;

public class T130 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','O','X'},{'X','O','X'},{'X','O','X'}};
        T130 test = new T130();
        test.solve(board);
        System.out.println(board);
    }
        /*思路：深度优先遍历
            1、先对边界上的O进行dfs，boolean[][]visited全部标为true
            2、去除边界主函数双重for，遇到X跳过，遇到不在边界上的O且visited为false的就进行dfs，
                并将其更改为X
    */

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        //把第一列上的O以及相连的O存为visited = ture
        for(int i=0; i<m; i++){
            if(board[i][0]=='O' && visited[i][0]==false){
                dfs(board, i, 0, visited);
            }
        }
        //把最后一列上的O以及相连的O存为visited = ture
        for(int i=0; i<m; i++){
            if(board[i][n-1]=='O' && visited[i][n-1]==false){
                dfs(board, i, n-1, visited);
            }
        }
        //把第一行上的O以及相连的O存为visited = ture
        for(int j=1; j<n-1; j++){
            if(board[0][j]=='O' && visited[0][j]==false){
                dfs(board, 0, j, visited);
            }
        }
        //把最后一行上的O以及相连的O存为visited = ture
        for(int j=1; j<n-1; j++){
            if(board[m-1][j]=='O' && visited[m-1][j]==false){
                dfs(board, m-1, j, visited);
            }
        }

        //处理去除边界的中心部分，上面保证了中心的剩余O都是不与边界相连的
        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                if(board[i][j] == 'O' && visited[i][j] == false){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j, boolean[][] visited){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return;
        }

        if(board[i][j] == 'O' && visited[i][j] == false){
            visited[i][j] = true;

            dfs(board, i+1, j, visited);
            dfs(board, i-1, j, visited);
            dfs(board, i, j+1, visited);
            dfs(board, i, j-1, visited);
        }else if(board[i][j] == 'O' && visited[i][j] == true || board[i][j] == 'X'){
            return;
        }
    }
}
