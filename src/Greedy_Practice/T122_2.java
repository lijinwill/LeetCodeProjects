package Greedy_Practice;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-14$ $
 */
public class T122_2 {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        T122_2 test = new T122_2();
        System.out.println(test.maxProfit(prices));
    }

    /*思路：代码随想录贪心章节，prices数组两两做差，只收集每天的正利润，求和即可

     */
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i=0; i<prices.length-1; i++){
            int profit = prices[i+1] - prices[i];
            if(profit > 0){
                result = result + profit;
            }
        }
        return result;
    }
}
