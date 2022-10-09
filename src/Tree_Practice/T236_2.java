package Tree_Practice;

/**
 * @Classname T236_2
 * @Description TODO
 * @Date 2022/7/28 16:05
 * @Created by Will
 */
public class T236_2 {
    //思路：后序遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || root==p || root==q){
            return root;
        }

        //这个left，right表示是否找出p或q，找出则返回p、q位置，找不出则返回null
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //对于当前节点root，如果没找到p和q，则返回null
        if (left == null && right == null){
            return null;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        }else {
            return root;
        }
    }
}
