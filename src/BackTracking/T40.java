package BackTracking;

import java.util.*;

public class T40 {
    public static void main(String[] args) {
        //int[] candidates = new int[]{10,1,2,7,6,1,5};
        int[] candidates = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
                ,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
                ,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

        int target = 30;
        T40 test = new T40();
        System.out.println(test.combinationSum2(candidates,target));
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }
    public void backtracking(int[] candidates, int target, int idx){
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx; i< candidates.length; i++){
            //剪枝提高效率
            if(target - candidates[i] < 0) break;
            //当同一层中有重复的元素，跳过这部分元素
            if(i>idx && candidates[i] == candidates[i-1]) continue;

            path.add(candidates[i]);
            backtracking(candidates, target-candidates[i], i+1);
            path.remove(path.size()-1);
        }
    }


























//    List<List<Integer>> result = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        dfs(candidates, target, 0);
//        return result;
//    }
//
//
//    public void dfs(int[] candidates, int target, int n){
//        if(target == 0){
//            result.add(new ArrayList(path));
//            return;
//        }
//        if(n==candidates.length || target < 0 || target<candidates[n])
//            return;
//
//        for(int i=n; i<candidates.length; i++){
//            //这个if语句用于去重代码，如果不加，会产生重复项目
//            if(i>n && candidates[i-1] == candidates[i]){
//                continue;
//            }
//            if(candidates[i] <= target){
//                path.add(candidates[i]);
//                dfs(candidates, target-candidates[i], i+1);//与T39的区别就是要i+1，每个只访问一次
//                path.remove(path.size()-1);
//            }
//        }
//    }
}
