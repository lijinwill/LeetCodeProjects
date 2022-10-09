package Tree_Practice;

/**
 * @Classname T104
 * @Description TODO
 * @Date 2022/7/20 0:02
 * @Created by Will
 */
public class T104 {
    /*思路：递归 或是 层序遍历然后记录最大深度

     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else{
            int left_dep=0, right_dep=0;
            if (root.left != null){
                left_dep = maxDepth(root.left);
            }
            if (root.right != null) {
                right_dep = maxDepth(root.right);
            }
            return Math.max(left_dep,right_dep)+1;
        }
    }
}
