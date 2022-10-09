package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname T77_2
 * @Description TODO
 * @Date 2022/7/29 22:51
 * @Created by Will
 */
public class T77_2 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        T77_2 test = new T77_2();
        System.out.println(test.combine(n,k));
    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        combineHelp(n, k, 1);
        return result;
    }

    public void combineHelp(int n, int k, int startIdx){
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i=startIdx; i<=n-(k-path.size())+1; i++){
            path.add(i);
            combineHelp(n, k, i+1);
            path.remove(path.size()-1);
        }
    }
}
