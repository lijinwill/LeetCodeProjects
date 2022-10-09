package Tree_Practice;

/**
 * @Classname T572
 * @Description TODO
 * @Date 2022/7/23 21:59
 * @Created by Will
 */
public class T572 {
    //思路：深度优先遍历，先遍历root树，如果节点值等于subRoot的根节点值，
    //      则进入类似T100的子函数中比较是否相同

    boolean result;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (root.val == subRoot.val) {
             result = compareSubTree(root, subRoot);
        }

        return result || isSubtree(root.left, subRoot) || isSubtree(root.right,subRoot);
    }

    public boolean compareSubTree(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null){
            return true;
        } else if (t1 != null && t2 == null) {
            return false;
        } else if (t1 == null && t2 != null) {
            return false;
        } else {
            if (t1.val != t2.val) return false;
        }

        return compareSubTree(t1.left, t2.left) && compareSubTree(t1.right, t2.right);
    }
}
