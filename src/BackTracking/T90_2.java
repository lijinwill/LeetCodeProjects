package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname T90_2
 * @Description TODO
 * @Date 2022/8/3 20:38
 * @Created by Will
 */
public class T90_2 {
    //思路：和子集Ⅰ类似，只不过需要跳过重复的元素
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort( nums );
        subsetsHelp(nums,0);
        return result;
    }
    public void subsetsHelp(int[] nums, int idx){
        result.add(new ArrayList<>(path));

        for (int i=idx; i<nums.length; i++){
            if (i != idx && nums[i-1] == nums[i]){
                continue;
            }
            path.add(nums[i]);
            subsetsHelp(nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
