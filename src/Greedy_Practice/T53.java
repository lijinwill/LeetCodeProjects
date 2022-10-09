package Greedy_Practice;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-13$ $
 */
public class T53 {
    public static void main(String[] args) {
        //int[] nums = new int[]{1,7,4,9,2,5};
        //int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        T53 test = new T53();
        System.out.println(test.maxSubArray(nums));
    }
    /*思路：一个for遍历，从当前位置向后求和，遇到负数就放弃当前位置，并用result记录出现的最大数

     */
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;

        int localSum = 0;
        for(int i=0; i<nums.length; i++){
            localSum = localSum + nums[i];
            result = Math.max(result,localSum);
            if(localSum < 0) localSum = 0;
        }
        return result;
    }
}
