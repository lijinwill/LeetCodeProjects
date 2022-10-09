package Tree_Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T113 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int targetSum = 3;
        T113 test = new T113();
        System.out.println(test.pathSum(root, targetSum));
    }

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return result;
    }
    public void dfs(TreeNode root, int targetSum){
        if (root == null){
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right == null){
            if (root.val == targetSum){
                result.add(new ArrayList<>(path));
            }
        }

        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
        path.removeLast();
    }
}
