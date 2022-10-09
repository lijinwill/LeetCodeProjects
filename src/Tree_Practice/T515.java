package Tree_Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname T515
 * @Description TODO
 * @Date 2022/7/19 23:27
 * @Created by Will
 */
public class T515 {
    /*思路：又是层序遍历，不同的地方是每一层一边遍历一边统计最大值

     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            int maxLevelVal = Integer.MIN_VALUE;
            while(len > 0){
                TreeNode tempNode = queue.poll();
                maxLevelVal = Math.max(tempNode.val,maxLevelVal);

                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);

                len--;
            }
            result.add(maxLevelVal);
        }
        return result;
    }
}
