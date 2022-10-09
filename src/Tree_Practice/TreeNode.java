package Tree_Practice;/*
*@description:这是二叉树的定义
*@author Will$
*@date 2022-04-08$ $
*@version 1.0
*/

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}