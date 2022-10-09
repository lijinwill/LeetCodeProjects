package Tree_Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname T102
 * @Description 层序遍历借助队列迭代
 * @Date 2022/7/16 20:16
 * @Created by Will
 */
public class T102 {
    //思路：用队列保存下一层待访问元素
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        //定义len表示待出去的这一一层队列的长度
        //访问到这一层时，将这一层的元素全部出队，并新入队出去元素的左右子节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> subList = new ArrayList<>();

            while(len > 0){
                TreeNode tempNode = queue.poll();
                len--;
                subList.add(tempNode.val);

                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
            }

            result.add(subList);
        }
        return result;
    }
}
