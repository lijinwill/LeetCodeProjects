package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname T78_2
 * @Description TODO
 * @Date 2022/8/2 22:23
 * @Created by Will
 */
public class T78_2 {
    //思路：有点类似于全排列，只不过不可重复选择
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        subsetsHelp(nums, 0);
        return result;
    }
    public void subsetsHelp(int[] nums, int idx){
        result.add(new ArrayList<>(path));

        for (int i=idx; i<nums.length; i++){
            path.add(nums[i]);
            subsetsHelp(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
