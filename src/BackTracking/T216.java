package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-06$ $
 */
public class T216 {
    public static void main(String[] args) {
        int k = 3, n=9;
        T216 test = new T216();
        System.out.println(test.combinationSum3(k,n));
    }
    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1);

        return result;
    }
    //因为每个数字只能使用一次，所以有idx进去递归
    public void backtracking(int k ,int target, int idx){
        //两种递归退出条件，一个是目标小于0，直接退出，
        // 另一个是path大小已经达到k
        if(target<0) return;
        if(path.size() == k){
            if(target == 0) result.add(new ArrayList<>(path));
            return;
        }

        for(int i=idx; i<10; i++){
            //剪枝
            if(target - i < 0) break;
            path.add(i);
            backtracking(k, target-i, i+1);
            path.remove(path.size()-1);
        }
    }
}
