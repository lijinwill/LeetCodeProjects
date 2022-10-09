package Tree_Practice;

import java.util.LinkedList;

/**
 * @Classname T111
 * @Description TODO
 * @Date 2022/7/20 21:25
 * @Created by Will
 */
public class T111 {
    //思路：层序遍历，当出现没有左右孩子的节点就直接返回当前深度。
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;
        while (!queue.isEmpty()){
            int len = queue.size();
            while(len > 0){
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);

                if (tempNode.left == null && tempNode.right == null) return depth;
                len--;
            }
            depth++;
        }
        return depth;
    }
}
