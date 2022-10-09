package DynamicPrograming;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/13/2022 1:16 PM
 */
public class T746 {
    //思路：和打家劫舍类似
    public int minCostClimbingStairs(int[] cost) {
        //设置dp[]表示到达当前台阶花费的最小费用和
        int len = cost.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i=2; i<=len; i++){
            dp[i] = Math.min(dp[i-2]+cost[i-2], dp[i-1]+cost[i-1]);
        }
        return dp[len];
    }
}
