package Tree_Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname T94_2
 * @Description 中序遍历的迭代与前序后序完全不同，需要借助一个cur指针，指示当前访问节点
 * @Date 2022/7/15 20:19
 * @Created by Will
 */
public class T94_2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();

        //定义一个cur指示当前访问节点，当cur不为null，入栈，并向左深入
        //如果cur为null，说明栈里最上面的节点没有左孩子，出栈加入result，并向右深入
        //不断循环
        TreeNode cur = root;
        while(cur != null || !stack.empty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                TreeNode temp = stack.pop();
                result.add(temp.val);
                cur = temp.right;
            }
        }
        return result;
    }
}
