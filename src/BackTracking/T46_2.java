package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-12$ $
 */
public class T46_2 {
    public static void main(String[] args) {
        //int[] nums = new int[]{1, 2, 3};
        int[] nums = new int[]{1};
        T46_2 test = new T46_2();
        System.out.println(test.permute(nums));
    }
    //思路：树形结构回溯，取叶子节点，需要定义一个used数组记录已经访问过的元素
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return result;
    }
    public void backtracking(int[] nums, boolean[] used){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
        }

        for(int i=0; i<nums.length; i++){
            if(used[i] == false && path.size()<nums.length){
                path.add(nums[i]);
                used[i] = true;
            }else{
                continue;
            }
            backtracking(nums,used);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}
