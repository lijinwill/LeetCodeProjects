package Tree_Practice;

import java.util.ArrayList;
import java.util.List;

public class T637 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        T637 test = new T637();
        System.out.println(test.averageOfLevels(root));
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        recur(root,0);
        List<Double> average = new ArrayList<>();
        //这里取每层平均值
        for(int i=0; i<result.size(); i++){
            double temp = 0;
            int level_size = 0;
            for(int j=0; j<result.get(i).size(); j++){
                temp = temp + result.get(i).get(j);
                level_size++;
            }
            average.add(temp/level_size);
        }
        return average;
    }

    //这里处理得到层序遍历结果
    public void recur(TreeNode root, int deep){
        if (root == null){
            return;
        }

        deep++;
        if (result.size() < deep){
            List<Integer> sub_result = new ArrayList<>();
            result.add(sub_result);
        }
        result.get(deep-1).add(root.val);

        recur(root.left, deep);
        recur(root.right, deep);
    }
}
