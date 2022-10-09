package Tree_Practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-04-20$ $
 */
public class T114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        T114 test = new T114();
        test.flatten(root);
        System.out.println(root);

    }
    /*思路：前序遍历存好节点，然后再转为单链表
     */
    public void flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        preOrder(root, list);

        //修改root
        root.left = null;
        root.right = new TreeNode(list.get(1));
        TreeNode p = root.right;
        for(int i=2; i<list.size(); i++){
            p.left = null;
            p.right = new TreeNode(list.get(i));
            p = p.right;
        }
    }

    //这里root是二叉树，list指的是遍历后的列表
    public void preOrder(TreeNode root, List<Integer> list){
        if(root == null) return;

        list.add(root.val);

        preOrder(root.left, list);
        preOrder(root.right, list);

    }
}
