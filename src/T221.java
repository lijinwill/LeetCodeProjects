public class T221 {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},
                            {'1','0','1','1','1'},
                            {'1','1','1','1','1'},
                            {'1','0','0','1','0'}};
        T221 test = new T221();
        System.out.println(test.maximalSquare(matrix));
    }

    //思路：二维矩阵的动态规划，定义一个二维矩阵，当原矩阵为0，dp[][]为0；
    //当原矩阵为1，则dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int result = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    //字符串转数组的技巧
                    dp[i][j] = matrix[i][j] - '0';
                    //这个if用于解决出现左边界和上边界有1，其余全0的情况
                    if (dp[i][j] == 1 && result == 0) {
                        result = 1;
                    }
                    continue;
                }
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result * result;
    }
}