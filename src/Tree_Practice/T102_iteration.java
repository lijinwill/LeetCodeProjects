package Tree_Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T102_iteration {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        T102_iteration test = new T102_iteration();
        System.out.println(test.levelOrder(root));
    }

    public List<List<Integer>> resList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun02(root);

        return resList;
    }

    //BFS--迭代方式--借助队列
    public void checkFun02(TreeNode node) {
        if (node == null) return;

        //建一个队列
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(node);

        while (!que.isEmpty()) {
            //每层的元素
            List<Integer> level = new ArrayList<Integer>();
            int que_len = que.size();

            while (que_len > 0) {
                TreeNode tmpNode = que.poll();
                level.add(tmpNode.val);

                if (tmpNode.left != null) que.add(tmpNode.left);
                if (tmpNode.right != null) que.add(tmpNode.right);
                que_len--;
            }

            resList.add(level);
        }
    }
}
