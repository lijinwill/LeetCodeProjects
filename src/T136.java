import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/8 17:13
 */
public class T136 {
    public static void main(String[] args) {
        int[] test = new int[]{};
        int result = T136.singleNumber(test);
        System.out.println(result);
    }
    public static int singleNumber(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int i;
        int j;
        for (i = 0,j = 1; j<nums.length; i=i+2,j=j+2) {
            if (nums[i] == nums[j]){
                continue;
            }else{
                break;
            }
        }
        return nums[i];
    }
}
