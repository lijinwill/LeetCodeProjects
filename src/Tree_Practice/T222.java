package Tree_Practice;

/**
 * @Classname T222
 * @Description TODO
 * @Date 2022/7/23 23:09
 * @Created by Will
 */
public class T222 {
    //深度优先遍历，额外定义一个变量统计节点个数
    int count = 0;
    public int countNodes(TreeNode root) {
        dfs(root);
        return count;
    }

    //这个用于深度优先遍历二叉树
    public void dfs(TreeNode root){
        if (root == null) return;

        count++;
        dfs(root.left);
        dfs(root.right);
    }
}
