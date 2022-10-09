package Tree_Practice;/*
 * @description: TODO
 * @author Will$
 * @date 2022-04-12$ $
 * @version 1.0
 */

import java.util.ArrayList;

public class T98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        T98 test = new T98();
        System.out.println(test.isValidBST(root));

    }

    //思路：中序遍历所有节点，生成一个数组，然后判断数组是否递增
    ArrayList<Integer> tree = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for(int i=0; i<tree.size()-1; i++){
            if(tree.get(i) > tree.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        tree.add(root.val);
        inorder(root.right);
    }
}
