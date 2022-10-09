package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname T39_2
 * @Description TODO
 * @Date 2022/8/1 19:58
 * @Created by Will
 */
public class T39_2 {
    public static void main(String[] args) {
        int[] candidate = new int[]{6, 3,3, 2, 7};
        int target = 7;
        T39_2 test = new T39_2();
        System.out.println(test.combinationSum(candidate, target));
    }
    //回溯，但是待选元素是可以重复的，因为要全部遍历，所以递归无需返回值
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        //先candidates去重复元素
        List<Integer> candidatesList = new ArrayList<>();
        for (int i=0; i<len-1; i++){
            if (candidates[i] != candidates[i+1]) candidatesList.add(candidates[i]);
        }
        candidatesList.add(candidates[len-1]);
        //Collections.sort(candidatesList);

        combinationHelp(candidatesList, target, 0, 0);
        return result;
    }
    public void combinationHelp(List<Integer> candidatesList, int target, int sum, int starIdx){
        if (sum > target) return;
        if (sum == target){
            result.add(new ArrayList<>(path));
        }

        for (int i = starIdx; i < candidatesList.size(); i++) {
            int val = candidatesList.get(i);
            path.add(val);
            combinationHelp(candidatesList, target, sum+val, i);
            path.remove(path.size()-1);
        }
    }
}
