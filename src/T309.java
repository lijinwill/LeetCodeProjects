/**
 * @author Will
 * @version 1.0
 * @description: 六、买卖不限制次数，k=infinity，但有冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)
 * @date 2020/11/29 16:44
 */
public class T309 {
    public static void main(String[] args) {
        int[] test = new int[]{2,4,1};
        int t = 2;
        int result = T188.maxProfit(t, test);
        System.out.println(result);

    }
    //用状态转移矩阵做
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        int maxProfit = Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
        return maxProfit;
    }

}
