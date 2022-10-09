/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/11/13 14:30
 */
public class T53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        T53 test = new T53();
        System.out.println(test.maxSubArray(nums));

    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
}
