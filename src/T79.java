import java.util.ArrayList;
import java.util.List;

public class T79 {
    public static void main(String[] args) {
        char[][] board =new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
//        char[][] board =new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
//        String word = "AAB";
        T79 test = new T79();
        System.out.println(test.exist(board, word));
    }


    public boolean exist(char[][] board, String word) {
        int m = board.length;//横长
        int n = board[0].length;//列长
        boolean[][] visited = new boolean[m][n];//用于记录哪些被访问过，防止重复访问的现象发生
        boolean result = false;//用于最终结果返回
        int p=0;//用于标记访问到word的长度

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    result = dfs(i, j, board, word, visited, p);
                    if(result == true) return true;//这里的目的是只要找到，就立马结束程序
                }
            }
        }
        return result;
    }

    //n表示word的访问位置
    public boolean dfs(int i, int j, char[][] board, String word, boolean[][] visited,int p){
        //二维数组的深度优先遍历的边界判断条件，以及是否访问过的判断
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j] == true){
            return false;
        }

        if(board[i][j] == word.charAt(p)){
            visited[i][j] = true;
            p++;
        }else{
            return false;
        }
        //如果找到一个符合的直接返回true
        if(p == word.length()){
            return true;
        }
        //注意这种写法的意思是只要其中一个路径找到了答案，result就会为true，会直接跳过后续的dfs
        boolean result =
                dfs(i+1, j, board, word, visited, p) || dfs(i-1, j, board, word, visited, p) ||
                dfs(i, j+1, board, word, visited, p) || dfs(i, j-1, board, word, visited, p);
        //这两部分是dfs的回退机制，与上面的代码 visited[i][j] = true; p++; 是相对应应的反向操作，每一轮递归结束时都要完成回退
        visited[i][j] = false;
        p--;

        return result;
    }

}
