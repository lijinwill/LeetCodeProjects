package Tree_Practice;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname T144
 * @Description TODO
 * @Date 2022/7/12 22:51
 * @Created by Will
 */
public class T144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }
    public void preorder(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
}
