import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: 这道题先放着
 * @date 2020/12/5 15:52
 */
public class T322 {
    public static void main(String[] args) {
        //硬币种类
        int[] coins = new int[]{2, 7, 10};
        //硬币和大小
        int amount = 3;
        T322 test = new T322();
        System.out.println(test.coinChange(coins, amount));
    }


    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        //dp表示当前下标数组的最短路径长度
        int[] dp = new int[amount + 1];
        //全填充为不可能出现的最大值
        Arrays.fill(dp, max);
        dp[0] = 0;
        //第一个for循环用于遍历
        for (int i = 1; i <= amount; i++) {
            //第二个for循环用于找出每个小于amount的数的最短路径长度
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    //这里的意思是，只有当有更短的路径时，才更新dp[i]，本质是将dp更新为dp[i-2]、dp[i-7]、dp[i-10]的最小值+1
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    /*
    public int coinChange(int[] coins, int amount) {
        //排除0情况
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int amount, int[] count){
        if (amount < 0){
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        if(min == Integer.MAX_VALUE){
            count[amount - 1] = -1;
        }else{
            count[amount - 1] = min;
        }
        return count[amount - 1];
    }

    */

}

