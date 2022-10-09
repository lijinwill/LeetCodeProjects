package Greedy_Practice;

import java.util.Arrays;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-15$ $
 */
public class T1005 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,3};
        int k = 1;
        T1005 test = new T1005();
        System.out.println(test.largestSumAfterKNegations(nums,k));
    }
    /*思路：先排序，然后遍历，遇到负数就反转，k--，
            然后将全部非负排序，将最小的值反转剩余k的次数
            再求和

     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;

        Arrays.sort(nums);
        for (int i=0; i<len; i++) {
            //遇到负数且k>0，反转负数，求和
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                sum = sum + nums[i];
                k--;
            } else {
                sum = sum + nums[i];
            }
        }
        Arrays.sort(nums);
        if (k>0){
            if (k%2 == 0){
                return sum;
            }else{
                return sum - nums[0]*2;
            }
        }else{
            return sum;
        }
    }
}
