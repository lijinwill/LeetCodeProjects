package DynamicPrograming;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/14/2022 2:29 PM
 */
public class T96 {
    //思路：动态规划，更大的数字可以拆分成左右是更小数字的情况
    //      第一重循环从1开始遍历到n，用于遍历计算dp[]中的所有数据；第二重循环用于具体计算每一个dp[]
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j=0; j<=i/2; j++){
                dp[i] = dp[i] + dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
