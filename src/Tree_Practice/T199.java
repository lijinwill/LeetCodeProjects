package Tree_Practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname T199
 * @Description TODO
 * @Date 2022/7/18 22:00
 * @Created by Will
 */
public class T199 {
    //思路：先层序遍历二叉树，没当len=1的时候，表明当前是本层最右侧元素，需要存储得到右视图list
    //      层序遍历用队列记录下一层的元素，以及len记录当前层还剩余的元素
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            while(len > 0){
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);

                if (len == 1) result.add(temp.val);
                len--;
            }
        }
        return result;
    }
}
