package Tree_Practice;

/**
 * @Classname T701
 * @Description TODO
 * @Date 2022/7/29 17:52
 * @Created by Will
 */
public class T701 {
    //思路：前序遍历，类似于二叉搜索树的查找，只不过肯定找不到，找不到的位置插入即可
    //      注意这道题有个重要的额事情是递归只找一条路径，所以需要返回值！！！
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //当递归向下到叶子节点，就是需要插入的位置，生成需要插入的节点后返回该节点
        if (root == null){
            TreeNode insertNode = new TreeNode(val);
            return insertNode;
        }

        //对于每一个考察的节点，如果它是叶子，就将下一层返回的叶子接上去；
        // 如果不是叶子，就将下一层的节点接上去，其实相当于什么都没做，只是为了返回退出递归而已
        if (root.val < val){
            TreeNode rightNode = insertIntoBST(root.right, val);
            root.right = rightNode;
            return root;
        }else if (root.val > val){
            TreeNode leftNode = insertIntoBST(root.left, val);
            root.left = leftNode;
            return root;
        }

        return root;
    }
}
