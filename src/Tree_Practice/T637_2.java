package Tree_Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname T637_2
 * @Description TODO
 * @Date 2022/7/18 22:15
 * @Created by Will
 */
public class T637_2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        T637_2 test = new T637_2();
        test.averageOfLevels(root);
        System.out.println(root);
    }

    //层序遍历，边遍历边统计每一层的和，当统计完的时候除以一行的节点个数
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            int temp = len;
            double sum = 0;
            while(len > 0){
                TreeNode tempNode = queue.poll();
                sum = sum + tempNode.val;

                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);

                len--;
            }
            result.add(sum/temp);
        }
        return result;
    }
}
