package Tree_Practice;

/**
 * @Classname T100
 * @Description TODO
 * @Date 2022/7/23 21:25
 * @Created by Will
 */
public class T100 {
    //思路：两颗树同时深度优先遍历，如果遍历到结束都是相同的，则相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }else if (p == null && q != null) {
            return false;
        }else if (p != null && q == null) {
            return false;
        }else {
            if (p.val != q.val) return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
