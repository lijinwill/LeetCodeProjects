package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname T40_2
 * @Description TODO
 * @Date 2022/8/1 20:32
 * @Created by Will
 */
public class T40_2 {
    public static void main(String[] args) {
        //int[] candidates = new int[]{10,1,2,7,6,1,5};
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        T40_2 test = new T40_2();
        System.out.println(test.combinationSum2(candidates,target));
    }
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        combinationHelp(candidates, target, 0);
        return result;
    }
    public void combinationHelp(int[] candidates, int target, int startInx){
        if (target < 0) return;
        if (target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i=startInx; i<candidates.length; i++){
            int val = candidates[i];
            //需要排除同一层中的重复，而第一个重复又不需要排除
            if (i != startInx && candidates[i-1] == val) continue;
            path.add(val);
            combinationHelp(candidates,target- val,i+1);
            path.remove(path.size()-1);
        }
    }
}
