package Tree_Practice;/*
 * @description: TODO
 * @author Will$
 * @date 2022-4-11$ $
 * @version 1.0
 */

public class T404 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-9);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(-6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(0);
        root.right.left.left = new TreeNode(-5);

        T404 test = new T404();
        System.out.println(test.sumOfLeftLeaves(root));
    }
    //思路：前序遍历，当前节点的左子树的左子树为null，左子树的右子树也为null
    //              则当前节点的左孩子是叶子

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        recur(root);
        return sum;
    }
    public void recur(TreeNode root){
        if(root == null) return;
        //这里的意思是，对于没有左孩子但是有右孩子的节点，继续遍历右孩子
        if(root.left == null){
            recur(root.right);
            return;
        }

        if(root.left.left == null && root.left.right == null){
            sum = sum + root.left.val;
        }
        recur(root.left);
        recur(root.right);
    }
}
