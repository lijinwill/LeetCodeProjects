package Tree_Practice;

import java.util.ArrayList;

/**
 * @Classname T98_2
 * @Description TODO
 * @Date 2022/7/28 14:12
 * @Created by Will
 */
public class T98_2 {
    //思路：中序遍历下，二叉搜索树的结果是递增的\
    ArrayList<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inOrder(root);

        for (int i = 0; i<list.size()-1; i++) {
            if (list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode root){
        if (root == null) return;

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
