package DynamicPrograming;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/19 0:22
 */
public class T62 {
    //思路：每一个方块的路经数等于左边的路经数+上方的路经数
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) return 1;

        int[][] dp = new int[m][n];
        dp[0][0] = 0;

        //先处理第一行和第一列
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
