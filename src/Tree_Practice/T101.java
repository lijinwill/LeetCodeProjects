package Tree_Practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname T101
 * @Description TODO
 * @Date 2022/7/20 22:27
 * @Created by Will
 */
public class T101 {
    //思路：迭代法，建立队列每次比较的是对称位置
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            TreeNode tempLeft = queue.poll();
            TreeNode tempRight = queue.poll();

            //如果左右孩子都为空，则继续，因为没有孩子则无需添加孩子到队列里面，continue跳过下面的代码
            //如果左右孩子一个为空或是值不同，则返回false。
            if (tempLeft == null && tempRight == null) continue;
            if (tempLeft == null && tempRight != null) return false;
            if (tempLeft != null && tempRight == null) return false;
            if (tempLeft.val != tempRight.val) return false;

            queue.offer(tempLeft.left);
            queue.offer(tempRight.right);
            queue.offer(tempLeft.right);
            queue.offer(tempRight.left);
        }
        return true;
    }
}
