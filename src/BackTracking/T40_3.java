package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/14/2022 11:48 AM
 */
public class T40_3 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationHelp(candidates, target, 0);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public void combinationHelp(int[] candidates, int target, int idx){
        if (target < 0) return;
        if (target == 0){
            result.add(new ArrayList<>(path));
        }

        for (int i = idx; i < candidates.length; i++) {
            //同一层不能有重复，但不同层可以重复
            if (i != idx && candidates[i-1] == candidates[i]) continue;
            path.add(candidates[i]);
            combinationHelp(candidates, target-candidates[i], i+1);
            path.remove(path.size()-1);
        }
    }
}
