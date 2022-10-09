import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/8 20:47
 */
public class T169 {
    public static void main(String[] args) {
        int[] test = new int[]{1};
        int result = T169.majorityElement(test);
        System.out.println(result);

    }

    public static int majorityElement(int[] nums) {

        Arrays.sort(nums);

        return nums[nums.length / 2];
    }

}
