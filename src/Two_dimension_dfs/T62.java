package Two_dimension_dfs;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-04-19$ $
 */
public class T62 {
    public static void main(String[] args) {
        int m = 100, n = 100;
        T62 test = new T62();
        System.out.println(test.uniquePaths(m,n));
    }

    /*思路：dfs

     */
    int count = 0;
    public int uniquePaths(int m, int n) {
        dfs(m, n, 0, 0);
        return count;
    }
    public void dfs(int m, int n, int i, int j){
        if(i>=m || j>=n){
            return;
        }
        if(i == m-1 && j == n-1) count++;

        dfs(m, n, i+1, j);
        dfs(m, n, i, j+1);

    }
}
