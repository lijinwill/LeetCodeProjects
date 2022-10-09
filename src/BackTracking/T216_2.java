package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname T216_2
 * @Description TODO
 * @Date 2022/7/30 12:50
 * @Created by Will
 */
public class T216_2 {
    //思路：和组合问题一样，只不过这道题需要求和
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationHelp(k,n,0,1);
        return result;
    }

    public void combinationHelp(int k, int n, int sum, int startIdx){
        //剪枝
        if (path.size() > k) return;

        if (path.size() == k){
            if (sum == n){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i=startIdx; i<=9-(k-path.size())+1; i++){
            path.add(i);
            combinationHelp(k,n,sum+i,i+1);
            path.remove(path.size()-1);
        }
    }
}
