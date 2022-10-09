package DynamicPrograming;

/**
 * @author Will
 * @version 1.0
 * @description: 看官方解析视频
 * @date 2020/12/6 20:10
 */
public class T198 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        int result = T198.rob(nums);
        System.out.println(result);
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len==0)
            return 0;
        if (len==1)
            return nums[0];


        int[] S = new int[len];

        S[0] = nums[0];
        S[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            S[i] = Math.max(S[i-1],S[i-2]+nums[i]);
        }

        return S[len-1];
    }

}
