package BackTracking;

import java.util.*;

public class T39 {
    public static void main(String[] args) {
        int[] candidate = new int[]{2, 3, 6, 7};
        int target = 7;
        T39 test = new T39();
        System.out.println(test.combinationSum(candidate, target));
    }

    List<List<Integer>> result = new ArrayList<>();//记录结果
    ArrayList<Integer> path = new ArrayList<>();//用于记录当前符合要求的数组

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }
    //第三个变量idx的意义是，比如当我遍历到第二个位置时，我不再考虑第一个位置的元素。
    public void backtracking(int[] candidates, int target, int idx) {
        //如果目标到0，表明找出路径;如果小于0，表明不存在，直接返回
        if (target == 0) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            //下面这行代码可以剪枝，大幅减少回溯的量
            if (target - candidates[i] < 0) break;
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i);
            path.remove(path.size()-1);
        }
    }








//    List<List<Integer>> result = new ArrayList<>();//记录结果
//    List<Integer> current = new ArrayList<>();//用于记录当前符合要求的数组

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        dfs(candidates, target, 0);
//        return result;
//    }
//
//    public void dfs(int[] candidates, int target, int n){
//        if(target < 0)//第一步先判断target是否合法，如果不合法直接返回，进如下一步回退
//            return;
//        if(target == 0){
//            result.add(new ArrayList(current));
//            return;
//        }
//        for(int i=n; i<candidates.length; i++){
//            if(candidates[i] <= target){
//                current.add(candidates[i]);
//                dfs(candidates, target-candidates[i], i);
//                current.remove(current.size()-1);
//            }
//        }
//    }

/*    List<List<Integer>> res = new ArrayList<>(); //记录答案
    List<Integer> path = new ArrayList<>();  //记录路径

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target);
        return res;
    }

    public void dfs(int[] c, int u, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = u; i < c.length; i++) {
            if (c[i] <= target) {
                path.add(c[i]);
                dfs(c, i, target - c[i]); // 因为可以重复使用，所以还是i
                path.remove(path.size() - 1); //回溯，恢复现场
            }
        }
    }*/
}
