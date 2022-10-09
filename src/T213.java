import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/6 21:43
 */
public class T213 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int result = T213.rob(nums);
        System.out.println(result);
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len==0)
            return 0;
        if (len==1)
            return nums[0];
        if (len==2)
            return Math.max(nums[0],nums[1]);
        //复制一个新数组，因为是循环数组，所以只需要第一个数据和最后一个数据不同时出现在一起就行了
        //分别计算去掉最后一个和去掉第一个数据的打家劫舍为题就ok了
        int[] nums_1 = Arrays.copyOfRange(nums,0, len-1);
        int[] nums_2 = Arrays.copyOfRange(nums,1,len);

        return Math.max(rob_1(nums_1), rob_1(nums_2));


    }

    public static int rob_1(int[] nums){
        int len = nums.length;
        int[] S = new int[len];

        S[0] = nums[0];
        S[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            S[i] = Math.max(S[i-1],S[i-2]+nums[i]);
        }

        return S[len-1];
    }

}
