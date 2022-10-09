package Tree_Practice;

/**
 * @Classname T700
 * @Description TODO
 * @Date 2022/7/27 21:01
 * @Created by Will
 */
public class T700 {
    //思路：二叉搜索树查找
    //     1、如果当前节点值小于val，则向右查找；如果大于val，则向左查找
    //     2、如果到叶子都不等于val，则返回null

    TreeNode result;
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val < val) {
            return searchBST(root.right, val);
        } else if (root.val > val) {
            return searchBST(root.left, val);
        }
        return root;
    }
}
