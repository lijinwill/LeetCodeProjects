package Tree_Practice;

import java.util.ArrayList;

/**
 * @Classname T530
 * @Description TODO
 * @Date 2022/7/28 14:36
 * @Created by Will
 */
public class T530 {
    //思路：先中序遍历将全部元素记录到list中，然后遍历以便找出最小差值
    ArrayList<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < list.size()-1; i++) {
            result = Math.min(result, list.get(i+1) - list.get(i));
        }
        return result;
    }
    public void inOrder(TreeNode root){
        if (root == null) return;

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
