package Tree_Practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname T513
 * @Description TODO
 * @Date 2022/7/25 22:33
 * @Created by Will
 */
public class T513 {
    //思路：层序遍历，然后记录每一层的值，最后拿出最后一层的就好了
    public int findBottomLeftValue(TreeNode root) {
        List<ArrayList<Integer>> levelOrder = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            while(len > 0){
                TreeNode tempNode = queue.poll();
                level.add(tempNode.val);

                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
                len--;
            }
            levelOrder.add(level);
        }

        return levelOrder.get(levelOrder.size()-1).get(0);
    }
}
