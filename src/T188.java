/**
 * @author Will
 * @version 1.0
 * @description: 三、买卖k次
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @date 2020/11/29 16:14
 */
public class T188 {
    public static void main(String[] args) {
        int[] test = new int[]{2,4,1};
        int t = 2;
        int result = T188.maxProfit(t, test);
        System.out.println(result);

    }

    //用状态转移矩阵做
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //排除特例
        if (n == 0) {
            return 0;
        }

        int max_k = k;
        int[][][] dp = new int[n][max_k + 1][2];

        for (int i = 0; i < n; i++) {
            for (int t = max_k; t >= 1; t--) {
                if (i == 0) {
                    dp[0][t][0] = 0;
                    dp[0][t][1] = -prices[0];
                    continue;
                }
                dp[i][t][0] = Math.max(dp[i - 1][t][0], dp[i - 1][t][1] + prices[i]);
                dp[i][t][1] = Math.max(dp[i - 1][t][1], dp[i - 1][t - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }

}


