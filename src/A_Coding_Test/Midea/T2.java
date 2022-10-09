package A_Coding_Test.Midea;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/28 22:11
 */
public class T2 {
    public double maxProfit (double[] prices) {
        // write code here
        double mp = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j<prices.length; j++){
                double profit = prices[j] - prices[i];
                if (profit > mp) {
                    mp = profit;
                }
            }
        }
        return mp;
    }
}
