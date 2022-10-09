package Greedy_Practice;

/**
 * @author Will
 * @version 1.0
 * @description: 买卖不限制次数，k=infinity，但有手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；
 * 非负整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。
 * 如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * @date 2020/11/30 10:16
 */
public class T714 {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
        int result = T714.maxProfit(prices,fee);
        System.out.println(result);
    }

    public static int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len==0 || len==1){
            return 0;
        }

        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]+prices[i]-fee, dp[i-1][1]);
        }
        return Math.max(dp[len-1][0]+prices[len-1]-fee, dp[len-1][1]);

    }
}
