package Tree_Practice;/*
 * @description: TODO
 * @author Will$
 * @date 2022-04-12$ $
 * @version 1.0
 */

import java.util.Arrays;

public class T105 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        T105 test = new T105();

        System.out.println(test.buildTree(preorder, inorder));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0||inorder.length==0){
            return null;
        }
        TreeNode root = new TreeNode (preorder[0]);
        for (int i=0; i<inorder.length; i++){
            if(preorder[0] == inorder[i]){
                root.left = buildTree( Arrays.copyOfRange(preorder,1,i+1),
                                        Arrays.copyOfRange(inorder,0,i) );
                root.right = buildTree( Arrays.copyOfRange(preorder,i+1,preorder.length),
                                        Arrays.copyOfRange(inorder,i+1,inorder.length) );
                break;
            }
        }
        return root;
    }
}

