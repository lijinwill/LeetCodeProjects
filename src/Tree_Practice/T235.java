package Tree_Practice;

/**
 * @Classname T235
 * @Description TODO
 * @Date 2022/7/28 19:25
 * @Created by Will
 */
public class T235 {
    //思路：区别于普通二叉树，二叉搜索树的公共祖先只会是p、q分列两侧这一种可能
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果p和q都在左侧，则root向左递归
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        //剩下的是分列两侧的情况，就是所需的结果
        return root;
    }
}
