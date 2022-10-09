package DynamicPrograming;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/13/2022 7:49 PM
 */
public class T343 {
    public static void main(String[] args) {
        int n = 10;
        T343 test = new T343();
        System.out.println(test.integerBreak(n));
    }
    //思路：动态规划，设置dp[n+1]，dp[i]表示i拆分后能取得的最大的乘积
    //     dp[i]要么是dp[j]*(i-j)，要么是j*(i-j)，求其中较大者即可
    public int integerBreak(int n) {

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        if (n == 2) return 1;

        //遍历到n，求出每一个值拆分后能取得的最大乘积
        for (int i = 3; i<=n; i++){
            for (int j=i-1; j>0; j--){
                dp[i] = Math.max(dp[i], dp[j]*(i-j));
                dp[i] = Math.max(dp[i], j*(i-j));
            }
        }
        return dp[n];
    }
}
