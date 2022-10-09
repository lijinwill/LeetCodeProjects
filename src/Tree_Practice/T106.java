package Tree_Practice;

import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/17/2022 1:45 PM
 */
public class T106 {
    public static void main(String[] args) {
        int[] preorder = {9,3,15,20,7}, inorder = {9,15,7,20,3};
        T106 test = new T106();
        System.out.println(test.buildTree(preorder,inorder));
    }
    //递归处理，根据前序可以确定根，再根据中序可以用根将中序分成两部分，记录右侧个数，将前序再分成两部分
    //        递归处理，将分割出来的额片段继续送入buildTree
    //        注意这道题说了数字不重复
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0){
            return null;
        }
        int len = postorder.length;
        int rootVal = postorder[len-1];
        TreeNode root = new TreeNode(rootVal);
        //找出inorder中根节点的位置i
        int i;
        for (i=0; i<inorder.length; i++){
            if (rootVal == inorder[i]) break;
        }
        int[] inorder1 = Arrays.copyOfRange(inorder,0, i);
        int[] postorder1 = Arrays.copyOfRange(postorder,0, i);
        int[] inorder2 = Arrays.copyOfRange(inorder,i+1, inorder.length);
        int[] postorder2 = Arrays.copyOfRange(postorder,i, postorder.length-1);
        root.left = buildTree(inorder1, postorder1);
        root.right = buildTree(inorder2, postorder2);
        return root;
    }
}
