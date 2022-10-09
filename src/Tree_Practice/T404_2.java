package Tree_Practice;

/**
 * @Classname T404_2
 * @Description TODO
 * @Date 2022/7/25 22:10
 * @Created by Will
 */
public class T404_2 {
    //思路：前序遍历，一旦遇到叶子节点，且是左子树的，就求和
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        preOrder(root);
        return sum;
    }

    public void preOrder(TreeNode root){
        if (root == null) return;

        if (root.left != null && root.left.left == null && root.left.right == null){
            sum = sum + root.left.val;
        }

        preOrder(root.left);
        preOrder(root.right);
    }
}
