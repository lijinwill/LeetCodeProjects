package Tree_Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Classname T145_2
 * @Description 迭代二刷，和前序迭代基本一致，就反一下入栈顺序，最后反一下result。
 * @Date 2022/7/15 20:43
 * @Created by Will
 */
public class T145_2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        //用一个栈存放待访问的树节点
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode temp = stack.pop();
            result.add(temp.val);

            if (temp.left != null){
                stack.add(temp.left);
            }
            if (temp.right != null){
                stack.add(temp.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
