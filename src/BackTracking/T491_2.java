package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Classname T491_2
 * @Description TODO
 * @Date 2022/8/4 22:41
 * @Created by Will
 */
public class T491_2 {
    //思路：类似于组合问题，只不过需要使用到所有节点而非 只考虑叶子节点

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        findHelp(nums, 0);
        return result;
    }
    public void findHelp(int[] nums, int idx){
        if (path.size() >= 2){
            result.add(new ArrayList<>(path));
        }

        //这个hashset的目的是排除同一层中的重复元素
        HashSet<Integer> hashset = new HashSet<>();
        for (int i=idx; i<nums.length; i++){
            if (!hashset.contains(nums[i])){
                hashset.add(nums[i]);
            }else{
                continue;
            }

            //path末尾元素 < 当前层访问的元素，则加入path
            if (path.isEmpty() || path.get(path.size()-1) <= nums[i]){
                path.add(nums[i]);
            }else{
                continue;
            }
            findHelp(nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
