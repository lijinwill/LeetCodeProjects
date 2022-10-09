package Tree_Practice;

/**
 * @Classname T226
 * @Description TODO
 * @Date 2022/7/20 21:39
 * @Created by Will
 */
public class T226 {
    //思路：递归遍历的时候反转所有元素，除了叶子节点 || 当然也可以层序遍历的时候入队并翻转左右孩子
    public TreeNode invertTree(TreeNode root) {
        travelTree(root);
        return root;
    }

    public void travelTree(TreeNode root){
        if (root == null){
            return;
        }else{
            if (root.left != null || root.right != null){
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
            if (root.left != null) travelTree(root.left);
            if (root.right != null) travelTree(root.right);
        }
    }
}
