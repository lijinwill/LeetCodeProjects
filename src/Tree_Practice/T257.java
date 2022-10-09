package Tree_Practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname T257
 * @Description TODO
 * @Date 2022/7/24 23:17
 * @Created by Will
 */
public class T257 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        T257 test = new T257();
        System.out.println(test.binaryTreePaths(root));
    }
    //思路：前序深度优先，用List<List<Integer>>记录所有到叶子的路径，最后再改为带->的版本

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> f_result = new ArrayList<>();
        dfs(root, path);

        //遍历result，将其转为题目要求的"1->2->5"形式
        for (List<Integer> l : result) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : l) {
                sb.append(i);
                sb.append("->");
            }
            sb.delete(sb.length()-2, sb.length());
            f_result.add(sb.toString());
        }
        return f_result;
    }

    public void dfs(TreeNode root, List<Integer> path){
        //若当前节点为空，直接返回
        if (root == null) return;

        //下面代码都是当前节点不为空的情况，不为空先在list中加入节点
        path.add(root.val);
        //如果遇到叶子节点，加入result中
        if (root.left == null && root.right == null){
            result.add(new ArrayList<>(path));
        }
        //然后继续遍历左右孩子节点
        dfs(root.left, path);
        dfs(root.right, path);

        //与前面添加root.val的代码呼应，退出每一层时都需要移除该层加入的元素
        path.remove(path.size()-1);

    }

}
