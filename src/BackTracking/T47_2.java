package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-12$ $
 */
public class T47_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3};
        T47_2 test = new T47_2();
        System.out.println(test.permuteUnique(nums));

    }
    /*思路：树形结构回溯，取叶子节点，需要定义一个used数组记录已经访问过的元素
            注意同一层不能取重复的数字，因此可以用哈希集去重
    */
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return result;
    }
    public void backtracking(int[] nums, boolean[] used){
        if(path.size() == nums.length){

            result.add(new ArrayList<>(path));
        }

        //注意这个哈希集只在每一层起作用，因此定义在递归里面的for循环前面
        HashSet<Integer> hashset = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(used[i] == false && path.size()<nums.length && hashset.contains(nums[i])==false){
                hashset.add(nums[i]);
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
