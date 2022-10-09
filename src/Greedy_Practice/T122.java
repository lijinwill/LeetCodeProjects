package Greedy_Practice;

/**
 * @author Will
 * @version 1.0
 * @description: 四、买卖不限制次数，k=infinity
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @date 2020/11/27 21:52
 */
public class T122 {
    public static void main(String[] args) {
        int[] test = new int[]{7,1,5,3,6,4};
        int result = T122.maxProfit(test);
        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {

        int len = prices.length;
        if (len == 0 || len == 1) {
            return 0;
        }

        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][0] + prices[len - 1], dp[len - 1][1]);

    }



/*
        //状态转移矩阵
        int n = prices.length;
        //排除数组为空的特例
        if (n==0){
            return 0;
        }

        int[][] dp = new int[n][2];
        int i = 0;
        for (i = 0; i < n; i++) {
            if(i-1 == -1){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);

        }
        return dp[i-1][0];
*/



/*        //自己写的方法
        //排除单个情况，比如数组为[1]
        if (prices.length == 1){
            return 0;
        }

        int buy = 0;
        int sell = 0;
        int length = prices.length;
        int profit = 0;
        int flag = 0;


        for (int i=0; i<length-1; i++){
            if (prices[i]>=prices[i+1] && flag==0){
                continue;
            }
            if ( prices[i]<prices[i+1] && flag ==0 ){
                buy = i;
                flag = 1;
                continue;
            }else if(prices[i]<prices[i+1] && i!=length-2) {
                continue;
            }else{
                sell = i;
                profit = profit + (prices[sell] - prices[buy]);
                flag = 0;
            }
        }

        //前面的遍历没有考虑最后一个数，这里单独考虑一下
        if ( prices[length-2]<prices[length-1] ){
            profit = profit + (prices[length-1]-prices[length-2]);
        }

        return profit;*/

}
