package Tree_Practice;

import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/17/2022 1:17 PM
 */
public class T105_2 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
        T105_2 test = new T105_2();
        System.out.println(test.buildTree(preorder,inorder));
    }
    //递归处理，根据前序可以确定根，再根据中序可以用根将中序分成两部分，记录右侧个数，将前序再分成两部分
    //        递归处理，将分割出来的额片段继续送入buildTree
    //        注意这道题说了数字不重复
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0){
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        //找出inorder中根节点的位置i
        int i;
        for (i=0; i<inorder.length; i++){
            if (rootVal == inorder[i]) break;
        }
        int[] preorder1 = Arrays.copyOfRange(preorder,1, i+1);
        int[] inorder1 = Arrays.copyOfRange(inorder,0, i);
        int[] preorder2 = Arrays.copyOfRange(preorder,i+1, preorder.length);
        int[] inorder2 = Arrays.copyOfRange(inorder,i+1, inorder.length);
        root.left = buildTree(preorder1, inorder1);
        root.right = buildTree(preorder2, inorder2);
        return root;
    }
}
