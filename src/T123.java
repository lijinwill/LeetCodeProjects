/**
 * @author Will
 * @version 1.0
 * @description: 二、买卖只可以两次，k=2
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @date 2020/11/29 12:30
 */
public class T123 {
    public static void main(String[] args) {
        int[] test = new int[]{3,3,5,0,0,3,1,4};
        int result = T123.maxProfit(test);
        System.out.println(result);
    }

    //状态转移方法做的
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        //排除特例
        if (n == 0){
            return 0;
        }

        int max_k = 2;
        int[][][] dp = new int[n][max_k+1][2];

        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >=1 ; k--) {
                if (i == 0){
                    dp[0][k][0] = 0;
                    dp[0][k][1] = -prices[0];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1]+prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[n-1][max_k][0];
    }
}
