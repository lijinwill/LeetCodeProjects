package Array_Practice;

import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description:
 * @date 2020/11/12 16:23
 */
public class T27 {
    public static void main(String[] args) {
        int[] nums = new int[] {3,3};
        T27 test = new T27();
        int length = T27.removeElement(nums,5);

        System.out.println( Arrays.toString(nums) );
        System.out.println( length );
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j<nums.length; j++){
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }


}
