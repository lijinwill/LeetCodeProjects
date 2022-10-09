package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T47 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3};
        T47 test = new T47();
        System.out.println(test.permuteUnique(nums));

    }

    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, result, 0, current);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, int idx, List<Integer> current) {
        if (idx == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            //
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false)) {
                continue;
            }
            current.add(nums[i]);
            visited[i] = true;

            backtrack(nums, result, idx + 1, current);

            visited[i] = false;
            current.remove(idx);
        }
    }
}

