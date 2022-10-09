package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-10$ $
 */
public class T491 {
    public static void main(String[] args) {
        //int[] nums = new int[]{7, 7, 7, 7};
        int[] nums = new int[]{84,-48,-33,-34,-52,72,75,-12,72,-45};
        T491 test = new T491();
        System.out.println(test.findSubsequences(nums));
    }

    /*思路：子集问题变种，只不过需要判断子集长度必须要大于2，子
            同一层子集中的元素不必连续，但是不能重复

    */
    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIdx) {
        //老样子用HashSet去重
        if (path.size() > 1) {

            result.add(new ArrayList<>(path));

        }
        HashSet<Integer> hashset = new HashSet<>();
        for (int i = startIdx; i < nums.length; i++) {
            //就是说如果path为空 或是 递增，就加入path，然后向下层递归
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) {
                continue;
            }
            //如果同一层中hashset不包含重复元素，则path加入并向下递归;否则结束这层的遍历
            if(hashset.contains(nums[i])){
                continue;
            }
            hashset.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
