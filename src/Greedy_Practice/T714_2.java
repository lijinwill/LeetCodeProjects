package Greedy_Practice;

public class T714_2 {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 4,5, 9};
        int fee = 2;
        T714_2 test = new T714_2();
        int result = test.maxProfit(prices,fee);
        System.out.println(result);
    }
    /*
        这个贪心不是我写的，非常巧妙，难以模仿
     */
    public int maxProfit(int[] prices, int fee) {
        int buy = prices[0] + fee;
        int sum = 0;
        for (int p : prices) {
            if (p + fee < buy) {
                buy = p + fee;
            } else if (p > buy){
                sum += p - buy;
                buy = p;
            }
        }
        return sum;
    }
}
