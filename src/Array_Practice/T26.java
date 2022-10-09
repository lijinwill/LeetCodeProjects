package Array_Practice;

import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/11/12 15:37
 */
public class T26 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,2,2,2,3,4,5,5,5,6};
        T26 test = new T26();
        int length = T26.removeDuplicates(nums);

        System.out.println( Arrays.toString(nums) );
        System.out.println( length );

    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] == nums[j]){
                continue;
            }else{
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
