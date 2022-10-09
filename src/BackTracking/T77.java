package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T77 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        T77 test = new T77();
        System.out.println(test.combine(n,k));
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }
    public void backtracking(int n, int k, int startpoint){
        if (path.size() == k){
            result.add(new LinkedList<>(path));
            return;
        }

        for(int i=startpoint; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            backtracking(n, k , i+1);
            path.removeLast();
        }
    }

//    List<List<Integer>> result = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//
//    public List<List<Integer>> combine(int n, int k) {
//        int[] n_list = new int[n];
//        for(int i=0; i<n; i++){
//            n_list[i] = i+1;
//        }
//        dfs(n_list, k, 0);
//        return result;
//    }
//
//    public void dfs(int[] n_list, int k, int t){
//        //注意递归退出的位置一定要在for循环外面！！！
//        //血的教训
//        if(path.size() == k){
//            result.add(new ArrayList(path));
//            return;
//        }
//        for(int i=t; i<n_list.length; i++){
//            if(path.size() < k){
//                path.add(n_list[i]);
//            }
//            dfs(n_list, k, i+1);
//            path.remove(path.size()-1);
//        }
//    }
}
