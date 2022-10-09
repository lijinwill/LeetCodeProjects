package Greedy_Practice;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-14$ $
 */
public class T55_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        T55_2 test = new T55_2();
        System.out.println(test.canJump(nums));
    }
    /*思路：建立一个visit数组，每个位置记录当前位置可否到达
           然后递归，用visit记录最远访问的地方
     */

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1) return true;

        int visit = 0;
        for (int i=0; i<nums.length && i<=visit; i++){
            visit = Math.max(visit, i + nums[i]);
            if(visit >= nums.length-1) return true;
        }
        return false;
    }
}
