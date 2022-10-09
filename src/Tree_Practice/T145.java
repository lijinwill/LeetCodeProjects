package Tree_Practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname T145
 * @Description TODO
 * @Date 2022/7/12 23:01
 * @Created by Will
 */
public class T145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }
    public void postorder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }
}
