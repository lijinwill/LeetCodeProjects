package DP_0_1_bag;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/19 16:16
 */
public class T416 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,11,5};
        T416 test = new T416();
        System.out.println(test.canPartition(nums));
    }

    //思路：01背包，其中dp[j]表示 背包总容量是j，最大可以凑成j的子集总和为dp[j]。
    public boolean canPartition(int[] nums) {

        return false;
    }
}
