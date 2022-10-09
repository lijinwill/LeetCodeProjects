import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * @author Will
 * @version 1.0
 * @description: 一、买卖一次，k=1
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * @date 2020/11/27 22:42
 */
public class T121 {
    public static void main(String[] args) {
        int[] test = new int[]{7, 1, 5, 3, 6, 4};
        int result = T121.maxProfit(test);
        System.out.println(result);
    }

    public static int maxProfit(int prices[]) {

        //GitHub上状态转移矩阵的方法做的
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                // 解释：
                //   dp[i][0]
                // = max(dp[-1][0], dp[-1][1] + prices[i])
                // = max(0, -infinity + prices[i]) = 0
                dp[i][1] = -prices[i];
                //解释：
                //   dp[i][1]
                // = max(dp[-1][1], dp[-1][0] - prices[i])
                // = max(-infinity, 0 - prices[i])
                // = -prices[i]
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }
        return dp[n - 1][0];


/*        //之所以把minprice一开始设定为整数里的最大值，而不是prices[0]，是为了防止输入的数组为空报错
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i<prices.length; i++){
            if (prices[i] < minprice){
                minprice = prices[i];
            }else{
                maxprofit = maxprofit>(prices[i]-minprice) ? maxprofit:(prices[i]-minprice);
            }
        }

        return maxprofit;*/
    }


/*    //思路：从后往前，每次找到前面的最小值，然后做差为最大利润
    //可行但是效率太低！！
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;

        for (int i = length-1; i>0 ; i--) {
            //这里截取考虑位置之前的prices数组
            int[] subPrices = Arrays.copyOfRange(prices,0,i);
            //找到最小值
            IntSummaryStatistics stat = Arrays.stream(subPrices).summaryStatistics();
            int min = stat.getMin();

            maxProfit =  (prices[i]-min)>maxProfit ? (prices[i]-min):maxProfit;

        }
        return maxProfit;
    }*/
}
