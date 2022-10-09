package Array_Practice;

/**
 * @Classname T209
 * @Description TODO
 * @Date 2022/7/3 13:26
 * @Created by Will
 */
public class T209 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int target = 11;
        T209 test = new T209();
        System.out.println(test.minSubArrayLen(target,nums));
    }

    /*思路：滑动窗口
        1、因为都是正数，所以添加右侧肯定变大，删减左侧肯定减小
        2、定义一个sum表示当前和
        3、定义一个left和一个right，如果当前和小于target，则right右移；如果当前和大于target，则left右移。

     */
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int sum = nums[0];
        int sumLen = 1;//记录当前数组长度
        int minSubLen = Integer.MAX_VALUE;//记录子数组最小长度

        int left = 0;
        int right = 0;

        while(right < len){
            if(sum < target){
                right++;
                if(right == len) break;
                sum = sum + nums[right];
                sumLen++;

            } else if (sum >= target) {
                minSubLen = Math.min(minSubLen, sumLen);
                sum = sum - nums[left++];
                sumLen--;
            }
        }
        if(minSubLen == Integer.MAX_VALUE){
            return 0;
        }else{
            return minSubLen;
        }
    }
}
