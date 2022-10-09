package Greedy_Practice;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/14 22:37
 */
public class T55 {
    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.println(T55.canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int farest = nums[0];
        for (int i = 0; i <= farest && i< nums.length-1; i++) {
            farest = Math.max(farest,nums[i]+i);
        }
        return farest>=nums.length-1 ? true:false;

    }
}
