package Tree_Practice;

/**
 * @Classname T112
 * @Description TODO
 * @Date 2022/7/25 23:04
 * @Created by Will
 */
public class T112 {
    //前序遍历，当前节点的处理：判断是否是叶子节点 且 值等于targetSum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null){
            if (root.val == targetSum){
                return true;
            }else{
                return false;
            }
        }

        //这里的意思是只要找到一条路径，就会一直return true向上返回递归，直到返回函数结果为true
        //如果找不到，就会按照正常前序遍历访问完全部叶子节点都是false。
        return hasPathSum(root.left,targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}
