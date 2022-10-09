package Tree_Practice;

/**
 * @Classname T617
 * @Description TODO
 * @Date 2022/7/27 20:30
 * @Created by Will
 */
public class T617 {
    /*思路:两棵树同时遍历
        当一颗为空，另一个不为空，则直接将不为空的返回
        当都为空，则返回null
        当都不为空，则相加两边的值，继续向下遍历
    */

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeHelp(root1,root2);
    }
    public TreeNode mergeHelp(TreeNode root1, TreeNode root2) {
        //当左右节点都为空 或 一个为空，则返回空 或 另一半
        if (root1 == null && root2 == null) return null;
        if (root1 == null && root2 != null) return root2;
        if (root1 != null && root2 == null) return root1;

        //当左右都不为空，则新建节点，求和
        TreeNode result = new TreeNode(root1.val + root2.val);
        //用递归处理左右两孩子
        result.left = mergeHelp(root1.left, root2.left);
        result.right = mergeHelp(root1.right, root2.right);
        return result;
    }
}
