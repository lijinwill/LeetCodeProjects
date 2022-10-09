package Tree_Practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname T113_2
 * @Description TODO
 * @Date 2022/7/26 21:57
 * @Created by Will
 */
public class T113_2 {
    //思路：先前序遍历统计所有到叶子节点的路径，并用targetSum-root.val，
    //      如果相减后为0，则找到一条路径，加入result中

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        preOrder(root, targetSum);
        return result;
    }

    public void preOrder(TreeNode root, int targetSum){
        if (root == null) return;

        path.add(root.val);
        if (root.left == null && root.right == null && targetSum - root.val == 0){
            result.add(new ArrayList<>(path));
        }

        preOrder(root.left, targetSum - root.val);
        preOrder(root.right, targetSum - root.val);
        path.remove(path.size()-1);
    }
}
