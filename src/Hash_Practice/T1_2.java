package Hash_Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Classname T1_2
 * @Description TODO
 * @Date 2022/7/7 11:12
 * @Created by Will
 */
public class T1_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] result = T1.twoSum2(nums, target);
        System.out.println(Arrays.toString(result));
    }
    //思路：遍历数组，将全部<数,位置>存入hashmap中，然后再次遍历，当hashmap中存在target-nums[i]，则返回位置
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        HashMap<Integer,Integer> hashmap = new HashMap<>();
        int idx = 0;
        for (int i : nums){
            hashmap.put(i,idx++);
        }
        for (int t = 0; t<nums.length; t++){
            if (hashmap.containsKey(target-nums[t]) && hashmap.get(target-nums[t]) != t){
                result[0] = t;
                result[1] = hashmap.get(target-nums[t]);
            }
        }
        return result;
    }

}
