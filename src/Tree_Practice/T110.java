package Tree_Practice;

/**
 * @Classname T110
 * @Description TODO
 * @Date 2022/7/24 22:16
 * @Created by Will
 */
public class T110 {
    //思路：后序深度优先遍历
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1 ? true : false;
    }

    public int getHeight(TreeNode root){
        if (root == null) return 0;

        //后续遍历，先访问左右节点
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // 当左子树不平衡 或 右子树不平衡 或 左右子树高度差大于1 ，都返回-1，
        // 至于为什么返回的是-1，是为了连续跳出全部的递归
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
