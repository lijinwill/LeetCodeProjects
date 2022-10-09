package Tree_Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname T144_2
 * @Description TODO
 * @Date 2022/7/15 20:00
 * @Created by Will
 */
public class T144_2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        //用一个栈存放待访问的树节点
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode temp = stack.pop();
            result.add(temp.val);

            if (temp.right != null){
                stack.add(temp.right);
            }
            if (temp.left != null){
                stack.add(temp.left);
            }
        }
        return result;
    }
}
