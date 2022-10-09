package Tree_Practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname T94
 * @Description TODO
 * @Date 2022/7/12 23:06
 * @Created by Will
 */
public class T94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    public void inorder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}
