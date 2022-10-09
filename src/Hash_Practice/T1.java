package Hash_Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/16 20:26
 */
public class T1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] result = T1.twoSum2(nums, target);
        System.out.println(Arrays.toString(result));

    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> my_hashmap = new HashMap<>();
        int i = 0;
        while( i<nums.length ){
            if( !my_hashmap.containsKey(target-nums[i]) ){
                my_hashmap.put(nums[i], i);
            }else {
                return new int[]{ my_hashmap.get(target-nums[i]) , i } ;
            }
            i++;
        }
        return new int[0];
    }



    //暴力解法
    public static int[] twoSum1(int[] nums, int target) {
        int[] arr = new int[2];

        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if( (nums[i] + nums[j]) == target ){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;

                }
            }
        }
        return null;
    }

}
