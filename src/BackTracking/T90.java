package BackTracking;

import java.util.*;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-10$ $
 */
public class T90 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        T90 test = new T90();
        System.out.println(test.subsetsWithDup(nums));
    }
    /*思路：
        如果把 子集问题、组合问题、分割问题都抽象为一棵树的话，那么组合问题和分割问题都是收集树的叶子节点，
        而子集问题是找树的所有节点！
    */
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    HashSet<List<Integer>> hashset = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIdx){
        if(!hashset.contains(path)){
            hashset.add(path);
            result.add(new ArrayList<>(path));
        }

        for (int i=startIdx; i< nums.length; i++){

            path.add(nums[i]);
            backtracking(nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
